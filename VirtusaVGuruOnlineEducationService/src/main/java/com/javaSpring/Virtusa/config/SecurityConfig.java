package com.javaSpring.Virtusa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import lombok.AllArgsConstructor;
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers(
				"/signup",
				"/virtusa/student/**",
				"/videos/{name}",
				"/js/**",
				"/css/**",
				"/bootstrap/**",
				"/img/**,")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("http://localhost:4200/select",true)
		.and()
		.httpBasic()	
		.and()
		.csrf()
		.disable();
		http.cors();
		
	}
}
