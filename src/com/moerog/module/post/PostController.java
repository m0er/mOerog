package com.moerog.module.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moerog.module.comment.Comment;
import com.moerog.module.comment.CommentService;
import com.moerog.module.user.User;
import com.moerog.util.FindUserInSession;

@Controller
@RequestMapping("/post/")
public class PostController {
	@Autowired PostService postService;
	@Autowired CommentService commentService;
	Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@RequestMapping("list")
	public String list(User user, Comment comment, HttpSession session, HttpServletRequest request, Model model) {
		user = FindUserInSession.getUserBySession(session);
		int categoryId = Integer.valueOf(request.getParameter("categoryId"));
		logger.info("카테고리 아이디: " + categoryId);
		
		model.addAttribute("postList", postService.getListByCategoryId(categoryId));
		model.addAttribute("totalCount", postService.getTotalCount(categoryId));
		
		addComment(model);
		
		return Category.values()[categoryId - 1].name();
	}
	
	@SuppressWarnings("unchecked")
	private void addComment(Model model) {
		Map<Integer, List<Comment>> commentMap = new HashMap<Integer, List<Comment>>();
		for (Post post : (List<Post>) model.asMap().get("postList")) {
			int postId = post.getPostId();
			commentMap.put(postId, commentService.getListByPostId(postId));
		}
		model.addAttribute("commentMap", commentMap);
	}

	@RequestMapping("form")
	public String form(User user, Post post) {
		return "writepost";
	}
	
	@RequestMapping("modifyForm")
	public String modifyForm(Post post, Model model) {
		logger.info("수정할 포스트 아이디: " + post.getPostId());
		logger.info("수정할 포스트 카테고리: " + post.getPostCategory());
		logger.info("수정할 포스트 닉네임: " + post.getAdminNickname());
		post = postService.getPostById(post);
		
		logger.info("수정할 포스트 타이틀: " + post.getPostTitle());
		logger.info("수정할 포스트 컨텐츠: " + post.getPostContent());
		
		model.addAttribute("post", post);
		return "modifypost";
	}
	
	@RequestMapping("write")
	public String write(Post post) {
		if (post == null) return "redirect:/post/esl.mo"; 
		logger.info("카테고리: " + post.getPostCategory());
		logger.info("제목: " + post.getPostTitle());
		logger.info("닉네임: " + post.getAdminNickname());
		
		postService.writePost(post);
		return "redirect:/post/list.mo?categoryId=" + post.getPostCategory();
	}
	
	@RequestMapping("delete")
	public String delete(Post post) {
		logger.info("포스트 아이디: " + post.getPostId());
		logger.info("카테고리: " + post.getPostCategory());
		logger.info("닉네임: " + post.getAdminNickname());
		postService.deleteById(post);
		return "redirect:/post/list.mo?categoryId=" + post.getPostCategory();
	}
	
	@RequestMapping("modify")
	public String modify(Post post) {
		logger.info("포스트 아이디: " + post.getPostId());
		logger.info("카테고리: " + post.getPostCategory());
		logger.info("닉네임: " + post.getAdminNickname());
		logger.info("타이틀: " + post.getPostTitle());
		logger.info("컨텐츠: " + post.getPostContent());
		
		postService.modifyPost(post);
		return "redirect:/post/list.mo?categoryId=" + post.getPostCategory();
	}
}
