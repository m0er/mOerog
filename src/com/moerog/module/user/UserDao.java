package com.moerog.module.user;

public interface UserDao {

	public abstract User findAdminById(String adminId);

	public abstract void registerUser(User user);

	public abstract User findUserById(String userId);

	void deleteAll();

}