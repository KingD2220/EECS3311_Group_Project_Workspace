package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

import domain_objects_Users.Customer;

public class CustomerClassJUnitTests {
	
	Customer customer = new Customer();

	@Test
	public void testSetCreditCard() {
		customer.setCredit_card("1234 5678 9101 1231");
		assertEquals("1234 5678 9101 1231", customer.getCredit_card());
	}
	
	@Test
	public void testgetCreditCard() {
		customer.setCredit_card("1234 5678 9101 1231");
		assertEquals("1234 5678 9101 1231", customer.getCredit_card());
	}
	
	@Test
	public void testSetFirstName() {
		customer.setFirst_name("First");
		assertEquals("First", customer.getFirst_name());
	}
	
	@Test
	public void testgetFirstName() {
		customer.setFirst_name("First");
		assertEquals("First", customer.getFirst_name());
	}
	
	@Test
	public void testSetLastName() {
		customer.setLast_name("Last");
		assertEquals("Last", customer.getLast_name());
	}
	
	@Test
	public void testgetLastName() {
		customer.setLast_name("Last");
		assertEquals("Last", customer.getLast_name());
	}
	
	@Test
	public void testSetAddress() {
		customer.setAddress("123 Street Ave");
		assertEquals("123 Street Ave", customer.getAddress());
	}
	
	@Test
	public void testGetAddress() {
		customer.setAddress("123 Street Ave");
		assertEquals("123 Street Ave", customer.getAddress());
	}
	
	@Test
	public void testSetPhoneNumber() {
		customer.setPhone_num("123 456 7891");
		assertEquals("123 456 7891", customer.getPhone_num());
	}
	
	@Test
	public void testGetPhoneNumber() {
		customer.setPhone_num("123 456 7891");
		assertEquals("123 456 7891", customer.getPhone_num());
	}
	
	
}
