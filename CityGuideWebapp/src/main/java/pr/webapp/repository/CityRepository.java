package pr.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pr.webapp.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	public City findByName(String cityName);

}
