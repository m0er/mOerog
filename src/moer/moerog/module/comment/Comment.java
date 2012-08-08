package moer.moerog.module.comment;

import java.util.Date;

import org.bson.types.ObjectId;

public class Comment {
	private ObjectId commentId;
	private Date commentDatetime;
	private String commentContent;
	private ObjectId postId;
	private String commentWriter;
	
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public ObjectId getCommentId() {
		return commentId;
	}
	public void setCommentId(ObjectId commentId) {
		this.commentId = commentId;
	}
	public Date getCommentDatetime() {
		return commentDatetime;
	}
	public void setCommentDatetime(Date commentDatetime) {
		this.commentDatetime = commentDatetime;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public ObjectId getPostId() {
		return postId;
	}
	public void setPostId(ObjectId postId) {
		this.postId = postId;
	}
}
