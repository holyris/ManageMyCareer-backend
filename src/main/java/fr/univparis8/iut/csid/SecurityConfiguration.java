package fr.univparis8.iut.csid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  public DataSource dataSource;

  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().disable().authorizeRequests()
            .antMatchers("/**").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable();
    http.headers().frameOptions().sameOrigin();

  }
}