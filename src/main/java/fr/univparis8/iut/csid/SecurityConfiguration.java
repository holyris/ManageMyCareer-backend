package fr.univparis8.iut.csid;

import org.springframework.context.annotation.Bean;
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
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  public final DataSource dataSource;

  public SecurityConfiguration(DataSource dataSource){
    this.dataSource = dataSource;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().disable().authorizeRequests()
            .antMatchers("/**").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable();
    http.headers().frameOptions().sameOrigin();
    http.cors().configurationSource(corsConfigurationSource());
  }

//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.jdbcAuthentication().dataSource(dataSource)
//            .withUser(
//                    User.withUsername("admin")
//                            .password(passwordEncoder().encode("admin"))
//                            .authorities(AuthorityUtils.createAuthorityList("ADMIN")).build()
//            );
///*
//            .usersByUsernameQuery(
//                    "select username,password, enabled from users where username=?")
//            .authoritiesByUsernameQuery(
//                    "select username, authority from authorities where username=?")
//            .passwordEncoder(new BCryptPasswordEncoder());
//*/
//
//    auth.userDetailsService(jdbcUserDetailsManager());
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public JdbcUserDetailsManager jdbcUserDetailsManager() {
    JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
    userDetailsService.setDataSource(dataSource);
    return userDetailsService;
  }
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET","POST", "DELETE", "PUT", "PATCH", "OPTIONS"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }


}