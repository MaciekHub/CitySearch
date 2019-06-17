package pr.webapp.weatherDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@Data
@JsonTypeName("main")
public class Main {

	@JsonProperty
	private float temp;
	@JsonProperty
	private int humidity;
	@JsonProperty
	private float pressure;
	@JsonProperty
	private float temp_min;
	@JsonProperty
	private float temp_max;

}
