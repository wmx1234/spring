package com.timo.bean;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-01
 */

public class User {

	private String userName;

	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
