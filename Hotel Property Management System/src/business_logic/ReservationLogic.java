package business_logic;

import domain_objects_Rooms.DeluxeRoom;
import domain_objects_Rooms.ExecutiveSuite;
import domain_objects_Rooms.PresidentialSuite;
import domain_objects_Rooms.Reservation;
import domain_objects_Rooms.Room;
import domain_objects_Rooms.StandardRoom;
import domain_objects_Rooms.SuiteRoom;
import persistence.Database;

public class ReservationLogic {
	
	
    private static int resNum = 0;
    
	private final Database database;
	
	public ReservationLogic(Database database) {
		this.database = database;
	}
	/*This adds a reservation into the database this acts as a middleman
	 * and removes the need for other classes to add reservations to the database directly*/
	public boolean addReservation(Reservation reso) {
		if(database.addReservation(reso)) {
		reso.setResNumber(database.getLastResNum());
		return true;
		}else return false;
	}

	/*This method removes a reservation of given reservation number and returns 
	 * true if the reservation is removed*/
	public boolean removeReservation(int resNum) {
		return database.removeReservation(resNum);
	}
	
	public boolean updatReservation(Reservation reservation){
		return database.updateReservation(reservation);
	}
	
   public Reservation getReservation(int resNum) {
	   return database.getReservation(resNum);
}
   public boolean getUser(String userName, String password, String jobType) {
	return database.getUser(userName, password, jobType);
}
	
	public Reservation changeResDates(Reservation reservation, String newArrivalDate, String newDepartDate) {
		reservation.arrival_date = newArrivalDate;
		reservation.departure_date = newDepartDate;
		return reservation;
	}
	
	public static Room roomAvailable(String roomType) {
		Room room = null;
		switch(roomType) {
		case "Standard":
			StandardRoom standard = new StandardRoom();
			if (standard.getRoomsAvailable() > 0)
				room = standard;
			break;
		case "Deluxe":
			DeluxeRoom deluxe = new DeluxeRoom();
			if (deluxe.getRoomsAvailable() > 0) 
				room = deluxe;
			break;
		case "Suite":
			SuiteRoom suite = new SuiteRoom();
			if (suite.getRoomsAvailable() > 0) 
				room = suite;
			break;
		case "Executive":
			ExecutiveSuite executive = new ExecutiveSuite();
			if (executive.getRoomsAvailable() > 0) 
				room = executive;
			break;
		case "Presidential":
			PresidentialSuite presidential = new PresidentialSuite();
			if (presidential.getRoomsAvailable() > 0) 
				room = presidential;
			break;
		}
		return room;
	}

}
