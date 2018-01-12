package com.eshipping.fba.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshipping.fba.dto.UserDto;
import com.eshipping.fba.entity.UserInfo;
import com.eshipping.fba.service.UserInfoService;
import com.eshipping.fba.util.ResponseData;

/**
 * 
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2017年12月8日 上午9:43:02
 *
 */
@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public ResponseData saveUser(@RequestBody UserDto user) {
		userInfoService.saveUserInfo(user);
		return new ResponseData(ResponseData.OK);
	}
	
	@RequestMapping(value = "/find/user", method = RequestMethod.POST)
	public ResponseData findUserInfoById(@RequestParam(value = "uid") Integer uid) {
		List<UserInfo> findAll = userInfoService.findAll();
		System.out.println(findAll.toString());
		return new ResponseData(ResponseData.OK,"",userInfoService.findUserInfoById(uid));
	}

}
