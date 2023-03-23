package Reservation_logic_Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import domain_objects_Rooms.StandardRoom;
import persistence.Database;
import persistence.RealDatabase;

public class ReservationLogicIntegration {
	ReservationLogic reservationLogic;
	Database database = new RealDatabase();
	Reservation Res; 
	@Before
	public void setUp() {
	    Res = new Reservation("","","","","");
		reservationLogic = new ReservationLogic(database);
	}
	
	@Test
	public void testAddReservation() {
		reservationLogic.addReservation(Res);
		assertNotNull(database.getReservation(Res.getResNumber()));	
	}
	
	@Test
	public void testChangeResDatesArrival() {
		reservationLogic.changeResDates(Res, "02-02-23", "");
		assertEquals(Res.getArrival_date(), "02-02-23");
	}
	
	@Test
	public void testRemoveReservation() {
		database.addReservation(Res);
		database.removeReservation(Res.getResNumber());
		assertNull(database.getReservation(Res.getResNumber()));
	}
	
	@Test
	public void testChangeResDatesDeparture() {
		reservationLogic.changeResDates(Res, "", "03-03-23");
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
