package com.eshipping.fba.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.eshipping.fba.entity.FreightCalculation;
import com.eshipping.fba.entity.SysRole;
import com.eshipping.fba.entity.TaxRate;
import com.eshipping.fba.entity.UserInfo;

/**
 * 
 * @ClassName: CityDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2017年12月7日 下午5:56:33
 *
 */
@Repository
public interface CityDao {
	/** 查询所有哈哈
	 * @Title: findAll
	 * @Description: TODO(查询所有)
	 * @return List<Map<Object,Object>> 返回类型
	 */
	List<Map<Object, Object>> findAll();

	void addEntireCabinet(List<Map<String, Object>> list);
	
	void addFreight(List<FreightCalculation> list);

	void addTaxRate(List<TaxRate> excelToList);


}
