package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

import domain_objects_Rooms.DeluxeRoom;
import domain_objects_Rooms.StandardRoom;

public class DeluxeRoomJUnitTestsTest {
	DeluxeRoom room = new DeluxeRoom();

	@Test
	public void testGetRoomType() {
		assertEquals("Deluxe", room.getRoomType());
	}
	
	@Test
	public void testGetBedType() {
		assertEquals("Queen", room.getBedType());
	}
	
	@Test
	public void testGetNumberOfBeds() {
		assertEquals(1, room.getNumberOfBeds());
	}
	
	@Test
	public void testGetOccupancy() {
		assertEquals(2, room.getOccupancy());
	}

	@Test
	public void testGetRoomSize() {
		assertEquals(400, room.getRoomSize());
	}
	
	@Test
	public void testGetRate() {
		assertEquals(200.00, room.getRate(), 0.05);
	}

	@Test
	public void testGetRoomsAvailable() {
		assertEquals(10, room.getRoomsAvailable());
	}
	
	
}
