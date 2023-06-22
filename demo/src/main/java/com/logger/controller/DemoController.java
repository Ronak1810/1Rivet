package com.logger.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logger.DemoApplication;


@RestController
@RequestMapping("/api/deskbook")
public class DemoController {
	
	static Logger logger = LogManager.getLogger(DemoApplication.class);

	
	@GetMapping("/ronak")
	public String test() {
		logger.info("info level message ");		
		logger.warn("warn level message ");	
		logger.error("error level message ");	
		logger.debug("debug level message ");
		logger.trace("trace level message ");
		 
		return "Hello I am Ronak";
	}

}
