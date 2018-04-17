package com.eshipping.fba.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.eshipping.fba.dao.UserDao;
import com.eshipping.fba.dao.UserInfoDao;
import com.eshipping.fba.dao.UserInfoMapper;
import com.eshipping.fba.dto.UserDto;
import com.eshipping.fba.dto.UserInfoDto;
import com.eshipping.fba.entity.UserInfo;
import com.eshipping.fba.service.UserInfoService;
import com.eshipping.fba.util.PasswordHelper;
/**
 * 
* @ClassName: UserInfoServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月7日 下午6:12:46 
*
 */
@Service
@Transactional
@EnableTransactionManagement
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserInfoMapper userInfoMapper;
    
	@Override
	public UserInfo findByUserName(String userName) {
		List<UserInfo> findByPassWord = userInfoDao.findByPassWord("3ef7164d1f6167cb9f2658c07d3c2f0a");
		   return userInfoDao.findByUserName(userName);
	}
	
	@Override
	public void saveUserInfo(UserDto user) {
		UserInfo userInfo=new UserInfo();
		userInfo.setName(user.getName());
		userInfo.setPassWord(user.getPassWord());
		userInfo.setUserName(user.getUserName());
		Byte b1 = 1; 
		userInfo.setState(b1);
		userInfo.setSalt(user.getName());
		PasswordHelper ph=new PasswordHelper();
		ph.encryptPassword(userInfo);
		userDao.saveUser(userInfo);
		int rid="admin".equals(user.getName())?1:2;
		userDao.saveSysUserRole(rid,userInfo.getUid());
	}

	@Override
	public UserInfoDto findUserInfoById(Integer id) {
		UserInfo ss=userInfoDao.findByUid(id);
		UserInfoDto uit=new UserInfoDto();
		BeanUtils.copyProperties(ss, uit);
		System.out.println(uit);
		return uit;
	}

	@Override
	public List<UserInfo> findAll() {
		List<UserInfo> ss=	userInfoMapper.findAll();
		return ss;
	}
}