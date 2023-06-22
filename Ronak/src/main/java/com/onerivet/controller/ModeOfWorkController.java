package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.payload.ModeOfWorkDto;
import com.onerivet.service.ModeOfWorkServices;

@RestController
@RequestMapping("/api/deskbook")
public class ModeOfWorkController {
	
	@Autowired
	private ModeOfWorkServices modeOfWorkServices;
	
	@GetMapping("/mode-of-works")
	private  List<ModeOfWorkDto> getModeOfWork(){
		return modeOfWorkServices.getAllModeOfWorks();
	}

}
