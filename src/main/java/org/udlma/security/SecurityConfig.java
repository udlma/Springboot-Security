package org.udlma.security;

import static org.assertj.core.api.Assertions.shouldHaveThrown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@EnableWebSecurity
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UdlmaDetailsService udlmaUserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("security config..............");
	    
	    http.authorizeRequests().antMatchers("/guest/**").permitAll();
	    
	    http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
	    
	    http.formLogin().loginPage("/login");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	   auth.userDetailsService(udlmaUserService).passwordEncoder(passwordEncoder());

	}
	
	@Bean
	  public PasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	  }

	
	

}
