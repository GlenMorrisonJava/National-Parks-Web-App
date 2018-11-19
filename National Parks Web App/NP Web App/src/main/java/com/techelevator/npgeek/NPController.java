package com.techelevator.npgeek;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.techelevator.npgeek.model.FavoritePark;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.Weather;

@SessionAttributes("convert")
@Controller
public class NPController {
	
	private String convert;
	
	@Autowired 
	private ParkDao parkDao;
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping("/")
	public String showHomePage(ModelMap modelHolder) {
		List<Park> allParks = parkDao.getAllParks();
		modelHolder.put("allParks", allParks);
		return "homePage";
	}
	
	@RequestMapping("/detailPage")
	public String showDetailPage(@RequestParam String parkCode, ModelMap modelHolder) {
		Park selectedPark = parkDao.getParkByCode(parkCode);
		modelHolder.put("park", selectedPark);
		List <Weather> parkWeatherDays = parkDao.getWeatherByParkCode(parkCode);
		modelHolder.put("allWeather", parkWeatherDays);
		return "detailPage";
	}
	
	@RequestMapping(path="/detailPage", method=RequestMethod.POST)
	public String newDetailPage(@RequestParam String convert, String parkCode, ModelMap modelHolder) {
		this.convert = convert;
		modelHolder.addAttribute("convert", convert);
		Park selectedPark = parkDao.getParkByCode(parkCode);
		modelHolder.put("park", selectedPark);
		List <Weather> parkWeatherDays = parkDao.getWeatherByParkCode(parkCode);
		modelHolder.put("allWeather", parkWeatherDays);

		return "detailPage";
	}
	
	@RequestMapping("/survey")
	public String showSurveyPage(ModelMap modelHolder) {
		if( ! modelHolder.containsAttribute("Survey")) {
			modelHolder.addAttribute("Survey", new Survey());
		}
		List<Park> allParks = parkDao.getAllParks();
		modelHolder.put("allParks", allParks);
		return "surveyPage";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurvey(
			@Valid @ModelAttribute("Survey") Survey registerFormValues,
			BindingResult result,
			RedirectAttributes flash,
			@RequestParam String parkName, String emailAddress, String state, String activityLevel){
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", registerFormValues);
			return "redirect:/survey";
		}
		
		Survey addSurvey = new Survey();
		addSurvey.setParkCode(parkName);
		addSurvey.setEmailAddress(emailAddress);
		addSurvey.setState(state);
		addSurvey.setActivityLevel(activityLevel);
		surveyDao.save(addSurvey);
		
		flash.addFlashAttribute("message", "You have voted.");
		
		return "redirect:/favorites";
	}
	
	@RequestMapping("/favorites")
	public String showFavoritesPage(ModelMap modelHolder) {
		List<FavoritePark> allFavoriteParks = surveyDao.getAllFavoriteParks();
		modelHolder.put("allFavoriteParks", allFavoriteParks);
		return "favoritesPage";
	}
	
	
	

}
