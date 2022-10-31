package com.springboot.rating.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.rating.model.Rating;
import com.springboot.rating.model.UserRating;

@Service
public class RatingService {

	public List<UserRating> getRatings() {
		List<UserRating> mockRatings = mockData();
		return mockRatings;
	}
	
	public UserRating getRating(String userId) {
		List<UserRating> mockRatings = mockData();
		return mockRatings.stream().filter(t -> userId.equals(t.getUserId())).findFirst().get();
	}
	
	private List<UserRating> mockData() {
		List<Rating> mockRatings = new ArrayList<Rating>(
				Arrays.asList(new Rating("1000", 4), new Rating("1001", 5), new Rating("1002", 4), new Rating("1003", 2)));

		List<UserRating> userRatingList = new ArrayList<UserRating>(
				Arrays.asList(new UserRating("foo", mockRatings), new UserRating("bar", mockRatings)));

		return userRatingList;
	}
	
	
}
