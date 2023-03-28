package domain_objects_Rooms;

public class SuiteRoom extends Room{
	static int numberOfRooms = 10;
	public SuiteRoom() {
		this.roomType = "Suite";
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
