package application;

import java.security.MessageDigest;
import java.util.List;

import domain_objects.Account;
import persistence.DatabaseStubs;

public class AccountsController {
	public AccountsController() {
		
	}
	
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
