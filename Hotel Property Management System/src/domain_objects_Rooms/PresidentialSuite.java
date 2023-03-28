package domain_objects_Rooms;

public class PresidentialSuite extends Room{
	static int numberOfRooms = 10;
	public PresidentialSuite() {
		this.roomType = "Presidential Suite";
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
