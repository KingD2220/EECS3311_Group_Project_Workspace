package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import business_logic.ReservationLogic;
import domain_objects.DeluxeRoom;
import domain_objects.ExecutiveSuite;
import domain_objects.PresidentialSuite;
import domain_objects.Reservation;
import domain_objects.Room;
import domain_objects.StandardRoom;
import domain_objects.SuiteRoom;

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
		
		Room room = roomAvailable(roomtype.getSelectedItem().toString()); //check if room is available
		
		if (room != null) {

			Reservation newRes = new Reservation(fName.getText(), lName.getText(), 
			adress.getText(), phoneNum.getText(), creditCard.getText());
			newRes.setArrival_date(date.format(startDate.getDate()));
			newRes.setDeparture_date(date.format(endDate.getDate()));
			newRes.setRoom(room);
			room.roomReserved();
			ReservationLogic.addReservation(newRes);
			System.out.println(newRes.getArrival_date());
			guiBuilder.feedback.setText(newRes.toString()); //*does not include room info
		}
		else {
			guiBuilder.feedback.setText("Error: Selected room is not available.");
		}
		
	}
	
	public static Room roomAvailable(String roomType) {
		
		Room room = null;
		switch(roomType) {
		case "Standard":
			StandardRoom standard = new StandardRoom();
			if (standard.getRoomsAvailable() != 0)
				room = standard;
			break;
		case "Deluxe":
			DeluxeRoom deluxe = new DeluxeRoom();
			if (deluxe.getRoomsAvailable() != 0) 
				room = deluxe;
			break;
		case "Suite":
			SuiteRoom suite = new SuiteRoom();
			if (suite.getRoomsAvailable() != 0) 
				room = suite;
			break;
		case "Executive":
			ExecutiveSuite executive = new ExecutiveSuite();
			if (executive.getRoomsAvailable() != 0) 
				room = executive;
			break;
		case "Presidential":
			PresidentialSuite presidential = new PresidentialSuite();
			if (presidential.getRoomsAvailable() != 0) 
				room = presidential;
			break;
		}
		
		return room;
	}

}
