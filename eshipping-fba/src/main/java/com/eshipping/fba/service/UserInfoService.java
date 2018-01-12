package com.eshipping.fba.service;

import java.util.List;

import com.eshipping.fba.dto.UserDto;
import com.eshipping.fba.dto.UserInfoDto;
import com.eshipping.fba.entity.UserInfo;

/**
 * 
* @ClassName: UserInfoService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月7日 下午6:13:06 
*
 */
public interface UserInfoService {
    /** 查询用户信息
     *
    * @Title: findByUsername 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @return UserInfo    返回类型
    * @param userName 用户名
     */
    public UserInfo findByUserName(String userName);
    /** 添加用户信息
     * 
    * @Title: saveUserInfo 
    * @Description: TODO(注册) 
    * @return void    返回类型
     */
    public  void saveUserInfo(UserDto user);
    
    UserInfoDto findUserInfoById(Integer id);
    
    List<UserInfo> findAll();
    
    
}