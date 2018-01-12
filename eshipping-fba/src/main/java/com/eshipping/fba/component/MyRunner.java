package com.eshipping.fba.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.eshipping.fba.dto.UserDto;
import com.eshipping.fba.entity.SysPermission;
import com.eshipping.fba.entity.SysRole;
import com.eshipping.fba.service.SysPermissionService;
import com.eshipping.fba.service.UserInfoService;
/**
 * 
* @ClassName: MyRunner 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月8日 下午5:12:38 
*
 */
@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private SysPermissionService sysPermissionService;

	@Autowired
	private UserInfoService userInfoService;

	@Override
	@Order
	public void run(String... arg0) throws Exception {
		System.out.println("初始化加载权限");
		// 添加权限
		List<SysPermission> spList = new ArrayList<SysPermission>();
		// 管理
		SysPermission admin = new SysPermission();
		admin.setAvailable(true);
		admin.setName("管理");
		admin.setParentId(0L);
		admin.setParentIds("0/");
		admin.setPermission("userInfo:admin");
		admin.setResourceType("menu");
		admin.setUrl("userInfo/admin");
		// 用户
		SysPermission user = new SysPermission();
		user.setAvailable(true);
		user.setName("用户");
		user.setParentId(1L);
		user.setParentIds("0/1");
		user.setPermission("userInfo:user");
		user.setResourceType("button");
		user.setUrl("userInfo/user");
		spList.add(admin);
		spList.add(user);
		Integer num = sysPermissionService.saveSysPermission(spList);
		//如果已经添加过就不要添加
		if (0 != num) {

			// 添加角色
			System.out.println("初始化加载角色");
			// 管理
			SysRole adminr = new SysRole();
			adminr.setAvailable(true);
			adminr.setDescription("管理员");
			adminr.setRole("admin");
			sysPermissionService.saveSysRole(adminr);
			sysPermissionService.saveSysRolePermission(adminr.getId(), 1);
			// 用户
			SysRole ru = new SysRole();
			ru.setAvailable(true);
			ru.setDescription("用户");
			ru.setRole("user");
			sysPermissionService.saveSysRole(ru);
			sysPermissionService.saveSysRolePermission(ru.getId(), 2);

			// 添加用户
			System.out.println("初始添加用户");
			UserDto ud = new UserDto();
			ud.setName("admin");
			ud.setPassWord("admin");
			ud.setUserName("admin");
			userInfoService.saveUserInfo(ud);
		}

	}

}
