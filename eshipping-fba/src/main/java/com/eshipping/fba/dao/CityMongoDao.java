package com.eshipping.fba.dao;

import com.eshipping.fba.entity.City;

public interface CityMongoDao {
	void saveCity(City city);

	City findCityByName(String name);

	void updateCity(City city);

	void removeCityById(Long id);

}
