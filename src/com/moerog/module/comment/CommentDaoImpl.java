package com.moerog.module.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public void add(Comment comment) {
		sqlMapClientTemplate.insert("comment.add", comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listByPostId(int postId) {
		return sqlMapClientTemplate.queryForList("comment.list", postId);
	}

	@Override
	public void delete(Comment comment) {
		sqlMapClientTemplate.delete("comment.delete", comment);
	}

}
