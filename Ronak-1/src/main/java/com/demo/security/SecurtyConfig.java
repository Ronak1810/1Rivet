//package com.demo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecurtyConfig{
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
//		http
//		.csrf()
//		.disable()
//		.cors()
//		.and()
//		.authorizeHttpRequests().requestMatchers("/user/get-all").fullyAuthenticated()
//		.httpBasic();
//		return http.build();
//		
//	}
//
//}
