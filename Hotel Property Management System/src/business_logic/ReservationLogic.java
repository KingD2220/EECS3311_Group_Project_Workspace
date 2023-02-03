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

}
