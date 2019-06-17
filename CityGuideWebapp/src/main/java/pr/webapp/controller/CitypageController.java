package pr.webapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pr.webapp.impl.CityServiceImpl;
import pr.webapp.weather.WeatherRequestSender;

@RestController
public class CitypageController {

	@Autowired
	private WeatherRequestSender requestSender;
	@Autowired
	private CityServiceImpl updateCitySearches;
	Map<String, Object> weatherDataMap = new HashMap<>();

	@GetMapping("/getCity")
	public ModelAndView city(@RequestParam(value = "cityName") String cityName) {
		final ModelAndView mView = new ModelAndView("city");
		mView.addObject("city", toUpperCase(cityName));
		weatherDataMap = requestSender.sendRequest(cityName);
		mView.addAllObjects(weatherDataMap);
		if (!weatherDataMap.getOrDefault("statusCode", 404).toString().equals("200")) {
			mView.setViewName("home");
		} else {
			updateCitySearches.update(cityName);
		}
		return mView;
	}

//	@RequestMapping("/getCity/${cityName}")
//	public void saveSearchedCity(@PathVariable(value = "cityName") String cityName) {
//		updateCitySearches.update(cityName);
//	}

	public String toUpperCase(String word) {
		if (!word.equals(""))
			return word.substring(0, 1).toUpperCase() + word.substring(1);
		else
			return "";
	}

}
