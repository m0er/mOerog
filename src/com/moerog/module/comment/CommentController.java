package com.moerog.module.comment;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment/")
public class CommentController {
	@Autowired CommentService commentService;
	Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@RequestMapping("add")
	public String add(HttpServletRequest request, Comment comment) {
		logger.info("포스트 아이디: " + request.getParameter("postId"));
		comment.setPostId(Integer.parseInt(request.getParameter("postId")));
		
		logger.info("카테고리: " + request.getParameter("postCategory"));
		logger.info("커멘트 작성자: " + comment.getCommentWriter());
		logger.info("커멘트 내용: " + comment.getCommentContent());
		
		commentService.writeComment(comment);
		
		return "redirect:/post/list.mo?categoryId=" + request.getParameter("postCategory");
	}
	
	@RequestMapping("delete")
	public String delete(@ModelAttribute("comment") Comment comment, HttpServletRequest request) {
		logger.info("포스트 아이디: " + request.getParameter("postId"));
		logger.info("커멘트 아이디: " + request.getParameter("commentId"));
		logger.info("커멘트 작성자: " + comment.getCommentWriter());
		
		comment.setPostId(Integer.parseInt(request.getParameter("postId")));
		comment.setCommentId(Integer.parseInt(request.getParameter("commentId")));
		commentService.deleteById(comment);
		
		return "redirect:/post/list.mo?categoryId=" + request.getParameter("postCategory");
	}
}
