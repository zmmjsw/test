package com.eshipping.fba.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshipping.fba.dto.UserDto;
import com.eshipping.fba.util.ResponseData;


/**
 * 
* @ClassName: HomeController 
* @Description: TODO(登录) 
* @author zhumingming 
* @date 2017年12月7日 下午5:56:08 
*
 */
@RestController
public class HomeController {

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseData login( @RequestBody UserDto user) {
		ResponseData rsd = new ResponseData();
		if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassWord())) {
			rsd.setMessage("用户名或密码不能为空！");
			rsd.setCode(ResponseData.ERROR);
			return rsd;
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
		subject.login(token);
		rsd.setMessage("登录成功");
		rsd.setCode(ResponseData.OK);
		return rsd;
	}

}
