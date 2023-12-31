package com.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.security.password.PasswordEncode;

@Configuration
@EnableWebSecurity
public class SecurityConfiger extends WebSecurityConfigurerAdapter{

	@Autowired
	private PasswordEncode passwordEncode;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests()
		.antMatchers("/emp").hasAnyRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails build = User.builder().username("Ronak").password(passwordEncode.password().encode("Ronak@123")).roles("USER").build();
		return new InMemoryUserDetailsManager(build);
	}
	
}
  