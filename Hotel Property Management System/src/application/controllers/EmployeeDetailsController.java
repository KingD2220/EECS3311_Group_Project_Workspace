package application.controllers;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import business_logic.ManagementLogic;
import domain_objects_Users.Employee;
import persistence.RealDatabase;

public class EmployeeDetailsController {
	private JTextField employeeNum;
    private JTextArea roleName;
    private JTextArea firstName;
    private JTextArea lastName;
    private JTextArea phoneNum;
    private JTextArea address;
    private JTextArea email;
    private JTextArea hoursWorked;
    private JTextArea hourlyPay;
    private JTextArea pay;
    private ManagementLogic management = new ManagementLogic(new RealDatabase());
    
    public EmployeeDetailsController(JTextField employeeNum, JTextArea roleName, JTextArea firstName, JTextArea lastName, 
    		JTextArea phoneNum, JTextArea address, JTextArea email, JTextArea hoursWorked, JTextArea hourlyPay, JTextArea pay) {
    	super();
    	this.employeeNum = employeeNum;
    	this.roleName = roleName;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.phoneNum = phoneNum;
    	this.address = address;
    	this.email = email;
    	this.hoursWorked = hoursWorked;
    	this.hourlyPay = hourlyPay;
    	this.pay = pay;
    }
    
    public void getAndDisplayEmployee() {
    	Employee emp = management.getEmployee(Integer.parseInt(employeeNum.getText()));
    	
    	roleName.setText(emp.getRole());
    	firstName.setText(emp.getFirst_name());
    	lastName.setText(emp.getLast_name());
    	phoneNum.setText(emp.getPhone_num());
    	address.setText(emp.getAddress());
    	email.setText(emp.getEmail());
    	hoursWorked.setText(emp.getHoursWorked());
    	hourlyPay.setText(emp.getHourlyWage());
    	pay.setText(emp.getWeeklyWage());
    }
    		
}
