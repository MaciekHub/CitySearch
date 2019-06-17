package pr.webapp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pr.webapp.interfaces.CityService;
import pr.webapp.model.City;
import pr.webapp.repository.CityRepository;

@Service
@Repository
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepository;

	@Override
	public void update(String s) {
		try {
			City city = cityRepository.findByName(s);
			if (city != null) {
				cityRepository.delete(city);
				city.setSearchesNumber(city.getSearchesNumber() + 1);
			} else {
				city = createCityObject(s);
				city.setSearchesNumber(new Long(1));
			}
			cityRepository.save(city);
		} catch (final Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public City createCityObject(String cityName) {
		final City city = new City();
		city.setName(cityName);
		return city;
	}

}
