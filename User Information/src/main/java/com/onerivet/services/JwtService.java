package com.onerivet.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
	
	public String generateToken(String userName);

	public String extractUserName(String token);

	public boolean validateToken(String token, UserDetails userDetails);

}
