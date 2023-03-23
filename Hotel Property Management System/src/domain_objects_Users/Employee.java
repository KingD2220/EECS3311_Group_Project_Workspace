package domain_objects_Users;

public class Employee extends Profile {
	// make separate account class to associate employee for login credentials
	protected int employeeID;
	protected double employeeWage; 
	protected int weeklyHours;
	private static int totalEmployees = 1;
	
	public Employee() {
		super();
		this.employeeID = totalEmployees++;
	}
	                                  

}
