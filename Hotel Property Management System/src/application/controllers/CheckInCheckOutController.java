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
import domain_objects_Rooms.Room;
import persistence.RealDatabase;

public class CheckInCheckOutController {
	ReservationLogic reservationLogic = new ReservationLogic(new RealDatabase());
	String dateToday = LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
	
	public CheckInCheckOutController() {
	}

	//JTable row builder 
	public Object[] buildRow(Reservation res) {
		Object[] rowArray;
		if (res != null) {
			rowArray = new Object[] {res.customer.getLast_name() + ", " + res.customer.getFirst_name(), 
					res.getArrival_date(), res.getDeparture_date(), res.getRoomType(), res.getRoomNum(), res.getResNumber()};
			return rowArray;
		} else {
			return null;
		}
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
				if (caller.equals("Departures") && res.getCheckedOut().equals("NO")) {
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
	public Object[] getResByRoomNum(String roomNum, String caller) {	
		ArrayList<Reservation> resList = reservationLogic.getReservationsByDate(dateToday, caller);
		Reservation targetRes = null;
		for (int i = 0; i < resList.size(); i++) {
			if (resList.get(i).getRoomNum().equals(roomNum)) {
				targetRes = resList.get(i);
				return buildRow(targetRes);
			}
		}
		return null;
	}
	
	//updates room status and reservation status on check-in and check-out
	public boolean updateResStatus(String resNum, String roomNum, String caller) {		
		return reservationLogic.updateReservationStatus(Integer.parseInt(resNum), roomNum, caller);
	}
	
	public Reservation getResInfo(String resNum) {
		return reservationLogic.getReservation(Integer.parseInt(resNum));
	}
	
	//display table helper method for adding rows
	public Object[] buildTaxRow(String date, double  price) {
		double tax = price * 0.13;
		return new Object[] {date, "HST", String.format("%.2f", tax)};
	}
	
	//populates reservation charges
	public double displayCharges(Reservation res) {
		DateFormat resDateFormat = new SimpleDateFormat("yy-MM-dd");
		DateFormat billDateFormat = new SimpleDateFormat("MM-dd");
		Date arrival = null;
		double total = 0;
		//turn String date into a Date object
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
		double roomRate = reservationLogic.getRoomPrice(res.getResNumber());
		
		for (int i = 0; i < numOfNights; i++) {
			String monthDay = billDateFormat.format(startDate.getTime());
			BillingFrame.model.addRow(new Object[] {monthDay, roomType + " Room", String.format("%.2f", roomRate)});
			BillingFrame.model.addRow(buildTaxRow(monthDay, roomRate));
			total += roomRate + roomRate*0.13;
			startDate.add(Calendar.DATE, 1);	//starDate++
		}
		
		return total;
	}
	
	public String getRoomRate(String resNum) {
		double r = reservationLogic.getRoomPrice(Integer.parseInt(resNum));
		return String.format("%.2f", r);
	}
	
	public boolean cancelReservation(String resNum) {
		return reservationLogic.removeReservation(Integer.parseInt(resNum));
	}
	
}
