package com.user.controller;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.model.CatalogItem;
import com.user.model.Movie;
import com.user.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{userId1}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {
		
//		List<Rating> ratingList = Arrays.asList(
//		 new Rating("12345", 4),
//		 new Rating("56789", 5)
//		); 
				
		ResponseEntity<Rating[]> userRating = restTemplate.getForEntity("http://localhost:8082/ratingsdata/users/" + userId, Rating[].class);
		
		Rating[] ratingArray = userRating.getBody();
		List<Rating> ratingList = Arrays.asList(ratingArray);
		
		return ratingList.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getId(), Movie.class);
			return new CatalogItem(movie.getName(), "DESC", rating.getRating());
		})
		.collect(Collectors.toList());
		
	}
}
