package com.moerog.module.comment;

import java.util.List;

public interface CommentDao {

	void add(Comment comment);

	List<Comment> listByPostId(int postId);

	void delete(Comment comment);

}
