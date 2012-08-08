package com.moerog.module.guestbook;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class GuestbookDaoImplTest {
	@Autowired GuestbookDao guestbookDao;
	
	@Test
	public void create() throws Exception {
		assertThat(guestbookDao, is(notNullValue()));
	}
	
	@Test
	public void add() throws Exception {
		guestbookDao.deleteAll();
		assertThat(guestbookDao.count(), is(0));
		
		Guestbook gbook = new Guestbook();
		gbook.setGbookWriter("admin");
		gbook.setGbookContent("test contents....");
		guestbookDao.add(gbook);
		
		assertThat(guestbookDao.count(), is(1));
	}
}
