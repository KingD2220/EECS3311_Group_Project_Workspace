package application;

import domain_objects.Room;
import domain_objects.StandardRoom;
import domain_objects.DeluxeRoom;
import domain_objects.SuiteRoom;
import domain_objects.ExecutiveSuite;
import domain_objects.PresidentialSuite;

public class RoomController {
	//returns room if available and null if not available
		public static Room roomAvailable(String roomType) {
			
			Room room = null;
			
			switch(roomType) {
			case "Standard":
				StandardRoom standard = new StandardRoom();
				if (standard.getRoomsAvailable() != 0)
					room = standard;
				break;
			case "Deluxe":
				DeluxeRoom deluxe = new DeluxeRoom();
				if (deluxe.getRoomsAvailable() != 0) 
					room = deluxe;
				break;
			case "Suite":
				SuiteRoom suite = new SuiteRoom();
				if (suite.getRoomsAvailable() != 0) 
					room = suite;
				break;
			case "Executive":
				ExecutiveSuite executive = new ExecutiveSuite();
				if (executive.getRoomsAvailable() != 0) 
					room = executive;
				break;
			case "Presidential":
				PresidentialSuite presidential = new PresidentialSuite();
				if (presidential.getRoomsAvailable() != 0) 
					room = presidential;
				break;
			}
			
			return room;
		}
}

