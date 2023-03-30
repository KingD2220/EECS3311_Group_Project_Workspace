package application.controllers;

import javax.swing.JTextField;

import business_logic.ManagementLogic;
import domain_objects_Users.Employee;
import persistence.RealDatabase;

public class ManagementController {
    private JTextField employeeNum;
    private JTextField emplyeeName;
    private JTextField jobType;
    private JTextField employeeEmail; 
    private JTextField hourly;
    private JTextField hoursWorked;
    private JTextField pay;
    private ManagementLogic management = new ManagementLogic(new RealDatabase());
    
	public ManagementController(JTextField employeeNum, JTextField emplyeeName, JTextField jobType,
			JTextField employeeEmail, JTextField hourly, JTextField hoursWorked, JTextField pay) {
		super();
		this.employeeNum = employeeNum;
		this.emplyeeName = emplyeeName;
		this.jobType = jobType;
		this.employeeEmail = employeeEmail;
		this.hourly = hourly;
		this.hoursWorked = hoursWorked;
		this.pay = pay;
	}
    
    public Employee getAndDispEmpl() {
    	StringBuilder name = new StringBuilder();
    	Employee newEmployee = new Employee();
    	newEmployee = management.getEmployee(employeeNum.getText());
    	name.append(newEmployee.getFirst_name()+" ");
    	name.append(newEmployee.getLast_name());
    	emplyeeName.setText(name.toString());
		return newEmployee;
    	
    }
	
}
