package com.moerog.module.post;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service("postService")
public class PostServiceImpl implements PostService {
	@Autowired PostDao postDao;
	
	@Override
	public List<Post> getListByCategoryId(int category) {
		return postDao.listByCategoryId(category);
	}

	@Override
	public int getTotalCount(int category) {
		return postDao.count(category);
	}

	@Override
	public void writePost(Post post) {
		postDao.add(post);
	}

	@Override
	public void deleteById(Post post) {
		postDao.delteById(post);
	}

	@Override
	public Post getPostById(Post post) {
		return postDao.getPost(post);
	}

	@Override
	public void modifyPost(Post post) {
		postDao.update(post);
	}

}
