package moer.moerog.module.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/user/")
@SessionAttributes("loginUser")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired UserService userService;
	
	@RequestMapping("adminlogin")
	public String adminLogin(User user) {
		logger.info(user.getId().toString());
		logger.info(user.getPassword());
		
		User admin = userService.adminLogin(user); 
		if (admin != null) {
			logger.info(user.getId() + "(Admin) 로그인 완료");
		}
		
		return "redirect:/index";
	}
	
	@RequestMapping("login")
	public String login(User user, Model model) {
		logger.info(user.getId().toString());
		logger.info(user.getPassword());
		
		User loginUser = userService.login(user); 
		if (loginUser != null) {
			logger.info(user.getId() + "(User) 로그인 완료");
			model.addAttribute("loginUser", loginUser);
		}
		
		return "redirect:/index";
	}
	
	@RequestMapping("logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		
		logger.info("로그아웃 완료");
		
		return "redirect:/index";
	}
	
	@RequestMapping("register")
	public String register(User user) {
		userService.register(user);
		
		logger.info(user.getId() + " 등록 완료");
		
		return "redirect:/index";
	}
}
