package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import business_logic.ReservationLogic;
import business_logic.SearchingLogic;
import domain_objects.Reservation;
import domain_objects.Room;

/**
 * ReservationController should only be used to take information from front-end and
 * be the middleman for the model/database;
 * should not be changing what the GUI does or looks like.
 */

public class ReservationController implements ActionListener {
	private JTextField fName;
	private JTextField lName;
	private JTextField creditCard;
	private JTextField adress;
	private JTextField phoneNum;
	private JComboBox<Object> roomtype;
	private JDateChooser startDate;
	private JDateChooser endDate;
    SimpleDateFormat date = new SimpleDateFormat("yy-MM-dd");
    private JTextField resNum; 
    Reservation newRes;

	public ReservationController(JTextField fName, JTextField lName, JTextField creditCard, JTextField adress,
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
	  newRes =SearchingLogic.searchByResNum(Integer.parseInt(resNum.getText()));
	  fName.setText(newRes.customer.getFirst_name());
	  lName.setText(newRes.customer.getLast_name());
	  phoneNum.setText(newRes.customer.getPhone_num());
	  adress.setText(newRes.customer.getAddress());
	  
	  
	}
	public void update() {
		newRes =SearchingLogic.searchByResNum(Integer.parseInt(resNum.getText()));
		newRes.customer.setFirst_name(fName.getText());
		newRes.customer.setLast_name(lName.getText());
		newRes.customer.setPhone_num(phoneNum.getText());
		newRes.customer.setAddress(adress.getText());
		UpdateFrame.feedback.setText(newRes.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Room room = ReservationLogic.roomAvailable(roomtype.getSelectedItem().toString()); //check if room is available
		
		if (room != null) {

			newRes = new Reservation(fName.getText(), lName.getText(), 
			adress.getText(), phoneNum.getText(), creditCard.getText());
			newRes.setArrival_date(date.format(startDate.getDate()));
			newRes.setDeparture_date(date.format(endDate.getDate()));
			newRes.setRoom(room);
			room.roomReserved();
			ReservationLogic.addReservation(newRes);
			CreateReservationFrame.feedback.setText(newRes.toString()); //*does not include room info
		}
		else {
			CreateReservationFrame.feedback.setText("Error: Selected room is not available.");
		}
		
	}
		
	
}
