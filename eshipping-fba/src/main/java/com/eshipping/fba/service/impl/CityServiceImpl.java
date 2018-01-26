package com.eshipping.fba.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.eshipping.fba.dao.CityDao;
import com.eshipping.fba.entity.City;
import com.eshipping.fba.service.CityService;



/**
 * 
* @ClassName: CityServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月7日 下午6:12:54 
*
 */
@Service
public class CityServiceImpl implements CityService {
	
	 


    @Autowired
    private CityDao cityDao;
    @Autowired
    private MongoTemplate mongoTemplate;


	@Override
	public List<Map<Object, Object>> findAll() {
		return cityDao.findAll();
	}
	
	@Override
	public void addEntirePdf() {
		try {
			cityDao.addEntireCabinet(getlistitem2());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static List<Map<String,Object>> getlistitem2() throws IOException {
		List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
		File file = new File("C://Users//lixi2000//Desktop//LabelData.xlsx");
		InputStream is = new FileInputStream(file);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		// 获取每一个工作薄
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// 获取当前工作薄的每一行
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					XSSFCell UniqueRef = xssfRow.getCell(0);
					XSSFCell jboNumber = xssfRow.getCell(1);
					XSSFCell servicecode = xssfRow.getCell(2);
					XSSFCell ServiceCentre = xssfRow.getCell(3);
					XSSFCell TourId = xssfRow.getCell(4);
					XSSFCell RoutingCode = xssfRow.getCell(5);
				
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("UniqueRef",UniqueRef.toString());
					map.put("jboNumber",jboNumber.toString());
					map.put("servicecode",servicecode.toString());
					map.put("ServiceCentre",ServiceCentre.toString());
					map.put("TourId",TourId.toString());
					map.put("RoutingCode",RoutingCode.toString());
					
					list1.add(map);
				}
			}
		}
		return list1;
	}
	
	
	


	@Override
	public void addCity(City city) {
		mongoTemplate.save(city);
		
	}
	
	/*@Override
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
	}*/

	@Override
	public City findUserByUserName(String name) {
		Query query=new Query(Criteria.where("cityName").is(name));
		 City user =  mongoTemplate.findOne(query , City.class);
		 return user;
	}

	@Override
	public void updateUserById(City city) {
		  Query query=new Query(Criteria.where("id").is(city.getId()));
	        Update update= new Update().set("cityName", city.getCityName()).set("description", city.getDescription());
	        //更新查询返回结果集的第一条
	        mongoTemplate.updateFirst(query,update,City.class);
	        //更新查询返回结果集的所有
	        // mongoTemplate.updateMulti(query,update,UserEntity.class);
		
	}

	@Override
	public void deleteUserById(Long id) {
		 Query query=new Query(Criteria.where("id").is(id));
	        mongoTemplate.remove(query,City.class);
		
	}
	
	


	


	

	


}
