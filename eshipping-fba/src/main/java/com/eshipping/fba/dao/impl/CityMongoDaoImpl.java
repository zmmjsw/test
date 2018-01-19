package com.eshipping.fba.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.eshipping.fba.dao.CityMongoDao;
import com.eshipping.fba.entity.City;

@Component
public class CityMongoDaoImpl implements CityMongoDao{
	@Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public void saveCity(City city) {
		mongoTemplate.save(city);
		
	}

	@Override
	public City findCityByName(String name) {
		 Query query=new Query(Criteria.where("userName").is(name));
		 City user =  mongoTemplate.findOne(query , City.class);
		return user;
	}

	@Override
	public void updateCity(City city) {
		  Query query=new Query(Criteria.where("id").is(city.getId()));
	        Update update= new Update().set("userName", city.getCityName()).set("description", city.getDescription());
	        //更新查询返回结果集的第一条
	        mongoTemplate.updateFirst(query,update,City.class);
	        //更新查询返回结果集的所有
	        // mongoTemplate.updateMulti(query,update,UserEntity.class);
		
	}

	@Override
	public void removeCityById(Long id) {
		 Query query=new Query(Criteria.where("id").is(id));
	        mongoTemplate.remove(query,City.class);
	}

}
