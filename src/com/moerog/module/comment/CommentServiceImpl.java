package com.moerog.module.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired CommentDao commentDao;
	
	@Override
	public void writeComment(Comment comment) {
		commentDao.add(comment);
	}

	@Override
	public List<Comment> getListByPostId(int postId) {
		return commentDao.listByPostId(postId);
	}

	@Override
	public void deleteById(Comment comment) {
		commentDao.delete(comment);
	}

}
