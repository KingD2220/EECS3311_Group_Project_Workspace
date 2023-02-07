package domain_objects;

public class ExecutiveSuite extends Room{
	static int numberOfRooms = 10;
	public ExecutiveSuite() {
		this.roomType = "Executive Suite";
		this.bedType = "King";
		this.numberOfBeds = 2; 
		this.occupancy = 4; 
		this.roomSize = 900;
		this.fixedRatePerNight = 500.00;
	}
	@Override
	public int getRoomsAvailable() {
		return ExecutiveSuite.numberOfRooms;
	}
	
	public void roomReserved() {
		numberOfRooms--;
	}

}
