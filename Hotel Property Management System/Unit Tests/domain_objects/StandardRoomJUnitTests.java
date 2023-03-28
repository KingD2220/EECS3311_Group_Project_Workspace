package domain_objects;

import static org.junit.Assert.*;

import java.lang.*;

import org.junit.Test;

import domain_objects_Rooms.StandardRoom;

public class StandardRoomJUnitTests {
	StandardRoom room = new StandardRoom();

	@Test
	public void testGetRoomType() {
		assertEquals("Standard", room.getRoomType());
	}

	@Test
	public void testGetRate() {
		assertEquals(100.00, room.getRate(), 0.05);
	}

	@Test
	public void testGetRoomsAvailable() {
		assertEquals(10, room.getRoomsAvailable());
	}
	
	
	

}
