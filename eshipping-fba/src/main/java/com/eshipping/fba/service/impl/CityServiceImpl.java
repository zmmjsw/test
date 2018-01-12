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
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eshipping.fba.dao.CityDao;
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
	


	


	

	


}
