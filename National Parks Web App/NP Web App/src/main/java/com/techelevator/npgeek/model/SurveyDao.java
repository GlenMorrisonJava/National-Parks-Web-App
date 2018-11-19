package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDao {

	void save(Survey survey);
	List<FavoritePark> getAllFavoriteParks();

	
	
}
