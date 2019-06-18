package pr.webapp.weather;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class WeatherMapper {

	@Autowired
	private WeatherDataObject weatherObject;
	Map<String, Object> weatherDataMap = new HashMap<>();

	public Map<String, Object> getWeatherData(Map<String, Object> weatherDataMap, String json) {
		final ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			weatherObject = mapper.readValue(json, WeatherDataObject.class);
			weatherDataMap.put("temperature", weatherObject.getMain().getTemp());
			weatherDataMap.put("main", weatherObject.getWeather()[0].getMain());
			weatherDataMap.put("latitude", weatherObject.getCoord().getLat());
			weatherDataMap.put("longitude", weatherObject.getCoord().getLon());
			weatherDataMap.put("country", weatherObject.getSys().getCountry());
			weatherDataMap.put("description", weatherObject.getWeather()[0].getDescription());
			weatherDataMap.put("statusCode", 200);

		} catch (final JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weatherDataMap;

	}

}
