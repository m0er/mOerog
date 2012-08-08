package moer.moerog.module.post;

import java.util.Date;

import org.bson.types.ObjectId;

public class Post {
	private ObjectId id;
	private int category;
	private String title;
	private Date created;
	private String content;
	private String adminNickname;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAdminNickname() {
		return adminNickname;
	}
	public void setAdminNickname(String adminNickname) {
		this.adminNickname = adminNickname;
	}
}
