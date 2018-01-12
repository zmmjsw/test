package com.eshipping.fba.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.eshipping.fba.entity.UserInfo;

/**
 * 
 * @ClassName: UserDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2017年12月8日 下午2:57:45
 *
 */
@Repository
public interface UserDao {
	void saveUser(UserInfo userInfo);

	void saveSysUserRole(@Param("roleId")Integer roleId, @Param("uid")Integer uid);
}
