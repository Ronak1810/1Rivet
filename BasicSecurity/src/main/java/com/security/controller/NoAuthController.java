package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class NoAuthController {
	
	@GetMapping("/getMsg")
	public String getMsg() {
		return "my name is ronak";
	}

}
