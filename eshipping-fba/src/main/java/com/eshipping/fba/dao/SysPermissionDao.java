package com.eshipping.fba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.eshipping.fba.entity.SysPermission;
import com.eshipping.fba.entity.SysRole;

@Repository
public interface SysPermissionDao {
	
	Integer savePermission(List<SysPermission> list);

	void saveSysRole(SysRole role);

	void saveSysRolePermission(@Param("roleId")int roleId,@Param("permissionId")int permissionId);

}
