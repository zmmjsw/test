package com.eshipping.fba.controller;


import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eshipping.fba.entity.Pdf;
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
    
    @RequestMapping(value = "/api/findAll", method = RequestMethod.POST)
    public String findAll() {
    	cityService.addEntirePdf();
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
    	 //判断文件是否为空  
        if(file==null){  
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
        fieldMap.put("Unique Ref", "orderId");
        fieldMap.put("Job Number", "state");
        fieldMap.put("Reference", "handlePoint");
        fieldMap.put("Tariff", "targetWarehouse");
        fieldMap.put("Delivery Postcode/Zipcode", "productService");
        fieldMap.put("xx", "xx");
        fieldMap.put("yy", "yy");
        fieldMap.put("zz", "zz");
        fieldMap.put("hh", "hh");
        String are[]= {"FBA CODE"};
        List<Pdf> excelToList = ExcelUtil.excelToList(inputStream, "Sheet1", Pdf.class, fieldMap, are);
        System.out.println(excelToList.toString());
        return cityService.findAll().toString();
    }
    
    
    
    
   
    

}
