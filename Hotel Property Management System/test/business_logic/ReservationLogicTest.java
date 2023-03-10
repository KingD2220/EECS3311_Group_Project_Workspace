package business_logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain_objects_Rooms.Reservation;
import domain_objects_Rooms.StandardRoom;
import persistence.DatabaseStubs;

public class ReservationLogicTest {
	
	Reservation mockRes;
	DatabaseStubs stubs = new DatabaseStubs();
	ReservationLogic test  = new ReservationLogic(stubs);
	DatabaseStubs data = new DatabaseStubs();
	
	@Before
	public void setUp() throws Exception {
		mockRes = new Reservation("","","","","");
	}
	
	@Test
	public void testAddReservation() {
		test.addReservation(mockRes);
		assertEquals(mockRes, stubs.getReservation(mockRes.getResNumber()));	
	}
	
	@Test
	public void testRemoveReservation() {
		test.addReservation(mockRes);
		test.removeReservation(mockRes.getResNumber());
		assertNull(stubs.getReservation(mockRes.getResNumber()));
	}
	
	@Test
	public void testChangeResDatesArrival() {
		test.changeResDates(mockRes, "02-02-23", "");
		assertEquals(mockRes.getArrival_date(), "02-02-23");
	}
	
	@Test
	public void testChangeResDatesDeparture() {
		test.changeResDates(mockRes, "", "03-03-23");
		assertEquals(mockRes.getDeparture_date(), "03-03-23");
	}
	
	@Test
	public void testRoomAvailableTrue() {
		assertNotNull(ReservationLogic.roomAvailable("Standard"));
	}
	
	@Test
	public void testRoomAvailableFalse() {
		StandardRoom testRoom = new StandardRoom();
		
		//Reserves rooms until none available
		while (testRoom.getRoomsAvailable() != 0) {
			testRoom.roomReserved();
		}
		
		assertNull(ReservationLogic.roomAvailable("Standard"));
	}

}
