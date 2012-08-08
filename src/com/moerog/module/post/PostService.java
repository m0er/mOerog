package com.moerog.module.post;

import java.util.*;

public interface PostService {

	List<Post> getListByCategoryId(int category);

	int getTotalCount(int category);

	void writePost(Post post);

	void deleteById(Post post);

	Post getPostById(Post post);

	void modifyPost(Post post);

}
