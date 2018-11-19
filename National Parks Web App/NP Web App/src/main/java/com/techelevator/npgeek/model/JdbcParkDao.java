package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllReviews = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReviews);
		while(results.next()) {
			Park park = new Park();
			populatePark(results, park);
			allParks.add(park);
		}
		return allParks;
	}

	private void populatePark(SqlRowSet results, Park park) {
		park.setParkCode(results.getString("parkcode"));
		park.setParkName(results.getString("parkname"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationinfeet"));
		park.setMilesOfTrail(results.getDouble("milesoftrail"));
		park.setNumberOfCampsites(results.getInt("numberofcampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		park.setQuote(results.getString("inspirationalquote"));
		park.setQuoteSource(results.getString("inspirationalquotesource"));
		park.setDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
	}

	@Override
	public Park getParkByCode(String parkCode) {
		Park park = new Park();
		String sqlSelectAllReviews = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReviews, parkCode);
		while(results.next()) {
			populatePark(results, park);
		}

		return park;
	}

	@Override
	public List <Weather> getWeatherByParkCode(String parkCode) {
		List <Weather> parkWeatherDays = new ArrayList<>();
		String sqlSelectAllReviews = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReviews, parkCode);
		while(results.next()) {
			Weather weather = new Weather();
			populateWeather(results, weather);
			parkWeatherDays.add(weather);
		}

		return parkWeatherDays;
	}

	private void populateWeather(SqlRowSet results, Weather weather) {
		
		String forecast = results.getString("forecast");
		int low = results.getInt("low");
		int high = results.getInt("high");
		
		weather.setParkCode(results.getString("parkcode"));
		weather.setDay(results.getInt("fivedayforecastvalue"));
		weather.setLow(low);
		weather.setHigh(high);
		weather.setForecast(forecast);
		weather.setAdvisory(new Advisory(forecast, low, high));
	}
	
	
	

}
