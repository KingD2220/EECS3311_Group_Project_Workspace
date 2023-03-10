package business_logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain_objects_Rooms.Reservation;
import domain_objects_Rooms.StandardRoom;
import persistence.DatabaseStubs;

public class ReservationLogicTest {
	
	Reservation Res;
	DatabaseStubs stubs = new DatabaseStubs();
	ReservationLogic test  = new ReservationLogic(stubs);
	
	@Before
	public void setUp() throws Exception {
		Res = new Reservation("","","","","");
	}
	
	@Test
	public void testAddReservation() {
		test.addReservation(Res);
		assertEquals(Res, stubs.getReservation(Res.getResNumber()));	
	}
	
	@Test
	public void testRemoveReservation() {
		test.addReservation(Res);
		test.removeReservation(Res.getResNumber());
		assertNull(stubs.getReservation(Res.getResNumber()));
	}
	
	@Test
	public void testChangeResDatesArrival() {
		test.changeResDates(Res, "02-02-23", "");
		assertEquals(Res.getArrival_date(), "02-02-23");
	}
	
	@Test
	public void testChangeResDatesDeparture() {
		test.changeResDates(Res, "", "03-03-23");
		assertEquals(Res.getDeparture_date(), "03-03-23");
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
