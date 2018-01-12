package com.eshipping.fba.util;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.eshipping.fba.entity.UserInfo;

public class PasswordHelper {
	private  static final String algorithmName = "md5";
	private  static final int hashIterations = 2;

	public void encryptPassword(UserInfo user) {
		String newPassword = new SimpleHash(algorithmName, user.getPassWord(),  ByteSource.Util.bytes(user.getName()), hashIterations).toHex();
		user.setPassWord(newPassword);

	}
	
}
