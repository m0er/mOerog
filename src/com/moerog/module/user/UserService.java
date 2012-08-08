package com.moerog.module.user;

import javax.servlet.http.HttpSession;

public interface UserService {

	public abstract User adminLogin(User user);

	public abstract User login(User user);

	public abstract void logout(HttpSession session);

	public abstract void register(User user);

}