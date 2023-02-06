package business_logic;

import java.util.List;

import domain_objects.Reservation;
import persistence.DatabaseStubs;

public class ReservationLogic {
	
	public Reservation addReservation() {
		return null;
		
	}

	public void removeReservation(String resNum) {
		
	}
	
	public Reservation updatReservation(Reservation reservation){
		return reservation;
	
	}
	
	public List<Reservation> getAllReservations() {
		return DatabaseStubs.getReservations();
		
	}
	
	public Reservation changeResDates(Reservation reservation, String newArrivalDate, String newDepartDate) {
		reservation.arrival_date = newArrivalDate;
		reservation.departure_date = newDepartDate;
		return reservation;
	}

}
