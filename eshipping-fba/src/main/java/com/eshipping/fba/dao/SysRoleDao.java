package com.eshipping.fba.dao;

import org.springframework.data.repository.CrudRepository;

import com.eshipping.fba.entity.SysRole;
import com.eshipping.fba.entity.UserInfo;

/**角色dao的接口
 * 
* @ClassName: SysRoleDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月8日 上午10:16:28 
*
 */
public interface SysRoleDao extends CrudRepository<SysRole,Long>{

}
