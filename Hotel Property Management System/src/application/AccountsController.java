package application;

import java.security.MessageDigest;
import persistence.RealDatabase;

public class AccountsController {
	static RealDatabase db = new RealDatabase();
	
	private AccountsController() {
		db.getConnection();
	}
	
	/**
	 * Verifies if login username and password (hashed) is correct by 
	 * checking the accounts database.
	 * @return boolean true or false.
	 */
	public static boolean accountVerification(String username, String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(password.getBytes());
		String passHash = new String(hash);
		
		return db.getUser(username, passHash);
	}
	
	/**
	 * Checks if username already exists. 
	 * If not, a new account is created and added to the accounts database
	 */
	public static String registerAccount(String username, String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(password.getBytes());
		String passHash = new String(hash);
		
		if (!db.addUser(username, passHash)) {
			return "User already exists!";
		}else {	
	
		return "Account created!";
		}
	}

}
