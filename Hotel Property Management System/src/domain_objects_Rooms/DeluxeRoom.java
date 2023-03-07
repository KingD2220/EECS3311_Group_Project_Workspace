package domain_objects_Rooms;

public class DeluxeRoom extends Room{
	static int numberOfRooms = 10;
	public DeluxeRoom() {
		this.roomType = "Deluxe";
		this.bedType = "Queen";
		this.numberOfBeds = 1; 
		this.occupancy = 2; 
		this.roomSize = 400;
		this.fixedRatePerNight = 200.00;
	}
	@Override
	public int getRoomsAvailable() {
		return DeluxeRoom.numberOfRooms;
	}
	
	public void roomReserved() {
		numberOfRooms--;
	}
}
