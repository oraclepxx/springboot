package com.springboot.catalog.model;

public class MovieInfo {

	private String id;
	private String name;
	private String summary;

	public MovieInfo() {

	}

	public MovieInfo(String id, String name, String summary) {
		this.id = id;
		this.name = name;
		this.summary = summary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
