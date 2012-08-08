package com.moerog.module.user;

public class User {
	private String userId;
	private String userPword;
	private String userNickname;
	private String userEmail;
	private boolean admin;
	private boolean login;
	
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public String getUserId() {
		return userId;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPword() {
		return userPword;
	}
	public void setUserPword(String userPword) {
		this.userPword = userPword;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
