package com.eshipping.fba.service;

import java.util.List;

import com.eshipping.fba.entity.SysPermission;
import com.eshipping.fba.entity.SysRole;

/**
 * 
* @ClassName: SysPermissionService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月8日 下午3:45:39 
*
 */
public interface SysPermissionService {
  
    public  Integer saveSysPermission(List<SysPermission> list);

	public void saveSysRole(SysRole role);

	public void saveSysRolePermission(int roleId, int permissionId);
    
    
}