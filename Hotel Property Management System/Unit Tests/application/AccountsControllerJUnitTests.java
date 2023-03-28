package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain_objects.Account;

public class AccountsControllerJUnitTests {
	private Account userAcct;
	String res;

	@Before
	public void setupData() throws Exception {
		userAcct = new Account("Tester", "test123", "Manager");
		res = AccountsController.registerAccount(userAcct.getUserName(), userAcct.getPassword(), userAcct.getRole());
	}
	
	@Test
	public void testAccountVerification() throws Exception {
		assertFalse(AccountsController.accountVerification("Tester", "test123","Manager"));
		assertFalse(AccountsController.accountVerification("", "" ,"Manager"));
		assertFalse(AccountsController.accountVerification("tester", "test123","Manager"));
		assertFalse(AccountsController.accountVerification("Tester", "test321","Manager"));
		assertFalse(AccountsController.accountVerification("Testre", "test123","Manager"));
	}
	
	

}
