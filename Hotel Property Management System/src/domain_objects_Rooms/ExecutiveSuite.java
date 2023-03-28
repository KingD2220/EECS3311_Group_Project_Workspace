package domain_objects_Rooms;

public class ExecutiveSuite extends Room{
	static int numberOfRooms = 10;
	public ExecutiveSuite() {
		this.roomType = "Executive Suite";
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
