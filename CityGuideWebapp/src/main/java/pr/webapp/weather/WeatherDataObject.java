package pr.webapp.weather;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import pr.webapp.weatherDTO.Coord;
import pr.webapp.weatherDTO.Main;
import pr.webapp.weatherDTO.Sys;
import pr.webapp.weatherDTO.Weather;

@Data
@NoArgsConstructor
@Service
public class WeatherDataObject {

	private Weather[] weather;
	private Main main;
	private Map<String, Object> optional = new HashMap<>();
	private Coord coord;
	private Sys sys;
}
