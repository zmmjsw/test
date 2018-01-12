package com.eshipping.fba.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eshipping.fba.entity.UserInfo;
/**
 * 
* @ClassName: UserInfoDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月7日 下午5:58:35 
*
 */
@Repository
public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /**根据账户名查询用户
    * @Title: findByUsername 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @return UserInfo    返回类型
    * @param userName 用户名
     */
    public UserInfo findByUserName(String userName);

	public UserInfo findByUid(Integer id);
	

    
}