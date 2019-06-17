package pr.webapp.weather;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.Data;
import lombok.NoArgsConstructor;
import pr.webapp.interfaces.RequestSender;

@Data
@NoArgsConstructor
@Service
public class WeatherRequestSender implements RequestSender {

	@Autowired
	WeatherMapper weatherMapper;
	Map<String, Object> weatherDataMap = new HashMap<>();
	private static final String apiKey = "77087552a736e3e92bc7d0c3bbe5b531";
	String apiRequest = "http://api.openweathermap.org/data/2.5/weather?units=metric&q=";

	@Override
	public Map<String, Object> sendRequest(String s) {
		final RestTemplate restTemplate = new RestTemplate();
		final String request = apiRequest + s + "&appid=" + apiKey;
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.getForEntity(request, String.class);
			weatherDataMap = weatherMapper.getWeatherData(weatherDataMap, response.getBody());
			weatherDataMap.put("statusCode", 200);
		} catch (final RestClientException e) {
			System.out.println("$$$WRONG CODE$$$");
			e.printStackTrace();
			weatherDataMap.put("statusCode", 404);
		}
		return weatherDataMap;
	}
}
