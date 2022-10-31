package com.springboot.movie.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.movie.model.MovieInfo;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping("")
	public List<MovieInfo> getMovies() {
		return movieService.getAllMovies();
	}
	
	@RequestMapping("/{id}")
	public MovieInfo getMovieById(@PathVariable String id) {
		return movieService.getMovie(id);
	}
	
}
