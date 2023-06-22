package com.onerivet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.onerivet.password.PasswordEncode;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Autowired
	private PasswordEncode passwordEncode;
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.csrf().disable()
//			.cors()
//			.and()
//			.authorizeHttpRequests()//.requestMatchers("/api/view-by-id/{id}").authenticated()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.httpBasic();
//		
//		return http.build();
//	}
	
	@Bean
	UserDetailsService detailsService() {
		UserDetails user = User.builder()
				.username("Ronak")
				.password(this.passwordEncode.password().encode("Ronak@123"))
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("Jakey")
				.password(this.passwordEncode.password().encode("Jakey@123"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}

}
