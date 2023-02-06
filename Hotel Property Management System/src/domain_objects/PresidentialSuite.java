package domain_objects;

public class PresidentialSuite extends Room{
	static int numberOfRooms = 10;
	public PresidentialSuite() {
		this.roomType = "Presedential Suite";
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
