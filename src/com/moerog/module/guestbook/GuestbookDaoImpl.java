package com.moerog.module.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GuestbookDaoImpl implements GuestbookDao {
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public void deleteAll() {
		sqlMapClientTemplate.delete("guestbook.deleteAll");
	}

	@Override
	public int count() {
		return (Integer) sqlMapClientTemplate.queryForObject("guestbook.count");
	}

	@Override
	public void add(Guestbook gbook) {
		sqlMapClientTemplate.insert("guestbook.add", gbook);
	}
	
	@SuppressWarnings("unchecked")
	public List<Guestbook> list() {
		return sqlMapClientTemplate.queryForList("guestbook.list");
	}

	@Override
	public void deleteById(Guestbook guestbook) {
		sqlMapClientTemplate.delete("guestbook.delete", guestbook);
	}
	
}
