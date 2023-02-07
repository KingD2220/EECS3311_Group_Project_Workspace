package business_logic;

import java.util.List;

import domain_objects.Reservation;
import persistence.DatabaseStubs;

public class ReservationLogic {

	private List<Reservation> resList;
	
	public ReservationLogic() {
		resList = DatabaseStubs.getReservations();
	}
	
	public void addReservation(Reservation reso) {
		resList.add(reso);
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
