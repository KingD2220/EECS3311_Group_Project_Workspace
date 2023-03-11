package domain_objects_Rooms;

public class PresidentialSuite extends Room{
	static int numberOfRooms = 10;
	public PresidentialSuite() {
		this.roomType = "Presidential Suite";
		this.bedType = "King";
		this.numberOfBeds = 2; 
		this.occupancy = 4; 
		this.roomSize = 900;
		this.fixedRatePerNight = 1000.00;
	}
	@Override
	public int getRoomsAvailable() {
		return PresidentialSuite.numberOfRooms;
	}
	
	public void roomReserved() {
		numberOfRooms--;
	}

}
