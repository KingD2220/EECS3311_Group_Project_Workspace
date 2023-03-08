package domain_objects;

import static org.junit.Assert.*;

import org.junit.Test;

import domain_objects_Rooms.Reservation;
import domain_objects_Rooms.StandardRoom;
import domain_objects_Rooms.SuiteRoom;

public class ReservationClassTest {

	
	Reservation reservation = new Reservation("Firstname", "Lastname","123 Street Ave", "647 456 7891", "1234 4312 3312 2333");

	@Test
	public void testSetArrivalDate() {
		reservation.setArrival_date("March 8 2023");
		assertEquals("March 8 2023", reservation.getArrival_date());
	}
	
	@Test
	public void testGetArrivalDate() {
		reservation.setArrival_date("March 8 2023");
		assertEquals("March 8 2023", reservation.getArrival_date());
	}
	
	@Test
	public void testSetDeparture_Date() {
		reservation.setDeparture_date("March 15 2023");
		assertEquals("March 15 2023", reservation.getDeparture_date());
	}
	
	@Test
	public void testGetDeparture_Date() {
		reservation.setDeparture_date("March 15 2023");
		assertEquals("March 15 2023", reservation.getDeparture_date());
	}
	
	@Test
	public void testSetRoom() {
		StandardRoom room = new StandardRoom();
		reservation.setRoom(room);;
		assertEquals(room, reservation.getRoom());
	}
	
	@Test
	public void testGetRoom() {
		StandardRoom room = new StandardRoom();
		reservation.setRoom(room);;
		assertEquals(room, reservation.getRoom());
	}
	
	@Test
	public void testSetResNum() {
		reservation.setResNumber(1);;
		assertEquals(1, reservation.getResNumber());
	}
	
	@Test
	public void testGetResNum() {
		reservation.setResNumber(1);;
		assertEquals(1, reservation.getResNumber());
	}
	
}
