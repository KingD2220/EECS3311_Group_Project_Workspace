package domain_objects_Rooms;

public abstract class Room {
	// Attributes of a room 
	// This class presents an opportunity to utilize a design pattern
	
	String roomType; 
	String bedType; 
	int numberOfBeds;
	int occupancy;
	int roomSize;
	double fixedRatePerNight;
	String roomNum;
	String arrivalDate;
	String departureDate;
	
	// getter methods
	
	public String getRoomType() {
		return this.roomType;
	}
	
	public String getBedType() {
		return this.bedType;
	}
	
	public int getNumberOfBeds() {
		return this.numberOfBeds;
	}
	
	public int getOccupancy() {
		return this.occupancy;
	}
	
	public int getRoomSize() {
		return this.roomSize;
	}
	
	public double getRate() {
		return this.fixedRatePerNight;
	}
	
	public String getRoomNum() {
		return roomNum;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}
	
	public abstract int getRoomsAvailable();

	
	// setterMethods
	
	void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	void setBedType(String bedType) {
		this.bedType = bedType;
	}
	
	void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	
	void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}
	
	void setRoomSize(int size) {
		this.roomSize = size;
	}
	
	void setRate(double rate) {
		this.fixedRatePerNight = rate;
	}	
	
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	public abstract void roomReserved();
	
}