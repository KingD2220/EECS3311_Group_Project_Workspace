package application.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import application.frames.BillingFrame;
import application.frames.CheckInCheckOutFrame;
import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import persistence.RealDatabase;

public class CheckInCheckOutController {
	ReservationLogic reservationLogic = new ReservationLogic(new RealDatabase());
	String dateToday = LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
	
	public CheckInCheckOutController() {
	}

	//JTable row builder 
	public Object[] buildRow(Reservation res) {
		return new Object[] {res.customer.getLast_name() + ", " + res.customer.getFirst_name(), 
				res.getArrival_date(), res.getDeparture_date(), res.getRoomType(), res.getRoomNum(), res.getResNumber()};
	}
	
	public Object[] getResByResNum(String resNum) {
		Reservation res = reservationLogic.getReservation(Integer.parseInt(resNum));
		if (res != null && res.getArrival_date().equals(dateToday)) {
			return buildRow(res);
		}
		else {
			return null;
		}
	}
			
	//get all reservations by date based on selection = {arrival, departure}
	public boolean getResByDate(String caller) {
		ArrayList<Reservation> resList = reservationLogic.getReservationsByDate(dateToday, caller);
		if (resList != null && resList.size() != 0) {
			for (Reservation res : resList) {	
				if (caller.equals("Arrivals") && res.getRoomNum() == null) {
					CheckInCheckOutFrame.model.addRow(buildRow(res)); 
				}	
				if (caller.equals("Departures") && res.getRoomNum() != null) {
					CheckInCheckOutFrame.model.addRow(buildRow(res));
				}
			}
			return true;
		}	
		else  {
			return false;
		}
	}	
	
	public Object[] getResByRoomNum(String roomNum) {	//---------NEEDS TO BE IMPLEMENTED-----MAYBE USE getResByDate()
		Reservation res = reservationLogic.getResByRoomNum(roomNum);
		if (res != null && res.getDeparture_date().equals(dateToday)) {
			return buildRow(res);
		}
		else {
			return null;
		}	
	}
	
	public boolean updateResStatus(String resNum, String roomNum, String caller) {		
		return reservationLogic.updateReservationStatus(Integer.parseInt(resNum), roomNum, caller);
	}
	
	public Reservation getResInfo(String resNum) {
		return reservationLogic.getReservation(Integer.parseInt(resNum));
	}
	
	public void displayCharges(Reservation res) {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		long numOfNights = reservationLogic.daysBetween(res);
		String arrivalDate = res.getArrival_date();
		Date startDate = null;
		try {
			startDate = dateFormat.parse(arrivalDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
		
	}

}
