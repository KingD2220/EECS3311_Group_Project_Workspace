package domain_objects;

import java.security.MessageDigest;

public class Account {
	private String userName;
	private String password;
	private byte[] hash;
	
	MessageDigest md = MessageDigest.getInstance("SHA-256");
	
	public Account(String userName, String password) throws Exception {
		this.userName = userName;
		hash = md.digest(password.getBytes());
		this.password = new String(hash);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
