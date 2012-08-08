package com.moerog.module.user;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class UserDaoImplTest {
	@Autowired UserDao userDao;
	
	@Test
	public void create() throws Exception {
		assertThat(userDao, is(notNullValue()));
	}
	
	@Test
	public void findAdminById_어드민_찾기() {
		User user = userDao.findAdminById("admin");
		assertThat(user.getUserId(), is("admin"));
		assertThat(user.getUserPword(), is("test"));
		assertThat(user.getUserNickname(), is("mOer"));
	}
	
	@Test
	public void registerUserAndGet() throws Exception {
		userDao.deleteAll();
		
		User user1 = new User();
		user1.setUserId("testUser");
		user1.setUserPword("testUser");
		user1.setUserEmail("testUser@testUser.com");
		user1.setUserNickname("testUser");

		userDao.registerUser(user1);
		
		User user2 = userDao.findUserById(user1.getUserId());
		assertThat(user1.getUserId(), is(user2.getUserId()));
		assertThat(user1.getUserEmail(), is(user2.getUserEmail()));
	}

}
