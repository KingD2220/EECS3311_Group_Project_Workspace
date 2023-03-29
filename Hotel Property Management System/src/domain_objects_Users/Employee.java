package domain_objects_Users;

public class Employee extends Profile {
	// make separate account class to associate employee for login credentials
	protected String employeeID;
	protected double employeeWage; 
	protected String weeklyWage;
	protected String hourlyWage;
	protected String hoursWorked;
	
	public String getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(String hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public Employee() {
		super();
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}


	public String getWeeklyWage() {
		int hourly = Integer.parseInt(getHourlyWage());
		int hours = Integer.parseInt(getHoursWorked());
		this.weeklyWage = ""+hourly * hours;
		return this.weeklyWage;
	}

	public void setWeeklyWage(String weeklyWage) {
		
		this.weeklyWage = weeklyWage;
	}

	public String getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(String hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	                                  

}
