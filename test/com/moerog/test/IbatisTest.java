package com.moerog.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.orm.ibatis.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class IbatisTest {
	@Autowired SqlMapClientTemplate ibatis;
	Logger logger = LoggerFactory.getLogger(IbatisTest.class);
	
	@Test
	public void create() throws Exception {
		assertThat(ibatis, is(notNullValue()));
	}
	
	@Test
	public void currentTime() throws Exception {
		assertThat((String) ibatis.queryForObject("test.getTime"), is(notNullValue(String.class)));
	}
}
