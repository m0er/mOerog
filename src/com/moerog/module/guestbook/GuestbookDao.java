package com.moerog.module.guestbook;

import java.util.List;

public interface GuestbookDao {

	void deleteAll();

	int count();

	void add(Guestbook gbook);

	List<Guestbook> list();

	void deleteById(Guestbook guestbook);

}
