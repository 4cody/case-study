package com.cedardrone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//import com.cedar.fullstackexample.services.UserService;

@Controller
public class MainController {
	
//	private UserService userService;
	
//	@Autowired
//	public HomeController(UserService userService) {
//		this.userService = userService;
//	}
	
	@GetMapping("/")
	public String showLandingPage() {
		return "landing";
	}
}
