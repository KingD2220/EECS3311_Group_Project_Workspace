package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import com.toedter.calendar.JDateChooser;

import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import domain_objects_Rooms.Room;
import persistence.RealDatabase;

/**
 * ReservationController should only be used to take information from front-end and
 * be the middleman for the model/database;
 * should not be changing what the GUI does or looks like.
 */

public class ReservationController implements ActionListener {
	private JTextField fName;
	private JTextField lName;
	private JPasswordField creditCard;
	private JTextField adress;
	private JTextField phoneNum;
	private JComboBox<Object> roomtype;
	private JDateChooser startDate;
	private JDateChooser endDate;
    SimpleDateFormat date = new SimpleDateFormat("yy-MM-dd");
    private JTextField resNum; 
    Reservation newRes;
    RealDatabase database = new RealDatabase();
    ReservationLogic reservationLogic = new ReservationLogic(database);

	public ReservationController(JTextField fName, JTextField lName, JPasswordField creditCard, JTextField adress,
			JTextField phoneNum, JComboBox<Object> roomtype, JDateChooser startDate, JDateChooser endDate) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.creditCard = creditCard;
		this.adress = adress;
		this.phoneNum = phoneNum;
		this.roomtype = roomtype;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public ReservationController(JTextField fName, JTextField lName, JTextField resNum,
			JTextField phoneNum, JTextField adress) {
		this.fName = fName;
		this.lName = lName;
		this.resNum = resNum;
		this.phoneNum = phoneNum;
		this.adress = adress;
	
	}
	
	public void searchAndDisplay() {
		System.out.println(resNum.getText());
	  newRes =reservationLogic.geReservation(Integer.parseInt(resNum.getText()));
	  fName.setText(newRes.customer.getFirst_name());
	  lName.setText(newRes.customer.getLast_name());
	  phoneNum.setText(newRes.customer.getPhone_num());
	  adress.setText(newRes.customer.getAddress());
	  
	  
	}
	public void update() {
		newRes =reservationLogic.geReservation(Integer.parseInt(resNum.getText()));
		newRes.customer.setFirst_name(fName.getText());
		newRes.customer.setLast_name(lName.getText());
		newRes.customer.setPhone_num(phoneNum.getText());
		newRes.customer.setAddress(adress.getText());
		UpdateFrame.feedback.setText(newRes.toString());
	}
	
	//Create Reservation Button Pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String credit = new String(creditCard.getPassword()); //convert credit card into string
		if (inputValid(credit)) { //checks input validity
			Room room = ReservationLogic.roomAvailable(roomtype.getSelectedItem().toString()); //check if room is available
		
			if (room != null) {
				newRes = new Reservation(fName.getText(), lName.getText(), 
						adress.getText(), phoneNum.getText(), credit);
				newRes.setArrival_date(date.format(startDate.getDate()));
				newRes.setDeparture_date(date.format(endDate.getDate()));
				newRes.setRoom(room);
				room.roomReserved();
				reservationLogic.addReservation(newRes);
				CreateReservationFrame.feedback.setText(newRes.toString()); //*does not include room info
			}
			else {
				CreateReservationFrame.feedback.setText("Error: Selected room is not available.");
			}
		}
	}
	
	//Check if reservation input is valid
	private boolean inputValid(String credit) {
		boolean valid = true;
		
		//Check phone number
		if (!phoneNum.getText().matches("^[0-9]{10}$")) { //Invalid if not 10 digit number
			CreateReservationFrame.feedback.setText("Error: Phone number is not valid");
			valid = false;
		}
		
		//Check credit card number
		if (!credit.matches("^[0-9]{16}$")) { //Invalid if not 16 digit number
			CreateReservationFrame.feedback.setText("Error: Credit card is not valid");
			valid = false;
		}
		
		return valid;
	}
		
	
}
