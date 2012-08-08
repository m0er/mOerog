package com.moerog.module.post;

import java.util.*;

public interface PostDao {

	List<Post> listByCategoryId(int category);

	int count(int category);

	void add(Post post);

	void delteById(Post post);

	Post getPost(Post post);

	void update(Post post);

}
