package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

import domain_objects_Rooms.ExecutiveSuite;
import domain_objects_Rooms.SuiteRoom;

public class PresidentialSuiteJUnitTests {
	
	ExecutiveSuite room = new ExecutiveSuite();

	@Test
	public void testGetRoomType() {
		assertEquals("Executive Suite", room.getRoomType());
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
