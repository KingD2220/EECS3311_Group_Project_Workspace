package domain_objects_Rooms;

public class StandardRoom extends Room{
	static int numberOfRooms = 10;
	public StandardRoom() {
		this.roomType = "Standard";
		this.bedType = "Twin";
		this.numberOfBeds = 2; 
		this.occupancy = 2; 
		this.roomSize = 300;
		this.fixedRatePerNight = 100.00;
	}
	@Override
	public int getRoomsAvailable() {
		return StandardRoom.numberOfRooms;
	}
	
	public void roomReserved() {
		numberOfRooms--;
	}
}
