package Management_Logic_Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business_logic.ManagementLogic;
import domain_objects_Rooms.*;
import domain_objects_Users.Employee;
import java.util.ArrayList;

import persistence.Database;
import persistence.RealDatabase;

public class ManagementLogicIntegration {
	
	ManagementLogic managementLogic;
	Database database = new RealDatabase();
	
	Employee emp;
	
	@Before
	public void setUp() throws Exception {
		managementLogic = new ManagementLogic(database);
		
		//Create employee and populate data
		emp = new Employee();
		emp.setFirst_name("Bob");
		emp.setLast_name("Smith");
		emp.setAddress("123 House St.");
		emp.setPhone_num("1234567890");
		emp.setHourlyWage("10.25");
		emp.setRole("Manager");
		emp.setEmail("something@email.com");
	}
	
	//Checks that roomSearch returns rooms in the correct range
	@Test
	public void roomSearchTest() {
		ArrayList<Room> result = managementLogic.roomSearch("100", "200"); //Get list of rooms between room number 100 - 200
		
		assertEquals(result.get(0).getRoomNum(), "100"); //Check first room in the list
		assertEquals(result.get(result.size()-1).getRoomNum(), "200"); //Check last room in the list
		assertEquals(result.get(5).getRoomNum(), "105"); //Check room in the middle of list
	}
	
	@Test
	public void addEmployeeTest() {
		int empId = managementLogic.addEmployee(emp);
		
		assertNotEquals(empId, 0);
	}
	
	@Test
	public void getEmployeeTest() {
		int empId = database.addEmployee(emp);
		
		Employee empTest = managementLogic.getEmployee(empId);
		
		assertEquals(empTest.getEmployeeID(), Integer.toString(empId));
	}
	
	@Test
	public void roomStatusUpdateTest() {
		managementLogic.roomStatusUpdate("500", "DIRTY"); //Set room to dirty
		
		ArrayList<Room> result = managementLogic.roomSearch("500", "500"); //Get room from database
		
		assertEquals(result.get(0).getRoomStatus(), "DIRTY");
	}
	
	@Test
	public void setSalaryTest() {
		int empId = database.addEmployee(emp); //add employee to database
		
		emp.setEmployeeID(empId + ""); //set employee id of employee
		
		assertTrue(managementLogic.setSalary(emp));
	}

}
