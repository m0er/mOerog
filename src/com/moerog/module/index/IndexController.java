package com.moerog.module.index;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moerog.module.comment.Comment;
import com.moerog.module.post.Category;
import com.moerog.module.user.User;
import com.moerog.module.user.UserService;
import com.moerog.util.FindUserInSession;

@Controller
public class IndexController {
	@Autowired UserService userService;
	@Autowired IndexService indexService;
	
	@ModelAttribute("enums")
	public List<String> getCategory() {
		List<String> categoryList = new ArrayList<String>();
		
		for (Category category : Category.values()) {
			categoryList.add(category.name());
		}
		
		return categoryList;
	}
	
	@RequestMapping("/index")
	public ModelAndView list(@ModelAttribute("user") User user, Comment comment, HttpSession session) {
		user = FindUserInSession.getUserBySession(session);
		ModelAndView mav = new ModelAndView("index", "user", user);
		
		Index index = new Index();
		indexService.setPostLIstTo(index);
		mav.addObject("index", index);
		
		indexService.setCommentListTo(mav);
		return mav;
	}
}
