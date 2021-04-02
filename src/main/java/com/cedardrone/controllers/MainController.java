package com.cedardrone.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cedardrone.models.Drone;
import com.cedardrone.models.User;
import com.cedardrone.services.DroneService;
import com.cedardrone.services.UserService;

@Controller
public class MainController {
	
	private UserService userService;
	private DroneService droneService;
	
	@Autowired
	public MainController(UserService userService, DroneService droneService) {
		this.userService = userService;
		this.droneService = droneService;
	}
	
	@GetMapping("/")
	public String showLandingPage() {
		return "landing";
	}
	
	@PostMapping("/login")
	public String processLoginRequest(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
		
		try {
			User user = userService.findByUsername(username);
			List<Drone> drones = droneService.getAllDrones();
			
			drones.forEach(d -> System.out.println(d.toString()));
			
			if(user != null && password.equals(user.getPassword())) {
				session.setAttribute("currentUser", user);
				
				return "welcome";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			return "landing";
		}
		
		model.addAttribute("loginFailedMessage", "Login Failed");
		return "landing";
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerNewUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		System.out.println(user.toString());
		
		if(result.hasErrors()) {
			return "register";
		}
		
		userService.saveUser(user);
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String showWelcomePage(Model model) {
		model.addAttribute("user", new User());
		return "welcome";
	}
}
