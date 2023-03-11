package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

import domain_objects_Users.Employee;

public class EmployeeClassJUnitTestsTest {
	Employee employee = new Employee();
	
	@Test
	public void testSetFirstName() {
		employee.setFirst_name("First");
		assertEquals("First", employee.getFirst_name());
	}
	
	@Test
	public void testgetFirstName() {
		employee.setFirst_name("First");
		assertEquals("First", employee.getFirst_name());
	}
	
	@Test
	public void testSetLastName() {
		employee.setLast_name("Last");
		assertEquals("Last", employee.getLast_name());
	}
	
	@Test
	public void testgetLastName() {
		employee.setLast_name("Last");
		assertEquals("Last", employee.getLast_name());
	}
	
	@Test
	public void testSetAddress() {
		employee.setAddress("123 Street Ave");
		assertEquals("123 Street Ave", employee.getAddress());
	}
	
	@Test
	public void testGetAddress() {
		employee.setAddress("123 Street Ave");
		assertEquals("123 Street Ave", employee.getAddress());
	}
	
	@Test
	public void testSetPhoneNumber() {
		employee.setPhone_num("123 456 7891");
		assertEquals("123 456 7891", employee.getPhone_num());
	}
	
	@Test
	public void testGetPhoneNumber() {
		employee.setPhone_num("123 456 7891");
		assertEquals("123 456 7891", employee.getPhone_num());
	}
	
}
