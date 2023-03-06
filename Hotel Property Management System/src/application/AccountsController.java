package application;

import java.security.MessageDigest;
import java.util.List;

import domain_objects.Account;
import persistence.DatabaseStubs;

public class AccountsController {
	public AccountsController() {
		
	}
	
	/**
	 * Verifies if login username and password (hashed) is correct by 
	 * checking the accounts database.
	 * @return boolean true or false.
	 */
	public static boolean accountVerification(String username, String password) throws Exception {
		List<Account> accounts = DatabaseStubs.getAccounts();
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(password.getBytes());
		String pwHash = new String(hash);
		
		for (Account a : accounts) {
			if (username.equals(a.getUserName()) && pwHash.equals(a.getPassword())) {
				return true;
			}

		}
		
		return false;
		
	}
	
	/**
	 * Checks if username already exists. 
	 * If not, a new account is created and added to the accounts database
	 */
	public static String registerAccount(String username, String password) throws Exception {
		
		for (Account a : DatabaseStubs.getAccounts()) {
			if (username.equals(a.getUserName())) {
				return "username already exists!";
			}	

		}

		DatabaseStubs.addAccount(new Account(username, password));
		return "Account created!";
	}

}
