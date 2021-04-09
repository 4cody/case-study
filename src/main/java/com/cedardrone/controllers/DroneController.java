package com.cedardrone.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cedardrone.models.Drone;
import com.cedardrone.models.Review;
import com.cedardrone.models.User;
import com.cedardrone.services.DroneService;
import com.cedardrone.services.ReviewService;

@RequestMapping("/drones")
@Controller
public class DroneController {
	
	private DroneService droneService;
	private ReviewService reviewService;
	
	@Autowired
	public DroneController(DroneService droneService, ReviewService reviewService) {
		this.droneService = droneService;
		this.reviewService = reviewService;
	}
	
	@RequestMapping(value="/{droneId}", method = RequestMethod.GET)
	public String showDronePage(@PathVariable String droneId, Model model, HttpSession session) {

		Drone d = droneService.findByDroneId(Integer.parseInt(droneId));
		List<Review> r = d.getReviewList();

		model.addAttribute("currentDrone", d);
		model.addAttribute("reviewList", r);
		
		return "drone";
	}
	
	@GetMapping("/{droneId}/review")
	public String showLeaveReviewPage(Model model) {

		model.addAttribute("review", new Review());
		
		return "review";
	}
	
	@PostMapping("/{droneId}/review")
	public String handleDroneReview(@PathVariable String droneId,@Valid @ModelAttribute("review") Review review, BindingResult result, HttpSession session) {				

		User user = (User) session.getAttribute("currentUser");
		
		review.setUser(user);
		
		if(!droneService.saveReview(Integer.parseInt(droneId), review )) {
			System.out.println("Can't leave multiple reviews");
			return "redirect:/drones/{droneId}";
		}

		
		return "redirect:/drones/{droneId}";
	}
	
	@RequestMapping(value="/{droneId}/review/{rId}/edit", method = RequestMethod.GET)
	public String showEditReviewPage(@PathVariable String rId, @PathVariable String droneId, Model model) {
		Review review = reviewService.findByRid(Integer.parseInt(rId));
		
		model.addAttribute("reviewToEdit", review);
		model.addAttribute("droneId", droneId);
		
		return "edit_review";
	}
	
	@PostMapping("/{droneId}/review/{rId}/edit")
	public String handleEditReview(@PathVariable String rId, @PathVariable String droneId, @ModelAttribute("reviewToEdit") Review review, BindingResult result) {

		
		if(reviewService.editReview(review, Integer.parseInt(rId))) {
			if(droneService.updateRating(Integer.parseInt(droneId), review.getRating(), Integer.parseInt(rId))) {
				return "redirect:/drones/{droneId}";
			}
		}
		
		return "redirect:/welcome";
		
	}
	
	@PostMapping("/{droneId}/review/{rId}/delete")
	public String handleDeleteReview(@PathVariable String droneId, @PathVariable String rId) {

		if(reviewService.deleteReview(Integer.parseInt(rId))) {
			System.out.println("Success for level 1 ");
			
			droneService.removeReview(Integer.parseInt(rId), Integer.parseInt(droneId));
		}

		return "redirect:/drones/{droneId}";
	}

}
