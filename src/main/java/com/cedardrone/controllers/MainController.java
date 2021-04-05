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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cedardrone.models.Drone;
import com.cedardrone.models.Review;
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
	public String handleLoginRequest(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
		
		try {
			User user = userService.findByUsername(username);
			
			if(user != null && password.equals(user.getPassword())) {
				session.setAttribute("currentUser", user);
				
				return "redirect:/welcome";
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
	public String showWelcomePage(Model model, HttpSession session) {

		
		List<Drone> drones = droneService.getAllDrones();
//		drones.forEach(d -> System.out.println(d.toString()));
		
		session.setAttribute("droneList", drones);
		
		model.addAttribute("drone", new Drone());
//		model.addAttribute("user", new User());
		return "welcome";
	}
	
	@RequestMapping(value="/drones/{droneId}", method = RequestMethod.GET)
//	@GetMapping("/drones/{droneId}")
//	public String printWelcome(@PathVariable String droneId, Model model, BindingResult result) {
	public String printWelcome(@PathVariable String droneId, Model model) {

		
//		if(result.hasErrors()) {
//			return "welcome";
//		}
		
		Drone d = droneService.findByDroneId(Integer.parseInt(droneId));
		System.out.println("Drone: ");
		System.out.println(d.toString());
		
//		model.addAttribute("drone", new Drone());
		model.addAttribute("currentDrone", d);
		
		return "drone";
	}
	
	@GetMapping("/drones/{droneId}/review")
	public String showLeaveReviewPage(Model model) {
		model.addAttribute("review", new Review());
		return "review";
	}
	
	@PostMapping("/drones/{droneId}/review")
	public String handleNewReview(@Valid @ModelAttribute("review") Review review, BindingResult result) {
		System.out.println(review.toString());
		
		if(result.hasErrors()) {
			return "register";
		}
		
		return "redirect:/welcome";
	}
	
}
