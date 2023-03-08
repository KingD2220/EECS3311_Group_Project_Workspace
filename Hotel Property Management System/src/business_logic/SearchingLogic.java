package business_logic;

import java.util.List;

import domain_objects_Rooms.Reservation;
import persistence.DatabaseStubs;

public class SearchingLogic {
	public static List<Reservation> searchList = DatabaseStubs.getReservations();
	
	public static Reservation searchByResNum(int num) {
		for (Reservation reservation : searchList) {
			if (num == reservation.getResNumber()) {
				return reservation;
			}
		}
		return null;
	}

}
