package com.eshipping.fba.service;

import java.util.List;
import java.util.Map;

import com.eshipping.fba.entity.City;
import com.eshipping.fba.entity.FreightCalculation;
import com.eshipping.fba.entity.TaxRate;


/**
 * 
* @ClassName: CityService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月7日 下午6:13:00 
*
 */
public interface CityService {

  /** 查询所有
  * @Title: findAll 
  * @Description: TODO(这里用一句话描述这个方法的作用) 
  * @return List<Map<Object,Object>>    返回类型
   */
    
    List<Map<Object,Object>> findAll();
    
    void addEntirePdf();
    
    void addCity(City city);
    
    City findUserByUserName(String name);
    
    void updateUserById(City city);
    
    void deleteUserById(Long id);
    

	void addFright(List<FreightCalculation> excelToList);
	
	void addTaxRate(List<TaxRate> excelToList);
    
   

}
