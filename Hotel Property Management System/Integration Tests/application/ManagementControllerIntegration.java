package application;

import static org.junit.Assert.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import application.controllers.ManagementController;
import application.frames.ManagerFrame;

public class ManagementControllerIntegration {
	
	JTextField employeeNum = new JTextField();
    JTextField employeeFirstName = new JTextField();
    JTextField employeeLastName = new JTextField();
    JTextField jobType = new JTextField();
    JTextField employeeEmail = new JTextField();
    JTextField employeePhone = new JTextField();
    JTextField employeeAddress = new JTextField();
    JTextField hourly = new JTextField();
    
    ManagementController test = new ManagementController(employeeNum, employeeFirstName, employeeLastName, jobType, 
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

    //Test add employee to database
    @Test
    public void addEmployeeValid() {
    	assertTrue(test.addEmployee());
    }
    
    //Test salary update in database
	@Test
	public void salaryUpdateTest() {
		test.addEmployee();
		
		String hoursWorked = "40";
		
		assertTrue(test.salaryUpdate(employeeNum.getText(), hoursWorked));
	}
}
