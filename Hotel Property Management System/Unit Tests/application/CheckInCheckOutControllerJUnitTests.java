package application;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import application.controllers.CheckInCheckOutController;
import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import persistence.DatabaseStubs;

public class CheckInCheckOutControllerJUnitTests {
	JTextField resNumInput = new JTextField();
	JTextField roomNumInput = new JTextField();
	SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
	String dateToday = LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
	Reservation res1;	//arrival reservation for today
	Reservation res2; 	//departure reservation for today
	
	CheckInCheckOutController testController = new CheckInCheckOutController();
	ReservationLogic logic = new ReservationLogic(new DatabaseStubs());
	
	@Before
	public void setUp() {
		Date today = null;
		try {
			today = formatter.parse(dateToday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//add one to today's date to set departure date since arrival date will be today's date 
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
        
        //subtract one from today's date to set as arrival date for check-out reservation
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

	}
	
	@Test
	public void testGetResByResNum() {
		Object[] rowRes1 = new Object[] {res1.customer.getLast_name() + ", " + res1.customer.getFirst_name() + res1.getArrival_date() 
			+ res1.getDeparture_date() + res1.getRoomType() + res1.getRoomNum() + res1.getResNumber()};
	
		String resNum = Integer.toString(res1.getResNumber());
		
		System.out.println(logic.getReservation(res1.getResNumber()));
		
//		assertArrayEquals(rowRes1, testController.getResByResNum(Integer.toString(res1.getResNumber())));		
	}

}
