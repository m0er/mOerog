package com.moerog.module.comment;

import java.util.List;

public interface CommentService {

	void writeComment(Comment comment);
	
	List<Comment> getListByPostId(int postId);

	void deleteById(Comment comment);
}
