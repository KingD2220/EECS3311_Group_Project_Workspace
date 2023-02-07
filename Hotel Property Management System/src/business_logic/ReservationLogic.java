package business_logic;

import java.util.List;

import domain_objects.Reservation;
import persistence.DatabaseStubs;

public class ReservationLogic {

	private static List<Reservation> resList =DatabaseStubs.getReservations();
	
	public ReservationLogic() {
		resList = DatabaseStubs.getReservations();
	}
	
	public static void addReservation(Reservation reso) {
		resList.add(reso);
	}

	public void removeReservation(String resNum) {
		
	}
	
	public Reservation updatReservation(Reservation reservation){
		return reservation;
	
}
public List<Reservation> getAllReservations() {
	return resList;
	
}

}
