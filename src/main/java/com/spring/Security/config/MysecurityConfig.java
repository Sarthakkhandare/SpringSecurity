package com.spring.Security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableMethodSecurity
public class MysecurityConfig   {

	
	@Bean
	public PasswordEncoder Encoder() {
		 return new BCryptPasswordEncoder();
	}


	@Bean
	public UserDetailsService detailsService() {
		
		
		UserDetails normaluser=User
				.withUsername("sarthak")
				.password(Encoder().encode("12345"))
				.roles("NORMAL")
				.build();
		
		
		UserDetails adminuser=User
				.withUsername("admin")
				.password(Encoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		
		
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new 
				InMemoryUserDetailsManager(normaluser,adminuser);	
		
		return inMemoryUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		
		.requestMatchers("/home/admin")
		.hasRole("ADMIN")
		
//		.requestMatchers("/home/normal")  using advance in controller class method level anotation
//		.hasRole("NORMAL")
		
		.requestMatchers("/home/public")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
	}
	
	

}
