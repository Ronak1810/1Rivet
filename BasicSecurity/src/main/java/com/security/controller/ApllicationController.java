package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApllicationController {
	
	@GetMapping("/msg")
	public String message() {
		return "Hello I am Ronak";
	}

}
