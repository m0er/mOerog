package com.moerog.module.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("guestbookService")
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired GuestbookDao guestbookDao;
	
	@Override
	public List<Guestbook> getList() {
		return guestbookDao.list();
	}

	@Override
	public int getTotalCount() {
		return guestbookDao.count();
	}

	@Override
	public void addGuestbook(Guestbook guestbook) {
		guestbookDao.add(guestbook);
	}

	@Override
	public void deleteById(Guestbook guestbook) {
		guestbookDao.deleteById(guestbook);
	}

}
