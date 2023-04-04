package application.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import application.frames.BillingFrame;
import application.frames.CheckInCheckOutFrame;
import business_logic.ReservationLogic;
import domain_objects_Rooms.Reservation;
import persistence.RealDatabase;

public class CheckInCheckOutController {
	ReservationLogic reservationLogic = new ReservationLogic(new RealDatabase());
	
	public CheckInCheckOutController() {
		
	}

	public Object[] getResByNum(String resNum) {
		Reservation res = reservationLogic.getReservation(Integer.parseInt(resNum));
		String dateToday = LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
		if (res != null && res.getArrival_date().equals(dateToday)) {
			return buildRow(res);
		}
		else {
			return null;
		}
	}
		
	//JTable row builder 
	public Object[] buildRow(Reservation res) {
		return new Object[] {res.customer.getLast_name() + ", " + res.customer.getFirst_name(), 
				res.getArrival_date(), res.getDeparture_date(), res.getRoomType(), /*****res.getRoom().getRoomNum()*****/ "", res.getResNumber()};
	}
	
	//get all reservations by date based on selection = {arrival, departure} and filter out any res that were already checked-in.
	public boolean getResByDate(String dateToday, String type) {
		ArrayList<Reservation> resList = reservationLogic.getReservationsByDate(dateToday, type);
		if (resList.size() != 0) {
			for (Reservation res : resList) {
//----NEED TO WAIT FOR DB CHECK-IN IMPLEMENTATION TO BE COMPLETE----//	if (res.getRoom().getReservationStatus().equals("AVAILABLE")) {
					CheckInCheckOutFrame.model.addRow(buildRow(res)); 
//				}	
			}	
			return true;
		}	
		else {
			return false;
		}
	}	
	
	public boolean checkInReservation(String resNum, String roomNum) {		
		return true; //reservationLogic.updateResStatus(Integer.parseInt(resNum), roomNum);
	}
	
	public Reservation getResInfo(String resNum) {
		return reservationLogic.getReservation(Integer.parseInt(resNum));
	}
		
}
