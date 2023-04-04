package domain_objects_Users;

public class Employee extends Profile {
	// make separate account class to associate employee for login credentials
	protected String employeeID;
	protected String weeklyWage;
	protected String hourlyWage;
	protected String hoursWorked;
	protected String email;
	protected String role;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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


	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", weeklyWage=" + weeklyWage + ", hourlyWage=" + hourlyWage
				+ ", hoursWorked=" + hoursWorked + ", email=" + email + ", role=" + role + "]";
	}

	public String getWeeklyWage() {
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
