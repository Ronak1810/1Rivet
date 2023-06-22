package com.onerivet.congif.security;


import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors()
			.and()
			.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/user").permitAll()
					.anyRequest().authenticated())
			.oauth2ResourceServer()
			.jwt();
		return http.build();
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		
//		http
//			.cors()
//		.and()
//			.authorizeHttpRequests(
//					(authorize)->authorize.requestMatchers("/user/").permitAll()
//					.anyRequest().authenticated()
//					)
//			.oauth2ResourceServer().jwt();
//		
//		return http.build();
//		
//	}
	
	@Bean
	public JwtDecoder jwtDecoder(OAuth2ResourceServerProperties properties) {
		
		NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(properties.getJwt().getJwkSetUri()).build();
//		OAuth2TokenValidator<Jwt> defaultValidator = new JwtTimestampValidator();
//		OAuth2TokenValidator<Jwt> audienceValidator = new CustomValidator(properties.getJwt().getAudiences());
//		jwtDecoder.setJwtValidator(new DelegatingOAuth2TokenValidator<>(defaultValidator,audienceValidator));
		return jwtDecoder;
		
	}
}
