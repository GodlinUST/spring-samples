package com.springsecurity;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private Filter securityFilter;
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		UserDetails user = User.withUsername("Godlin").password(passwordEncoder.encode("Oliver")).authorities("read").build();
		userDetailsService.createUser(user);
		
		auth.userDetailsService(userDetailsService);
	}
	*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
	}
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/hello").authenticated().anyRequest().denyAll();
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().antMatchers("/hello").authenticated();
		http.addFilterBefore(securityFilter, BasicAuthenticationFilter.class);
	}
	
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
