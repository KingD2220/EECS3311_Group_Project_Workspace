package domain_objects;

public class SuiteRoom extends Room{
	static int numberOfRooms = 10;
	public SuiteRoom() {
		this.roomType = "Suite";
		this.bedType = "King";
		this.numberOfBeds = 1; 
		this.occupancy = 2; 
		this.roomSize = 600;
		this.fixedRatePerNight = 300.00;
	}
	@Override
	public int getRoomsAvailable() {
		return SuiteRoom.numberOfRooms;
	}
	
	public void roomReserved() {
		numberOfRooms--;
	}

}
