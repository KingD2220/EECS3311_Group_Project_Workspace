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
		userAcct = new Account("Tester", "test123");
		res = AccountsController.registerAccount(userAcct.getUserName(), userAcct.getPassword());
	}
	
	@Test
	public void testAccountVerification() throws Exception {
		assertFalse(AccountsController.accountVerification("Tester", "test123"));
		assertFalse(AccountsController.accountVerification("", ""));
		assertFalse(AccountsController.accountVerification("tester", "test123"));
		assertFalse(AccountsController.accountVerification("Tester", "test321"));
		assertFalse(AccountsController.accountVerification("Testre", "test123"));
	}
	
	

}
