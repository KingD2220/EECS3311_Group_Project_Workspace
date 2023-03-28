package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import com.toedter.calendar.JDateChooser;

import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import domain_objects_Rooms.Room;
import persistence.RealDatabase;


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
    ReservationLogic reservationLogic = new ReservationLogic(new RealDatabase());

/*Constructor*/
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
	/*Overloaded constructor used instead of creating a new class*/ 
	public ReservationController(JTextField fName, JTextField lName, JTextField resNum,
			JTextField phoneNum, JTextField adress) {
		this.fName = fName;
		this.lName = lName;
		this.resNum = resNum;
		this.phoneNum = phoneNum;
		this.adress = adress;
	
	}
	/*To display a saved reservation, we first have to get the reservation, then display 
	 * it in the corresponding fields*/
	public void searchAndDisplay() {
		//System.out.println(resNum.getText());
	  newRes =reservationLogic.getReservation(Integer.parseInt(resNum.getText()));
	  if(newRes != null){
		  
	  fName.setText(newRes.customer.getFirst_name());
	  lName.setText(newRes.customer.getLast_name());
	  phoneNum.setText(newRes.customer.getPhone_num());
	  adress.setText(newRes.customer.getAddress());
	  }else {
		  UpdateFrame.feedback.setText("Reservation not found please Try Again");
	}
	  
	}
	/*Updates all the relevant fields, changed and unchanged to prevent saving and comparing fields
	 * this way all updated fields will be changed as well as the unchanged fields, but it will
	 * be changing to the same value*/
	public void update() {
		newRes =reservationLogic.getReservation(Integer.parseInt(resNum.getText()));
		newRes.customer.setFirst_name(fName.getText());
		newRes.customer.setLast_name(lName.getText());
		newRes.customer.setPhone_num(phoneNum.getText());
		newRes.customer.setAddress(adress.getText());
		if(reservationLogic.updatReservation(newRes)) {
		UpdateFrame.feedback.setText(newRes.toString());
		}
	else {
		UpdateFrame.feedback.setText("Reservation not Updated please Try Again");
	}
	}
	
	//Create Reservation Button Pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String credit = new String(creditCard.getPassword()); //convert credit card into string

		//checks input validity
		if (inputValid(credit)) { 
    
			Room room = ReservationLogic.roomAvailable(roomtype.getSelectedItem().toString()); //check if room is available
		
			if (room != null) {
				newRes = new Reservation(fName.getText(), lName.getText(), 
						adress.getText(), phoneNum.getText(), credit);
				newRes.setArrival_date(date.format(startDate.getDate()));
				newRes.setDeparture_date(date.format(endDate.getDate()));
				newRes.setRoom(room);
				newRes.setRoomType(roomtype.getSelectedItem().toString());
				room.roomReserved();
				if(reservationLogic.addReservation(newRes)) {
				CreateReservationFrame.feedback.setText(newRes.toString()); 
				}else {
					CreateReservationFrame.feedback.setText("Reservation not Created Please ensure Phone number "
							+ "is not associated with another reservation");
				}
			}
			else {
				CreateReservationFrame.feedback.setText("Error: Selected room is not available.");
			}
		}
		
	}
	
	//Check if reservation input is valid
	public boolean inputValid(String credit) {
		String strStartDate = date.format(startDate.getDate());
		String strEndDate = date.format(endDate.getDate());
		String currentDate = date.format(new Date());
		boolean datesOK = true;
		boolean valid = true;
		
		//check arrival date is before departure date && arrival date is not before today's date.
		try {
			datesOK = (date.parse(strStartDate).before(date.parse(strEndDate)) && !(date.parse(strStartDate).before(date.parse(currentDate))));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (!datesOK) {
			CreateReservationFrame.feedback.setText("Error: Dates are invalid.");
			valid = false;
		}
		
		//Check phone number
		if (!phoneNum.getText().matches("^[0-9]{10}$")) { //Invalid if not 10 digit number
			CreateReservationFrame.feedback.setText("Error: Phone number is not valid");
			valid = false;
		}
		
		//Check credit card number
		if (!credit.matches("^[0-9]{16}$")) { //Invalid if not 16 digit number
			CreateReservationFrame.feedback.setText("Error: Credit card entry needs to be 16 digits");
			valid = false;
		}
		
		return valid;
	}
		
	
}
