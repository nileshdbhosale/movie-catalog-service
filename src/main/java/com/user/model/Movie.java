package com.user.model;

public class Movie {

	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public Movie(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Movie() {
		
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
	
}
