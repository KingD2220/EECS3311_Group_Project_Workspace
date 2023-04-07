package application;

import static org.junit.Assert.*;

import javax.swing.JTextField;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import application.controllers.ManagementController;
import application.frames.ManagerFrame;

public class ManagementControllerTest {
	
	private JTextField employeeNum = new JTextField();
    private JTextField employeeFirstName = new JTextField();
    private JTextField employeeLastName = new JTextField();
    private JTextField jobType = new JTextField();
    private JTextField employeeEmail = new JTextField();
    private JTextField employeePhone = new JTextField();
    private JTextField employeeAddress = new JTextField();
    private JTextField hourly = new JTextField();
    
    
    private ManagementController test = new ManagementController(employeeNum, employeeFirstName, employeeLastName, jobType, 
    		employeeEmail, employeePhone, employeeAddress, hourly);
    
	
    @Before
	public void setUp() throws Exception {
    	ManagerFrame.feedback = new JLabel();
    	
    	//Populate fields with valid data
    	employeeNum.setText("1");
    	employeeFirstName.setText("Bob");
    	employeeLastName.setText("Smith");
    	jobType.setText("Manager");
    	employeeEmail.setText("something@email.com");
    	employeePhone.setText("1234567890");
    	employeeAddress.setText("123 Street St");
    	hourly.setText("10.25");
	}
    
    @Test
    //Should accept when all input is valid
    public void inputValidTest() {
    	assertTrue("Error: Valid input not accepted.", test.inputValid());
    }
    
    //Should not accept empty fields
	@Test
	public void inputValidEmptyFields() {
		employeeFirstName.setText("");
		
		assertFalse("Error: Empty fields should not be accepted.", test.inputValid());
	}
	
	//Should not accept phone number if it is not a number
	@Test
	public void inputValidPhoneNotNumber() {
		employeePhone.setText("Not a number");
		
		assertFalse("Error: Non-number phone is accepted.", test.inputValid());
	}
	
	//Should not accept non 10 phone digit number
	@Test
	public void inputValidPhoneInvalid() {
		employeePhone.setText("123");
		
		assertFalse("Error: Invalid phone number is accepted", test.inputValid());
	}
	
	//Should not accept hourly wage that is not a number
	@Test
	public void inputValidHourlyNotNumber() {
		hourly.setText("Not a number"); //Change hourly wage to integer
		
		assertFalse("Error: Non-number wage is accepted.", test.inputValid());
	}
	
	//Should not accept hourly wage without cents
	@Test
	public void inputValidHourlyInteger() {
		hourly.setText("10"); //Change hourly wage to integer
		
		assertFalse("Error: Dollar amount without cents accepted.", test.inputValid());
	}
	
	//Should not accept hourly wage without exactly 2 decimals
	@Test
	public void inputValidHourlyInvalidCents() {
		hourly.setText("10.1"); //Change hourly wage to integer
		
		assertFalse("Error: Wrong decimal places accepted.", test.inputValid());
	}
}
