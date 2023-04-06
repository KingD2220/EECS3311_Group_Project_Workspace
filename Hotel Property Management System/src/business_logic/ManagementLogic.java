package business_logic;

import java.util.ArrayList;
import domain_objects_Rooms.Room;
import domain_objects_Users.Employee;
import persistence.Database;

public class ManagementLogic {
	private final Database database;
	
	public ManagementLogic(Database database) {
		this.database = database;
	}
	
	// get range of rooms selected by the caller with specifications, if selected.
	public ArrayList<Room> roomSearch(String roomRangeStart, String roomRangeEnd) {
		return database.getRoomStatus(roomRangeStart, roomRangeEnd);
	}
	
	//return employee number if employee successfully added and 0 if not
	public int addEmployee(Employee emp) {
		int empId = database.addEmployee(emp);
		return empId;
	}
	
	public Employee getEmployee(int employeeNum) {
		return database.getEmployee(employeeNum);
	}

	// update room status in database
	public void roomStatusUpdate(String roomNum, String roomStatus) {
		database.updateRoomStatus(roomNum, roomStatus);
	}
	
	public boolean setSalary(Employee empl) {
		return database.setSalary(empl);
	}
}
 
