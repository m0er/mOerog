package com.moerog.module.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moerog.module.post.Post;

public class Index {
	private Map<String, List<Post>> postMap = new HashMap<String, List<Post>>();
	private Map<String, Integer> postCount = new HashMap<String, Integer>();

	public Map<String, Integer> getPostCount() {
		return postCount;
	}

	public void setPostCount(Map<String, Integer> postCount) {
		this.postCount = postCount;
	}

	public Map<String, List<Post>> getPostMap() {
		return postMap;
	}

	public void setPostMap(Map<String, List<Post>> postMap) {
		this.postMap = postMap;
	}
}
