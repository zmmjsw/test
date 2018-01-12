package com.eshipping.fba.common.config;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.eshipping.fba.entity.SysPermission;
import com.eshipping.fba.entity.SysRole;
import com.eshipping.fba.entity.UserInfo;
import com.eshipping.fba.service.UserInfoService;

/**
 * 
 * @ClassName: MyShiroRealm
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2017年12月7日 下午5:45:32
 *
 */
public class MyShiroRealm extends AuthorizingRealm {
	@Resource
	private UserInfoService userInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
		for (SysRole role : userInfo.getRoleList()) {
			authorizationInfo.addRole(role.getRole());
			for (SysPermission p : role.getPermissions()) {
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}

	/**
	 * 
	 * @Title: doGetAuthenticationInfo @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param token @param @return @param @throws
	 * AuthenticationException 设定文件 @throws
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户的输入的账号.
		String userName = (String) token.getPrincipal();
		// 通过username从数据库中查找 User对象，如果找到，没找到.
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		UserInfo userInfo = userInfoService.findByUserName(userName);
		if (userInfo == null) {
			return null;
		}
		 // 用户名
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo,
				 // 密码
				userInfo.getPassWord(),
				// salt=username+salt
				ByteSource.Util.bytes(userInfo.getName()), 
				// realm name
				getName() 
		);
		// 当验证都通过后，把用户信息放在session里
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("userSession", userInfo);
		session.setAttribute("userSessionId", userInfo.getUid());
		return authenticationInfo;
	}

}