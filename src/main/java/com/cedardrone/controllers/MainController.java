package com.cedardrone.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cedardrone.models.Drone;
import com.cedardrone.models.Review;
import com.cedardrone.models.User;
import com.cedardrone.services.DroneService;
import com.cedardrone.services.ReviewService;
import com.cedardrone.services.UserService;

@Controller
public class MainController {
	
	private UserService userService;
	private DroneService droneService;
	private ReviewService reviewService;
	
	@Autowired
	public MainController(UserService userService, DroneService droneService, ReviewService reviewService) {
		this.userService = userService;
		this.droneService = droneService;
		this.reviewService = reviewService;
	}
	
	@GetMapping("/")
	public String showLandingPage() {
		
		return "index";
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
		}
		
		model.addAttribute("loginFailedMessage", "Login Failed");
		
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		
		model.addAttribute("user", new User());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerNewUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		userService.saveUser(user);
		
		return "index";
	}
	
	@GetMapping("/welcome")
	public String showWelcomePage(Model model, HttpSession session) {
		
		List<Drone> drones = droneService.getAllDrones();
		
		session.setAttribute("droneList", drones);

		return "welcome";
	}
	
//	@RequestMapping(value="/drones/{droneId}", method = RequestMethod.GET)
//	public String showDronePage(@PathVariable String droneId, Model model, HttpSession session) {
//
//		Drone d = droneService.findByDroneId(Integer.parseInt(droneId));
//		List<Review> r = d.getReviewList();
//
//		model.addAttribute("currentDrone", d);
//		model.addAttribute("reviewList", r);
//		
//		return "drone";
//	}
//	
//	@GetMapping("/drones/{droneId}/review")
//	public String showLeaveReviewPage(Model model) {
//
//		model.addAttribute("review", new Review());
//		
//		return "review";
//	}
//	
//	@PostMapping("/drones/{droneId}/review")
//	public String handleDroneReview(@PathVariable String droneId,@Valid @ModelAttribute("review") Review review, BindingResult result, HttpSession session) {				
//
//		User user = (User) session.getAttribute("currentUser");
//		
//		review.setUser(user);
//		
//		if(!droneService.saveReview(Integer.parseInt(droneId), review )) {
//			System.out.println("Can't leave multiple reviews");
//			return "redirect:/drones/{droneId}";
//		}
//
//		
//		return "redirect:/drones/{droneId}";
//	}
//	
//	@RequestMapping(value="/drones/{droneId}/review/{rId}/edit", method = RequestMethod.GET)
//	public String showEditReviewPage(@PathVariable String rId, Model model) {
//		Review review = reviewService.findByRid(Integer.parseInt(rId));
//		
//		model.addAttribute("reviewToEdit", review);
//		
//		return "edit_review";
//	}
//	
//	@PostMapping("/drones/{droneId}/review/{rId}/edit")
//	public String handleEditReview(@PathVariable String rId, @ModelAttribute("reviewToEdit") Review review, BindingResult result) {
//
//		
//		if(reviewService.editReview(review, Integer.parseInt(rId))) {
//			return "redirect:/drones/{droneId}";
//		}
//		
//		return "redirect:/welcome";
//		
//	}
//	
////	@DeleteMapping("/reviews/{rId}/delete")
////	public String handleDeleteReview(@PathVariable String droneId) {
////		System.out.println("Delete mapping was hit");
////		
////		return "redirect:/drones/{droneId}";
////	}
	
}
