package com.moerog.module.guestbook;

import java.util.List;

public interface GuestbookService {

	List<Guestbook> getList();

	int getTotalCount();

	void addGuestbook(Guestbook guestbook);

	void deleteById(Guestbook guestbook);

}
