package com.moerog.module.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.moerog.module.comment.Comment;
import com.moerog.module.comment.CommentService;
import com.moerog.module.post.Category;
import com.moerog.module.post.Post;
import com.moerog.module.post.PostService;

@Service("indexService")
public class IndexServiceImpl implements IndexService {
	@Autowired PostService postService;
	@Autowired CommentService commentService;
	
	@Override
	public void setPostLIstTo(Index index) {
		for (Category category : Category.values()) {
			index.getPostMap().put(category.name(), postService.getListByCategoryId(category.getCategory()));
			index.getPostCount().put(category.name(), postService.getTotalCount(category.getCategory()));
		}
	}
	
	@Override
	public void setCommentListTo(ModelAndView mav) {
		Map<Integer, List<Comment>> commentMap = new HashMap<Integer, List<Comment>>();
		
		for (Category category : Category.values()) {
			for (Post post : ((Index) mav.getModel().get("index")).getPostMap().get(category.name())) {
				int postId = post.getPostId();
				commentMap.put(postId, commentService.getListByPostId(postId));
			}
		}
		
		mav.addObject("commentMap", commentMap);
	}
}
