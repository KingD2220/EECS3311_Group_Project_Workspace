package Reservation_logic_Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import persistence.Database;
import persistence.RealDatabase;

public class ReservationLogicIntegration {
	ReservationLogic reservationLogic;
	Database database = new RealDatabase();
	Reservation res;
	   String firstName = "Test";
	    String lastName = "Test";
	    String address = "123 Test";
	    String phoneNum = "1";
	    String creditCard = "123456778908";
	@Before
	public void setUp() {
	    res = new Reservation(firstName,lastName,address,phoneNum,creditCard);   
		reservationLogic = new ReservationLogic(database);
	}
	
	public String gneratePhoneNum() {
		int num;
		Random  random = new Random();
		random.setSeed(123456789);
		num = random.nextInt();
		return num+"";
	}
	
	@Test
	public void testAddReservation() {
		String phone = gneratePhoneNum();
		res.customer.setPhone_num(phone);
		assertTrue(reservationLogic.addReservation(res));
		database.removeReservation(database.getLastResNum());
		
	}
	
	@Test
	public void testGetReservation() {
		int resNum = database.getLastResNum();
		res = reservationLogic.getReservation(resNum);
		assertNotNull(res);
		assertNull(reservationLogic.getReservation(resNum+1));
	}
	
	@Test
	public void testChangeResDatesArrival() {
		reservationLogic.changeResDates(res, "02-02-23", "");
		assertEquals(res.getArrival_date(), "02-02-23");
	}
	
	@Test
	public void testRemoveReservation() {
		res = reservationLogic.getReservation(database.getLastResNum());
		database.addReservation(res);
		assertTrue(reservationLogic.removeReservation(res.getResNumber()));
		assertNull(reservationLogic.getReservation(res.getResNumber()));
	}
	
	@Test
	public void testChangeResDatesDeparture() {
		reservationLogic.changeResDates(res, "", "03-03-23");
		assertEquals(res.getDeparture_date(), "03-03-23");
	}
	
	@Test
	public void testRoomAvailableTrue() {
		assertNotNull(ReservationLogic.roomAvailable("Standard"));
		assertNotNull(ReservationLogic.roomAvailable("Suite"));
		assertNotNull(ReservationLogic.roomAvailable("Deluxe"));
		assertNotNull(ReservationLogic.roomAvailable("Executive"));
		assertNotNull(ReservationLogic.roomAvailable("Presidential"));
	}
	
	@Test 
	public void testUpdateReservation() {
		res = database.getReservation(database.getLastResNum());
		assertTrue(reservationLogic.updatReservation(res));
	}
	@Test
	public void testGetReservationsByDate() {
		ArrayList<Reservation> arrayList = new ArrayList<>();
		res = database.getReservation(database.getLastResNum());
		res.setArrival_date("03-03-23");
		res.setDeparture_date("03-03-23");
		database.addReservation(res);
		arrayList = reservationLogic.getReservationsByDate("03-03-23", "Arrivals");
		assertNotNull(arrayList);
		arrayList.remove(res);
		arrayList = reservationLogic.getReservationsByDate("03-03-23", "Departure");
		assertNotNull(arrayList);
		database.removeReservation(res.getResNumber());
	}
	
	@Test
	public void testDaysBetween() {
		long days;
		res.setArrival_date("03-03-23");
		res.setDeparture_date("03-03-26");
	    days = reservationLogic.daysBetween(res);
	    assertEquals(3, days);
		
	}

}
