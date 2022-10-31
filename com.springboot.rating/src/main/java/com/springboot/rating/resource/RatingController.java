package com.springboot.rating.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rating.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@RequestMapping("")
	public List<UserRating> getRatings() {
		return ratingService.getRatings();
	}

	@RequestMapping("/{userId}")
	public UserRating getRating(@PathVariable String userId) {
		return ratingService.getRating(userId);
	}

}
