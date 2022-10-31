package com.springboot.movie.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.movie.model.MovieInfo;

@Service
public class MovieService {

	private List<MovieInfo> mock = new ArrayList<MovieInfo>(Arrays.asList(
		new MovieInfo("1000", "Black mirror", "good"), 
		new MovieInfo("1001", "Yellow mirror", "good"),
		new MovieInfo("1002", "Black mirror", "skjfdkjskfjsdfkjskdf"), 
		new MovieInfo("1003", "White mirror", "good")
	));

	public List<MovieInfo> getAllMovies() {
		return mock;
	}

	public List<MovieInfo> getMovies(String name) {
		List<MovieInfo> m = new ArrayList<>();
		MovieInfo[] mArr = (MovieInfo[]) mock.stream().filter(t -> name.equals(t.getName())).toArray();
		for (MovieInfo mi : mArr) {
			m.add(mi);
		}
		return m;

	}

	public MovieInfo getMovie(String id) {
		return mock.stream().filter(t -> id.equals(t.getId())).findFirst().get();
	}

}
