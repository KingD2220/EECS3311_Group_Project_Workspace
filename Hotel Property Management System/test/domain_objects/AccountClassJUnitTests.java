package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountClassJUnitTests {
	
	@Test
	public void testSetUsername() throws Exception {
		Account account = new Account("Username", "Password");
		account.setUserName("Username1");
		assertEquals("Username1", account.getUserName());
	}
	
	@Test
	public void testGetUsername() throws Exception {
		Account account = new Account("Username", "Password");
		assertEquals("Username", account.getUserName());
	}

}
