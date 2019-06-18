package pr.webapp.weatherDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@Data
@JsonTypeName("sys")
public class Sys {

	@JsonProperty
	private int type;
	@JsonProperty
	private int id;
	@JsonProperty
	private float message;
	@JsonProperty
	private String country;
	@JsonProperty
	private long sunrise;
	@JsonProperty
	private long sunset;
}
