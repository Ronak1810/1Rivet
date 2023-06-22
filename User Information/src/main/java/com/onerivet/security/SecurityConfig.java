package com.onerivet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.onerivet.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtAuthFilter authFilter;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		return new UserInfoUserDetailsService();
	}

	//@Bean
	//public UserDetailsService userdetailsService(PasswordEncoder encoder) {
//		UserDetails admin = User.withUsername("Ronak")
//				.password(encoder.encode("Ronak@123"))
//				.roles("ADMIN")
//				.build();
//		UserDetails user = User.withUsername("Jakey")
//				.password(encoder.encode("Jakey@123"))
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(admin, user);
		
				
		
	
	
	@Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 return  http.cors().and().csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/api/information/add","/api/information/authenticate","/api/information/get-user").permitAll()
					.anyRequest().authenticated()
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and().authenticationProvider(daoAuthenticationProvider())
					.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
					.build();
	    }
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;

	}


		@Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }
	    

}
