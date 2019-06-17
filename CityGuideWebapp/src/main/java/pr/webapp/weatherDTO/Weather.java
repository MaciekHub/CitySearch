package pr.webapp.weatherDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@Data
@JsonTypeName("weather")
public class Weather {

	@JsonProperty
	private int id;
	@JsonProperty
	private String main;
	@JsonProperty
	private String description;
	@JsonProperty
	private String icon;

}
