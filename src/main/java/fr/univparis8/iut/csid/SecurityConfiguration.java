package fr.univparis8.iut.csid;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  public final DataSource dataSource;

  public SecurityConfiguration(DataSource dataSource){
    this.dataSource = dataSource;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().disable().authorizeRequests()
            .antMatchers("/users/create_user").permitAll()
            /*.antMatchers("/**").permitAll()*/
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .addFilter(new JsonAuthentificationFilter(authenticationManager(), new ObjectMapper()));

    http.headers().frameOptions().sameOrigin();
    http.cors().configurationSource(corsConfigurationSource());

//    http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public JdbcUserDetailsManager jdbcUserDetailsManager(){
    JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
    userDetailsService.setDataSource(dataSource);
    return userDetailsService;
  }
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS"));
    configuration.setAllowedHeaders(Arrays.asList("*"));
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }


}