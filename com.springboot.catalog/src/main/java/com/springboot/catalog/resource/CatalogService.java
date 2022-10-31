package com.springboot.catalog.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.catalog.model.Catalog;
import com.springboot.catalog.model.MovieInfo;
import com.springboot.catalog.model.Rating;
import com.springboot.catalog.model.UserRating;

@Service
public class CatalogService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogs")
	public List<Catalog> getCatalogs() {
		List<Catalog> catalogs = new ArrayList<Catalog>();
		UserRating[] userRatings = restTemplate.getForObject("http://rating-service/ratings", UserRating[].class);

		for (UserRating userRating : userRatings) {
			List<Rating> ratings = userRating.getRatings();
			for (Rating rating : ratings) {
				MovieInfo movie = restTemplate.getForObject("http://movie-service/movies/" + rating.getMovieId(), MovieInfo.class);
				catalogs.add(new Catalog(userRating.getUserId(), movie.getName(), movie.getSummary(), rating.getRating()));
			}
		}

		return catalogs;
	}

	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<Catalog> getCatalog(String userId) {
		List<Catalog> catalogs = new ArrayList<Catalog>();
		UserRating userRating = restTemplate.getForObject("http://rating-service/ratings/" + userId, UserRating.class);
		List<Rating> ratings = userRating.getRatings();
		for (Rating rating : ratings) {
			MovieInfo movie = restTemplate.getForObject("http://movie-service/movies/" + rating.getMovieId(), MovieInfo.class);
			catalogs.add(new Catalog(userId, movie.getName(), movie.getSummary(), rating.getRating()));
		}
		return catalogs;
	}

	public List<Catalog> getFallbackCatalogs() {
		return new ArrayList<>();
	}

	public List<Catalog> getFallbackCatalog(String userId) {
		return new ArrayList<>();
	}

}
