package domain_objects;

import java.security.MessageDigest;

public class Account {
	private String userName;
	private String password;
	private String role;
	private byte[] hash;
	

	public Account(String userName, String password, String role) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");	
		hash = md.digest(password.getBytes());					// encrypt password
		this.password = new String(hash);
		this.userName = userName;
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
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
}
