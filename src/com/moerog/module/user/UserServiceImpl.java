package com.moerog.module.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired UserDao userDao;
	
	@Override
	public User adminLogin(User user) {
		User tempUser = findAdminById(user.getUserId());
		if (tempUser.getUserId().equals(user.getUserId()) && tempUser.getUserPword().equals(user.getUserPword())) {
			user = tempUser;
			user.setAdmin(true);
			user.setLogin(true);
			return user;
		}
		
		return null;
	}
	
	@Override
	public User login(User user) {
		User tempUser = findUserById(user.getUserId());
		if (tempUser.getUserId().equals(user.getUserId()) && tempUser.getUserPword().equals(user.getUserPword())) {
			user = tempUser;
			user.setLogin(true);
			return user;
		}
		
		return null;
	}
	
	private User findUserById(String userId) {
		User user = userDao.findUserById(userId);
		return user;
	}

	private User findAdminById(String userId) {
		User user = userDao.findAdminById(userId);
		return user;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public void register(User user) {
		userDao.registerUser(user);
	}
	
}
