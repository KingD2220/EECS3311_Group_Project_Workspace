package persistence;

import domain_objects.Account;

public class DummyData {
	
	public DummyData() {
		
	}
	
	public static void createDummyAccounts() throws Exception {
		
		Account acct0 = new Account("superman", "kryptonite");
		Account acct1 = new Account("batman", "gotham");
		Account acct2 = new Account("catwoman", "meow");
		
		DatabaseStubs.addAccount(acct0);
		DatabaseStubs.addAccount(acct1);
		DatabaseStubs.addAccount(acct2);
		
	}
	
	
}
