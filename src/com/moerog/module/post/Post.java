package com.moerog.module.post;

import java.util.Date;

public class Post {
	private int postId;
	private int postCategory;
	private String postTitle;
	private Date postDatetime;
	private String postContent;
	private String adminNickname;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getPostCategory() {
		return postCategory;
	}
	public void setPostCategory(int postCategory) {
		this.postCategory = postCategory;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public Date getPostDatetime() {
		return postDatetime;
	}
	public void setPostDatetime(Date postDatetime) {
		this.postDatetime = postDatetime;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getAdminNickname() {
		return adminNickname;
	}
	public void setAdminNickname(String adminNickname) {
		this.adminNickname = adminNickname;
	}
}
