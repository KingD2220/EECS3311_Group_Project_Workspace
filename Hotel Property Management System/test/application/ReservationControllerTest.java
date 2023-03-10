package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import java.util.Date;
import java.util.Calendar;

import domain_objects_Rooms.StandardRoom;

public class ReservationControllerTest {
	
	JTextField fName = new JTextField();
	JTextField lName = new JTextField();
	JPasswordField creditCard = new JPasswordField();
	JTextField adress = new JTextField();
	JTextField phoneNum = new JTextField();
	JComboBox<Object> roomtype = new JComboBox<Object>();
	JDateChooser startDate = new JDateChooser();
	JDateChooser endDate = new JDateChooser();

	
	ReservationController testController = new ReservationController(fName, lName, creditCard, adress, phoneNum, roomtype, startDate, endDate);
		
	@Before
	public void setUp() throws Exception {
		//Setup class requirements
		CreateReservationFrame.feedback = new JTextArea();
		roomtype.setModel(new DefaultComboBoxModel<Object>(new String[] {"Standard", "Deluxe", "Suite", "Executive", "Presidential"}));
		
		//Setup valid test data
		fName.setText("Bob");
		lName.setText("Smith");
		creditCard.setText("1234123412341234");
		adress.setText("123 Home");
		phoneNum.setText("1231234567");
		
		//Setup valid test dates
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2024, 1, 1);
		Date tempDate = calendar.getTime();
		startDate.setDate(tempDate);
		
		calendar.set(2024, 1, 31);
		tempDate = calendar.getTime();
		endDate.setDate(tempDate);	
	}
	
	//Case when create reservation is pressed and there is a room available for selected type (reservation should be created)
	@Test
	public void buttonPressed() {
		roomtype.setSelectedItem("Deluxe");
		
		testController.actionPerformed(null);
		
		assertNotNull(testController.newRes);
	}
	
	//Case when create reservation is pressed and there is no room available for selected type (no reservation should be created)
	@Test
	public void buttonPressedNoRoom() {
		StandardRoom testRoom = new StandardRoom();
		
		//Reserves rooms until none available
		while (testRoom.getRoomsAvailable() != 0) {
			testRoom.roomReserved();
		}
		
		roomtype.setSelectedItem("Standard");
		
		testController.actionPerformed(null);
		
		assertNull(testController.newRes);
	}
	
	//Tests input valid when input is valid
	@Test
	public void inputValid() {
		assertTrue("Error: Valid input is recognized as invalid", testController.inputValid("1234123412341234"));
	}
		
	//Tests inputValid when phone input not valid (not 10 digit number)
	@Test
	public void inputPhoneNotValid() {
		phoneNum.setText("123");
			
		assertFalse("Error: Invalid phone input is recognized as valid", testController.inputValid("1234123412341234"));
	}
		
	//Tests inputValid when credit card input not valid (not 16 digit number)
	@Test
	public void inputCardNotValid() {	
		assertFalse("Error: Invalid phone input is recognized as valid", testController.inputValid("123"));
	}
	
	//Tests inputValid when start date is after end date (invalid)
	@Test
	public void inputStartAfterEndNotValid() {
		//Setup start date after end date
		Calendar calendar = Calendar.getInstance();
			
		calendar.set(2024, 2, 1);
		Date tempDate = calendar.getTime();
		startDate.setDate(tempDate);
			
		calendar.set(2024, 1, 1);
		tempDate = calendar.getTime();
		endDate.setDate(tempDate);	
			
		assertFalse("Error: Start date cannot be after end date", testController.inputValid("1234123412341234"));
	}
		
	//Tests inputValid when start date is after end date (invalid)
	@Test
	public void inputStartAfterCurrentNotValid() {
		//Setup start date before current date
		Calendar calendar = Calendar.getInstance();
					
		calendar.set(2022, 1, 1);
		Date tempDate = calendar.getTime();
		startDate.setDate(tempDate);
					
		assertFalse("Error: Start date cannot be before current date", testController.inputValid("1234123412341234"));
	}
}

