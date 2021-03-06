package com.eshipping.fba.controller;


import java.io.InputStream;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eshipping.fba.dao.CityMongoDao;
import com.eshipping.fba.entity.City;
import com.eshipping.fba.entity.FreightCalculation;
import com.eshipping.fba.entity.Pdf;
import com.eshipping.fba.entity.TaxRate;
import com.eshipping.fba.entity.Testq;
import com.eshipping.fba.service.CityService;
import com.eshipping.fba.service.SysPermissionService;
import com.eshipping.fba.util.ExcelUtil;



/**
 * 
* @ClassName: CityController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月7日 下午5:55:57 
*
 */
@RestController
public class CityController {

	private Logger logger = LoggerFactory.getLogger(CityController.class);
	
    @Autowired
    private CityService cityService;
    
	@Autowired
	private SysPermissionService sysPermissionService;
	
	

    
    @RequestMapping(value = "/api/addCity", method = RequestMethod.POST)
    public String addCity(@RequestBody City city) {
	        cityService.addCity(city);
        return cityService.findAll().toString();
    }
    
   
    
    @RequestMapping(value = "/api/findCity", method = RequestMethod.POST)
    public City findCity(@RequestParam(value = "name")String name) {
        return 	cityService.findUserByUserName(name);
    }
    
    @RequestMapping(value = "/api/updateCity", method = RequestMethod.POST)
    public String updateCity(@RequestBody City city) {
	        cityService.updateUserById(city);
        return cityService.findAll().toString();
    }
    
    @RequestMapping(value = "/api/deleteCity", method = RequestMethod.POST)
    public String deleteCity(@RequestParam(value = "id")Long id) {
	        cityService.deleteUserById(id);
        return cityService.findAll().toString();
    }
    

    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:admin")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }
    

    @RequestMapping("/view")
    @RequiresPermissions("userInfo:user")//权限管理;
    public String wiew(){
        return "userInfoAdd";
    }
    
    @RequestMapping(value = "/api/input", method = RequestMethod.POST)
 public String input(@RequestParam(value="filename") MultipartFile file,  
            HttpServletRequest request,HttpServletResponse response) throws Exception {
 
    	System.out.println("heh");
    	 //判断文件是否为空  
     /*   if(file==null){  
         return "文件不能为空！";  
        }  
        //获取文件名  
        String fileName=file.getOriginalFilename();  
        //验证文件名是否合格  
        if(!ExcelUtil.validateExcel(fileName)){  
         return "\"文件必须是excel格式！\"";  
        }  
        InputStream inputStream = file.getInputStream();
        LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
        fieldMap.put("HS编码", "hsCode");
        fieldMap.put("8位商品编码", "eightProductCode");
        fieldMap.put("商品编码附加码", "productAdditionalCode");
        fieldMap.put("名称", "categoryName");
        fieldMap.put("低税率", "minTax");
        fieldMap.put("高税率", "maxTax");
        fieldMap.put("消费税率", "exciseTax");
        fieldMap.put("增值税率", "incrementTax");
        fieldMap.put("备注", "remarks");
        String are[]= {"FBA CODE"};
        List<TaxRate> excelToList = ExcelUtil.excelToList(inputStream, "税率", TaxRate.class, fieldMap, are);
     //   cityService.addFright(excelToList);
        cityService.addTaxRate(excelToList);
        System.out.println(excelToList.toString());*/
        return cityService.findAll().toString();
    }
	
	
    
    
   
    

}
