package application;

import java.security.MessageDigest;
import java.util.List;

import domain_objects.Account;
import persistence.DatabaseStubs;
import persistence.RealDatabase;

public class AccountsController {
	static RealDatabase db = new RealDatabase();
	
	public AccountsController() {
		
	}
	
	/**
	 * Verifies if login username and password (hashed) is correct by 
	 * checking the accounts database.
	 * @return boolean true or false.
	 */
	public static boolean accountVerification(String username, String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] passHash = md.digest(password.getBytes());
		
	  return db.getUser(username, passHash);
	}
	
	/**
	 * Checks if username already exists. 
	 * If not, a new account is created and added to the accounts database
	 */
	public static String registerAccount(String username, String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] passHash = md.digest(password.getBytes());
		
			if (db.getUser(username, passHash)) {
				return "User already exists!";
			}	

		db.addUser(username, passHash);
		return "Account created!";
	}

}
