package com.eshipping.fba.dto;
/**
 * 
* @ClassName: UserDto 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author  zhumingming 
* @date 2017年12月7日 下午6:09:59 
*
 */
public class UserDto {
	private String name;
	private String userName;
	private String passWord;
	
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	

}
