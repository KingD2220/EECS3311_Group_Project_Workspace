package domain_objects_Users;

public class Employee extends Profile {
	// make separate account class to associate employee for login credentials
	protected String employeeID;
	protected double employeeWage; 
	protected String weeklWage;
	
	public Employee() {
		super();
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public double getEmployeeWage() {
		return employeeWage;
	}

	public void setEmployeeWage(double employeeWage) {
		this.employeeWage = employeeWage;
	}

	public String getWeeklyWage() {
		return weeklWage;
	}

	public void setWeeklyWage(String string) {
		this.weeklWage = string;
	}
	                                  

}
