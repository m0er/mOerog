package com.moerog.module.guestbook;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.moerog.util.*;

@Controller
@RequestMapping("/guestbook/")
public class GuestbookController {
	@Autowired GuestbookService guestbookService;
	Logger logger = LoggerFactory.getLogger(GuestbookController.class);
	
	@RequestMapping("list")
	public ModelAndView list(@ModelAttribute("guestbook") Guestbook guestbook, HttpSession session) {
		ModelAndView mav = new ModelAndView("guestbook", "user", FindUserInSession.getUserBySession(session));
		mav.addObject("totalCount", guestbookService.getTotalCount());
		mav.addObject("list", guestbookService.getList());
		return mav;
	}
	
	@RequestMapping("add")
	public String form(@ModelAttribute("guestbook") Guestbook guestbook) {
		logger.info(guestbook.getGbookWriter());
		guestbookService.addGuestbook(guestbook);
		return "redirect:/guestbook/list.mo";
	}
	
	@RequestMapping("delete")
	public String delete(Guestbook guestbook) {
		logger.info("삭제할 방명록 ID: " + guestbook.getGbookId());		
		guestbookService.deleteById(guestbook);
		return "redirect:/guestbook/list.mo";
	}
	
}
