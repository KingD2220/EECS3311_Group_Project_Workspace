package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

import domain_objects_Rooms.StandardRoom;
import domain_objects_Rooms.SuiteRoom;

public class SuiteRoomJUnitTests {
	
	SuiteRoom room = new SuiteRoom();

	@Test
	public void testGetRoomType() {
		assertEquals("Suite", room.getRoomType());
	}
	
	@Test
	public void testGetRate() {
		assertEquals(300.00, room.getRate(), 0.05);
	}

	@Test
	public void testGetRoomsAvailable() {
		assertEquals(10, room.getRoomsAvailable());
	}
}
