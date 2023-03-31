package application.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import persistence.RealDatabase;

public class CheckInCheckOutController {
	ReservationLogic reservationLogic = new ReservationLogic(new RealDatabase());
	
	public CheckInCheckOutController() {
		
	}

	public Object[] getResByNum(String resNum, String type) {
		Reservation reservation = reservationLogic.getReservation(Integer.parseInt(resNum));
		Object[] rowArray = null;
		if (type.equals("Arrivals")) {
			rowArray = checkDatesMatch(reservation, reservation.getArrival_date());
		}	
		if (type.equals("Departures")) {
			rowArray = checkDatesMatch(reservation, reservation.getDeparture_date());
		}
		return rowArray;
	}
	
	public Object[] checkDatesMatch(Reservation res, String resDate) {
		String dateToday = LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
		if (resDate.equals(dateToday)) {
			Object[] rowSet = new Object[] {res.customer.getLast_name() + ", " + res.customer.getFirst_name(), 
					res.getArrival_date(), res.getDeparture_date(), res.getRoomType(), "", res.getResNumber()};
			return rowSet;
		}
		else {
			return null;
		}
	}
		
}
