package moer.moerog.module.user;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	private ObjectId id;
	private String userId;
	private String password;
	private String nickname;
	private String email;
	private boolean admin;
	private boolean login;

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public ObjectId getId() {
		return id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password="
				+ password + ", nickname=" + nickname + ", email=" + email
				+ ", admin=" + admin + ", login=" + login + "]";
	}
}
