package com.user.model;

public class Rating {

	private String id;
	
	public Rating(String id, int rating) {
		this.id = id;
		this.rating = rating;
	}
	
	public Rating() {
		
	}
			
	private int rating;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
