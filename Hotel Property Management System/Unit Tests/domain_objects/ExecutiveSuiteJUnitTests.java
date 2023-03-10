package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

import domain_objects_Rooms.ExecutiveSuite;
import domain_objects_Rooms.SuiteRoom;

public class ExecutiveSuiteJUnitTests {

	
	ExecutiveSuite room = new ExecutiveSuite();

	@Test
	public void testGetRoomType() {
		assertEquals("Executive Suite", room.getRoomType());
	}
	
	@Test
	public void testGetBedType() {
		assertEquals("King", room.getBedType());
	}
	
	@Test
	public void testGetNumberOfBeds() {
		assertEquals(2, room.getNumberOfBeds());
	}
	
	@Test
	public void testGetOccupancy() {
		assertEquals(4, room.getOccupancy());
	}

	@Test
	public void testGetRoomSize() {
		assertEquals(900, room.getRoomSize());
	}
	
	@Test
	public void testGetRate() {
		assertEquals(500.00, room.getRate(), 0.05);
	}

	@Test
	public void testGetRoomsAvailable() {
		assertEquals(10, room.getRoomsAvailable());
	}
}
