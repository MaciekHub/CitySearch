package pr.webapp.weatherDTO;

import java.lang.reflect.Array;

import lombok.Data;

@Data

public class OpenWeatherData {

	private Coord coord;
	private Sys sys;
	private Weather weather;
	private String base;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private long dt;
	private long id;
	private String name;
	private int code;
	
	
}
