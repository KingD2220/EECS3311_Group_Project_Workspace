package domain_objects;

public abstract class Room {
	// Attributes of a room 
	// This class presents an opportunity to utilize a design pattern
	
	String roomType; 
	String bedType; 
	int numberOfBeds;
	int occupancy;
	int roomSize;
	double fixedRatePerNight;
	int roomNumber;	// change made
	String roomStatus;	// change made
	
	// getter methods
	
	String getRoomType() {
		return this.roomType;
	}
	
	String bedType() {
		return this.bedType;
	}
	
	int getNumberOfBeds() {
		return this.numberOfBeds;
	}
	
	int getOccupancy() {
		return this.occupancy;
	}
	
	int getRoomSize() {
		return this.roomSize;
	}
	
	double getRate() {
		return this.fixedRatePerNight;
	}
	
	int getRoomNumber() {
		return this.roomNumber;
	}
	
	String getRoomStatus() {
		return this.roomStatus;
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
	
	void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
}
