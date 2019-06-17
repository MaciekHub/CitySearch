package pr.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CityGuideWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityGuideWebappApplication.class, args);
	}

}
