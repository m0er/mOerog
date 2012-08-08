package com.moerog.module.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.orm.ibatis.*;
import org.springframework.stereotype.*;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public User findAdminById(String adminId) {
		return (User) sqlMapClientTemplate.queryForObject("user.getAdmin", adminId);
	}
	
	@Override
	public void registerUser(User user) {
		sqlMapClientTemplate.insert("user.register", user);
	}
	
	@Override
	public User findUserById(String userId) {
		return (User) sqlMapClientTemplate.queryForObject("user.getUser", userId);
	}
	
	@Override
	public void deleteAll() {
		sqlMapClientTemplate.delete("user.deleteAll");
	}
	
}
