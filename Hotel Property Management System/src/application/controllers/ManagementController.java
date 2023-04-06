package application.controllers;

import javax.swing.JTextField;

import application.frames.CreateReservationFrame;
import application.frames.ManagerFrame;

import javax.swing.JLabel;

import business_logic.ManagementLogic;
import domain_objects_Users.Employee;
import persistence.RealDatabase;

public class ManagementController {
    private JTextField employeeNum;
    private JTextField employeeFirstName;
    private JTextField employeeLastName;
    private JTextField jobType;
    private JTextField employeeEmail; 
    private JTextField employeePhone;
    private JTextField employeeAddress;
    private JTextField hourly;
    private JTextField hoursWorked;
    private JTextField pay;
    private ManagementLogic management = new ManagementLogic(new RealDatabase());
    
	public ManagementController(JTextField employeeNum, JTextField employeeFirstName, JTextField employeeLastName, JTextField jobType, JTextField employeeEmail, 
			JTextField employeePhone, JTextField employeeAddress, JTextField hourly, JTextField hoursWorked, JTextField pay) {
		super();
		this.employeeNum = employeeNum;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.jobType = jobType;
		this.employeeEmail = employeeEmail;
		this.employeePhone = employeePhone;
		this.employeeAddress = employeeAddress;
		this.hourly = hourly;
		this.hoursWorked = hoursWorked;
		this.pay = pay;
	}
    
    public void getAndDispEmpl() {
    	Employee newEmployee = management.getEmployee(Integer.parseInt(employeeNum.getText()));
    	employeeFirstName.setText(newEmployee.getFirst_name());
    	employeeLastName.setText(newEmployee.getLast_name());
        jobType.setText(newEmployee.getRole());
        employeeEmail.setText(newEmployee.getEmail());
        employeePhone.setText(newEmployee.getPhone_num());
        employeeAddress.setText(newEmployee.getAddress());
        hoursWorked.setText(newEmployee.getHoursWorked());
        hourly.setText(newEmployee.getHourlyWage());
        pay.setText(newEmployee.getWeeklyWage());
    }
	
    public void addEmployee() {
    	if (inputValid()) {
    		Employee emp = new Employee();
    	
    		emp.setFirst_name(employeeFirstName.getText());
    		emp.setLast_name(employeeLastName.getText());
    		emp.setRole(jobType.getText());
    		emp.setEmail(employeeEmail.getText());
    		emp.setPhone_num(employeePhone.getText());
    		emp.setAddress(employeeAddress.getText());
    		emp.setHourlyWage(hourly.getText());
    		emp.setHoursWorked(hoursWorked.getText());
    		emp.setWeeklyWage(pay.getText());
    	
    		ManagerFrame.feedback.setText("Employee added.");
    		ManagerFrame.feedback.setVisible(true);
    	}
    }
    
    public boolean inputValid() {
    	boolean valid = true;
    	
		//Check phone number
		if (!employeePhone.getText().matches("^[0-9]{10}$")) { //Invalid if not 10 digit number
			ManagerFrame.feedback.setText("Phone Number is not valid.");
			ManagerFrame.feedback.setVisible(true);
			valid = false;
		}
		
		//Check hourly wage
		try {
			double d = Double.parseDouble(hourly.getText());
		} catch (NumberFormatException nfe) {
			ManagerFrame.feedback.setText("Hourly wage is not valid.");
			ManagerFrame.feedback.setVisible(true);
			return false;
		}
		
		//Check hours worked
		try {
			Integer i = Integer.parseInt(hoursWorked.getText());
		} catch (NumberFormatException nfe) {
			ManagerFrame.feedback.setText("Hours worked is not an integer");
			ManagerFrame.feedback.setVisible(true);
			return false;
		}
		
		return valid;
    }
}
