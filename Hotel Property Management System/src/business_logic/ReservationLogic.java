package business_logic;

import java.util.List;

import domain_objects.Reservation;
import persistence.DatabaseStubs;

public class ReservationLogic {
	
	
    private static int resNum = 0;
    
	private static List<Reservation> resList =DatabaseStubs.getReservations();
	
	public ReservationLogic() {
		resList = DatabaseStubs.getReservations();
	}
	
	public static void addReservation(Reservation reso) {
		reso.setResNumber(resNum);
		resList.add(reso);
		resNum++;
	}

	public void removeReservation(String resNum) {
		
	}
	
	public Reservation updatReservation(Reservation reservation){
		return reservation;
	
}
public List<Reservation> getAllReservations() {
	return resList;
	
}
public Reservation changeResDates(Reservation reservation, String newArrivalDate, String newDepartDate) {
	reservation.arrival_date = newArrivalDate;
	reservation.departure_date = newDepartDate;
	return reservation;
}

}
