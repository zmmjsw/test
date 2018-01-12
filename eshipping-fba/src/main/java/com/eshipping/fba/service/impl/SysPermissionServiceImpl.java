package com.eshipping.fba.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshipping.fba.dao.SysPermissionDao;
import com.eshipping.fba.entity.SysPermission;
import com.eshipping.fba.entity.SysRole;
import com.eshipping.fba.service.SysPermissionService;
/**权限业务
 * 
* @ClassName: SysPermissionServiceImpl 
* @Description: TODO(权限业务) 
* @author zhumingming 
* @date 2017年12月8日 下午3:44:21 
*
 */
@Service
@Transactional
public class SysPermissionServiceImpl implements SysPermissionService {
   
    @Autowired
    private SysPermissionDao sysPermissionDao;


	@Override
	public Integer saveSysPermission(List<SysPermission> list) {
		Integer num=sysPermissionDao.savePermission(list);
		return num;
		
	}


	@Override
	public void saveSysRole(SysRole role) {
		sysPermissionDao.saveSysRole(role);
	}


	@Override
	public void saveSysRolePermission(int roleId, int permissionId) {
		sysPermissionDao.saveSysRolePermission(roleId,permissionId);
		
	}
    
	
}