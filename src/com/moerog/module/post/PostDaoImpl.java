package com.moerog.module.post;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.orm.ibatis.*;
import org.springframework.stereotype.*;

@Repository
public class PostDaoImpl implements PostDao {
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> listByCategoryId(int category) {
		return sqlMapClientTemplate.queryForList("post.list", category);
	}

	@Override
	public int count(int category) {
		return (Integer) sqlMapClientTemplate.queryForObject("post.count", category);
	}

	@Override
	public void add(Post post) {
		sqlMapClientTemplate.insert("post.add", post);
	}

	@Override
	public void delteById(Post post) {
		sqlMapClientTemplate.delete("post.delete", post);
	}

	@Override
	public Post getPost(Post post) {
		return (Post) sqlMapClientTemplate.queryForObject("post.getPost", post);
	}

	@Override
	public void update(Post post) {
		sqlMapClientTemplate.update("post.update", post);
	}

}
