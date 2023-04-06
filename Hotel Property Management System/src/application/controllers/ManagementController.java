package application.controllers;

import javax.swing.JTextField;

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
    private ManagementLogic management = new ManagementLogic(new RealDatabase());
    
	public ManagementController(JTextField employeeNum, JTextField employeeFirstName, JTextField employeeLastName, JTextField jobType, JTextField employeeEmail, 
			JTextField employeePhone, JTextField employeeAddress, JTextField hourly) {
		super();
		this.employeeNum = employeeNum;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.jobType = jobType;
		this.employeeEmail = employeeEmail;
		this.employeePhone = employeePhone;
		this.employeeAddress = employeeAddress;
		this.hourly = hourly;
	}
    
    public void getAndDispEmpl() {
    	Employee newEmployee = management.getEmployee(Integer.parseInt(employeeNum.getText()));
    	employeeFirstName.setText(newEmployee.getFirst_name());
    	employeeLastName.setText(newEmployee.getLast_name());
        jobType.setText(newEmployee.getRole());
        employeeEmail.setText(newEmployee.getEmail());
        employeePhone.setText(newEmployee.getPhone_num());
        employeeAddress.setText(newEmployee.getAddress());
        hourly.setText(newEmployee.getHourlyWage());
    }
	
    //Adds employee to list of employees. Returns true if successful and false if an error occurred.
    public boolean addEmployee() {
    	boolean added = false;
    	
    	if (inputValid()) { //Ensures all input is valid
    		Employee emp = new Employee();
    	
    		emp.setFirst_name(employeeFirstName.getText());
    		emp.setLast_name(employeeLastName.getText());
    		emp.setRole(jobType.getText());
    		emp.setEmail(employeeEmail.getText());
    		emp.setPhone_num(employeePhone.getText());
    		emp.setAddress(employeeAddress.getText());
    		emp.setHourlyWage(hourly.getText());
    		
    		int empId = management.addEmployee(emp);
    		
    		if(empId != 0) { //successfully added
    			ManagerFrame.feedback.setText("Employee " + empId + " added.");
    			
    			added = true;
    		}
    		else { //error adding employee
    			ManagerFrame.feedback.setText("Employee not added.");
    		}
    	}
    	return added;
    }
    
    //Checks if input are valid for employee
    public boolean inputValid() {
    	boolean valid = true;
    	
    	//Ensures fields are non-empty
    	if (employeeFirstName.getText().isEmpty() || employeeLastName.getText().isEmpty() || jobType.getText().isEmpty() || employeeEmail.getText().isEmpty() || 
    			employeePhone.getText().isEmpty() || employeeAddress.getText().isEmpty() || hourly.getText().isEmpty()) {
    		ManagerFrame.feedback.setText("Employee not added. Make sure all fields are non-empty.");
    		valid = false;
    	}
    	
		//Check phone number
		if (!employeePhone.getText().matches("^[0-9]{10}$")) { //Invalid if not 10 digit number
			ManagerFrame.feedback.setText("Phone Number is not valid.");
			valid = false;
		}
		
		//Check hourly wage
		try {
			double d = Double.parseDouble(hourly.getText()); //Convert hourly into double
			String[] splitter = hourly.getText().split("\\.");
			int decimalPlaces = splitter[1].length();
			
			if (decimalPlaces != 2) { //Number does not have 2 decimals
				ManagerFrame.feedback.setText("Hourly wage must have 2 decimals.");
				valid = false;
			}
		} catch (Exception e) {
			ManagerFrame.feedback.setText("Hourly wage is not valid. Please make sure the value contains dollars and cents.");
			return false;
		}
	
		return valid;
    }
    
    public boolean salaryUpdate(String emplNum, String hoursWorked) {
    	Employee employee;
	    employee = management.getEmployee(Integer.parseInt(emplNum));
	    employee.setHoursWorked(hoursWorked);
	    employee.calculateWage();
	    return management.setSalary(employee);
	    
		
	}
}
