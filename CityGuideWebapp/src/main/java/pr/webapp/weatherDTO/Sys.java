package pr.webapp.weatherDTO;

import lombok.Data;

@Data
public class Sys {

	private int type;
	private int id;
	private float message;
	private String country;
	private long sunrise;
	private long sunset;
}
