package com.moerog.module.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired UserService userService;
	
	@RequestMapping("adminlogin")
	public String adminLogin(@ModelAttribute("user") User user, HttpSession session) {
		logger.info(user.getUserId());
		logger.info(user.getUserPword());
		
		if ((user = userService.adminLogin(user)) != null) {
			session.setAttribute("user", user);
			logger.info(user.getUserId() + "(Admin) 로그인 완료");
		}
		
		return "redirect:/index.mo";
	}
	
	@RequestMapping("login")
	public String login(@ModelAttribute("user") User user, HttpSession session) {
		logger.info(user.getUserId());
		logger.info(user.getUserPword());
		
		if ((user = userService.login(user)) != null) {
			session.setAttribute("user", user);
			logger.info(user.getUserId() + "(User) 로그인 완료");
		}
		
		return "redirect:/index.mo";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		userService.logout(session);
		logger.info("로그아웃 완료");
		return "redirect:/index.mo";
	}
	
	@RequestMapping("register")
	public String register(@ModelAttribute("user") User user) {
		userService.register(user);
		logger.info(user.getUserId() + " 등록 완료");
		return "redirect:/index.mo";
	}
}
