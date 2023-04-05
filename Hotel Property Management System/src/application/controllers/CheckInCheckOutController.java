package application.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	//fetches a reservation based on a reservation number displays it on frame
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
				if (caller.equals("Departures") /*&& res.getCheckedOut().equals("NO")*/) {
					CheckInCheckOutFrame.model.addRow(buildRow(res));
				}
			}
			return true;
		}	
		else  {
			return false;
		}
	}	
	
	//fetches a reservation based on the room number used for checking out reservation
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
	
	public Object[] buildRow4Billing(String date, String item, String  price) {
		return new Object[] {date, item, price};
	}
	
	public void displayCharges(Reservation res) {
		DateFormat resDateFormat = new SimpleDateFormat("yy-MM-dd");
		DateFormat billDateFormat = new SimpleDateFormat("MM-dd");
		Date arrival = null;
		//turn String date back into a Date object
		try {	
			arrival = resDateFormat.parse(res.getArrival_date());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//convert Date to Calendar for iteration
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(arrival);
		
		long numOfNights = reservationLogic.daysBetween(res);
		String roomType = res.getRoomType();
//		String roomRate = Double.toString(res.getRoom().getRate());
		
		for (int i = 0; i < numOfNights; i++){
			String monthDay = billDateFormat.format(startDate.getTime());
			BillingFrame.model.addRow(buildRow4Billing(monthDay, roomType, "200.00"));
			
			startDate.add(Calendar.DATE, 1);
		}

	}

	public static void main(String[] args) {
		CheckInCheckOutController ctrl = new CheckInCheckOutController();
		ctrl.displayCharges(ctrl.getResInfo("7"));
	}
}
