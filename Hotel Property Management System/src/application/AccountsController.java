package application;

import java.util.List;

import domain_objects.Account;
import persistence.DatabaseStubs;

public class AccountsController {
	public AccountsController() {
		
	}
	
	public static boolean accountVerification(String username, String password) {
		List<Account> accounts = DatabaseStubs.getAccounts();
				
		for (Account a : accounts) {
			if (username.equals(a.getUserName()) && password.equals(a.getPassword())) {
				return true;
			}

		}
		
		return false;
		
	}
	
	public static String registerAccount(String username, String password) {
		
		for (Account a : DatabaseStubs.getAccounts()) {
			if (username.equals(a.getUserName())) {
				return "username already exists!";
			}	

		}

		DatabaseStubs.addAccount(new Account(username, password));
		return "Account created!";
	}

}
