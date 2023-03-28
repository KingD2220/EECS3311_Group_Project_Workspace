package domain_objects_Rooms;

public class DeluxeRoom extends Room{
	static int numberOfRooms = 10;
	public DeluxeRoom() {
		this.roomType = "Deluxe";
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
