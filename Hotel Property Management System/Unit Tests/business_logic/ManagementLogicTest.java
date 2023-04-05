package business_logic;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import domain_objects_Users.Employee;
import domain_objects_Rooms.*;
import persistence.DatabaseStubs;

public class ManagementLogicTest {
	
	DatabaseStubs stubs = new DatabaseStubs();
	ManagementLogic test = new ManagementLogic(stubs);
	
	@Test
	public void testRoomSearch() {
		Room room1 = new StandardRoom();
		room1.setRoomNum("1");
		stubs.addRoom(room1);
		
		Room room2 = new DeluxeRoom();
		room2.setRoomNum("2");
		stubs.addRoom(room2);
		
		Room room3 = new ExecutiveSuite();
		room3.setRoomNum("3");
		stubs.addRoom(room3);
		
		Room room4 = new PresidentialSuite();
		room4.setRoomNum("4");
		stubs.addRoom(room4);
		
		Room room5 = new SuiteRoom();
		room5.setRoomNum("5");
		stubs.addRoom(room5);
		
		ArrayList <Room> list = new ArrayList<>();
		list.add(room2);
		list.add(room3);
		list.add(room4);
		
		assertEquals(list, test.roomSearch("2", "4"));
	}

	@Test
	public void testGetEmployee() {
		Employee emp = new Employee();
		emp.setEmployeeID("1");
		
		stubs.addEmployee(emp);
		
		assertEquals(emp, test.getEmployee(1));
	}
	
	@Test
	public void testRoomStatusUpdate() {
		Room room = new StandardRoom();
		room.setRoomNum("1");
		stubs.addRoom(room);
		
		String status = "DIRTY";
		
		test.roomStatusUpdate("1", status);
		
		assertEquals(status, room.getRoomStatus());
	}

}
