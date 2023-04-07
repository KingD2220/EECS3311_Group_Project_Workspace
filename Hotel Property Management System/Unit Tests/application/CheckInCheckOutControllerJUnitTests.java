package application;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import application.controllers.CheckInCheckOutController;
import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import persistence.DatabaseStubs;

public class CheckInCheckOutControllerJUnitTests {
	SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
	String dateToday = LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
	Reservation res1;	//arrival reservation for today
	Reservation res2; 	//departure reservation for today
	
	private CheckInCheckOutController testController = new CheckInCheckOutController();
	private ReservationLogic logic = new ReservationLogic(new DatabaseStubs());
	
	@Before
	public void setUp() {	//
		testController.setLogic(new DatabaseStubs());
		
		Date today = null;
		try {
			today = formatter.parse(dateToday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//check-in reservation - add one to today's date to set departure date since arrival date will be today's date 
		Calendar date1 = Calendar.getInstance();
		date1.setTime(today);
		date1.add(Calendar.DATE, 1);
		String departureDate = formatter.format(date1.getTime());
	
		res1 = new Reservation("Foo", "Bar", "123 Hello World Dr.", "4234459899", "2344543409874569"); //check-in reservation
        res1.setArrival_date(dateToday);	
        res1.setDeparture_date(departureDate);
        res1.setRoomType("Executive");
        logic.addReservation(res1);
        res1.setResNumber(1);
        res1.setRoomNum("107");
        
        // check-out reservation - subtract one from today's date to set as arrival date
		Calendar date2 = Calendar.getInstance();
		date2.setTime(today);
		date2.add(Calendar.DATE, -1);
		String arrivalDate = formatter.format(date2.getTime());
        
		res2 = new Reservation("Test", "Case", "100 Java Ave.", "3429980982", "2345099845980983");	//check-out reservation
        res2.setArrival_date(arrivalDate);
        res2.setDeparture_date(dateToday);
        res2.setRoomType("Presidential");
        logic.addReservation(res2);
        res2.setResNumber(2);
		res2.setRoomNum("108");
		res2.setCheckedOut("NO");

	}
	
	//Retrieve specific arrival reservation based off of reservation number
	@Test
	public void testGetResByResNum() {
		String resNum = Integer.toString(res1.getResNumber());	
		assertNotNull(testController.getResByResNum(resNum));
	}
	
	//Retrieve specific departure reservation based off of room number
	@Test
	public void testGetResByRoomNum() {
		assertNotNull(testController.getResByRoomNum(res2.getRoomNum(), "Departure"));
	}
	
	//Retrieve all reservations that are arriving today 
	@Test
	public void testGetResByDate() throws NullPointerException {
		assertTrue(testController.getResByDate("Arrivals"));
	}

	@Test
	public void testCancelReservation() {
		String resNum = Integer.toString(res1.getResNumber());
		assertTrue(testController.cancelReservation(resNum));
	}
	
	@Test
	public void testBuildRow() {
		Object[] expectedResult = new Object[] {"Bar, Foo", "23-04-07", "23-04-08", "Executive", "107", 1};
		assertArrayEquals(expectedResult, testController.buildRow(res1));
	}
	
	@Test
	public void testGetRoomRate() {
		assertEquals("500.00", testController.getRoomRate(Integer.toString(res1.getResNumber())));
		assertEquals("1000.00", testController.getRoomRate(Integer.toString(res2.getResNumber())));
	}
}
