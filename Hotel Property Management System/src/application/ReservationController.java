package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import business_logic.ReservationLogic;
import domain_objects.Reservation;
import domain_objects.Room;

import java.text.SimpleDateFormat;

public class ReservationController implements ActionListener {

	private JTextField fName;
	private JTextField lName;
	private JTextField creditCard;
	private JTextField adress;
	private JTextField phoneNum;
	private JComboBox<Object> roomtype;
	private JDateChooser startDate;
	private JDateChooser endDate;
	ReservationLogic reservationLogic;
	
	//creates reservation and adds it to reservation list
	public static Reservation createReservation(String lastInput, String firstInput, String addressInput, String phoneInput, String creditCardInput, Room room, JDateChooser checkInChooser, JDateChooser checkOutChooser) {
			
		//create reservation
		Reservation newReservation = new Reservation(lastInput, firstInput, addressInput, phoneInput, creditCardInput);
			
		//set reservation dates
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd"); //date format
		newReservation.setArrival_date(ymd.format(checkInChooser.getDate()));
		newReservation.setDeparture_date(ymd.format(checkOutChooser.getDate()));
			
		//add reservation
		Reservation.getList().add(newReservation);
				
		return newReservation;
	}




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

	@Override
	public void actionPerformed(ActionEvent e) {

		Reservation newRes = new Reservation(fName.getText(), lName.getText(), 
		adress.getText(), phoneNum.getText(), creditCard.getText());
        reservationLogic.addReservation(newRes);
		
	}

}
