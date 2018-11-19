package com.techelevator.npgeek.model;

public class Advisory {
	
	private String forecast;
	private int low;
	private int high;
	private String advisory = "";
	


	public Advisory(String forecast, int low, int high) {
		this.forecast = forecast;
		this.low = low;
		this.high = high;
		setString();
	}
	
	
	
	
	
	
	
	public String getAdvisory() {
		return advisory;
	}







	private void setString() {
		switch(forecast) {
		
		case "rain":
			
			advisory+="Please pack rain gear and wear waterproof shoes. ";
			break;
		case "snow":
			advisory+="Please pack snow shoes. ";
			break;
		case "sunny":
			advisory+="Please pack sunblock. ";
			break;
		case "thunderstorms":
			advisory+="Please seek shelter and avoid hiking on exposed ridges. ";
			break;	
		}
		
		if(high > 75) {
			advisory+="Please bring an extra gallon of water. ";
		}
		
		if(low < 20) {
			advisory+="Please take precautions. Frigid temperatures are expected. ";
		}
		
		if((high - low) > 20) {
			advisory+="Wear breathable layers :P ";
		}
		
	}
}
