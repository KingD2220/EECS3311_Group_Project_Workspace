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
	
	public void addReservation(Reservation reso) {
		database.addReservation(reso);
		reso.setResNumber(database.getLastResNum()+1);
	}

	public void removeReservation(int resNum) {
		database.removeReservation(resNum);
	}
	
	public Reservation updatReservation(Reservation reservation){
		return reservation;
	}
	
   public Reservation getReservation(int resNum) {
	   return database.getReservation(resNum);
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
