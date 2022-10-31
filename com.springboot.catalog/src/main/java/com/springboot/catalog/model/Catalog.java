package com.springboot.catalog.model;

public class Catalog {

	private String userId;
	private String movieName;
	private String movieDesc;
	private int rating;

	public Catalog() {
	}

	public Catalog(String userId, String movieName, String movieDesc, int rating) {
		super();
		this.userId = userId;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public int getRating() {
		return rating;
	}

	public void setMovieRating(int rating) {
		this.rating = rating;
	}

}
