package com.eshipping.fba;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eshipping.fba.dao.CityMongoDao;
import com.eshipping.fba.entity.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDaoTest {
	 @Autowired
	    private CityMongoDao cityMongoDao;

	    @Test
	    public void testSaveUser() throws Exception {
	        City city=new City();
	        city.setId(2L);
	        city.setCityName("上海");
	        city.setDescription("上海是个美丽的城市");
	        city.setProvinceId(301L);
	        cityMongoDao.saveCity(city);
	    }

	 /*   @Test
	    public void findUserByUserName(){
	       UserEntity user= userDao.findUserByUserName("小明");
	       System.out.println("user is "+user);
	    }

	    @Test
	    public void updateUser(){
	        UserEntity user=new UserEntity();
	        user.setId(2l);
	        user.setUserName("天空");
	        user.setPassWord("fffxxxx");
	        userDao.updateUser(user);
	    }

	    @Test
	    public void deleteUserById(){
	        userDao.deleteUserById(1l);
	    }*/

}
