package pr.webapp.weatherDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@Data
@JsonTypeName("coord")
public class Coord {

	@JsonProperty
	private float lon;
	@JsonProperty
	private float lat;

}
