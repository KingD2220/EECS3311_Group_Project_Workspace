package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentMethodJUnitTests {
	
	PaymentMethod payment = new PaymentMethod();
	@Test
	public void testSetCreditCard() {
		payment.setCredit_card_number("1234 2233 3223 3333");
		assertEquals("1234 2233 3223 3333", payment.getCredit_card_number());
	}
	
	@Test
	public void testGetCreditCard() {
		payment.setCredit_card_number("1234 2233 3223 3333");
		assertEquals("1234 2233 3223 3333", payment.getCredit_card_number());
	}
	
	@Test
	public void testSetExpiryDate() {
		payment.setExpiry("03/23");
		assertEquals("03/23", payment.getExpiry());
	}
	
	@Test
	public void testGetExpiryDate() {
		payment.setExpiry("03/23");
		assertEquals("03/23", payment.getExpiry());
	}
	
	@Test
	public void testSetCVV() {
		payment.setCvv(000);
		assertEquals(000, payment.getCvv());
	}
	
	@Test
	public void getCVV() {
		payment.setCvv(000);
		assertEquals(000, payment.getCvv());
	}
	
	@Test
	public void setCustomer_id() {
		payment.setCustomer_id(01);
		assertEquals(01, payment.getCustomer_id());
	}
	
	@Test
	public void getCustomer_id() {
		payment.setCustomer_id(01);
		assertEquals(01, payment.getCustomer_id());
	}
}
