package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
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
    SimpleDateFormat date = new SimpleDateFormat("yy-MM-dd");
    


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
		newRes.setArrival_date(date.format(startDate.getDate()));
		newRes.setDeparture_date(date.format(endDate.getDate()));
        ReservationLogic.addReservation(newRes);
        System.out.println(newRes.getArrival_date());
        guiBuilder.feedback.setText(newRes.toString());
		
	}

}
