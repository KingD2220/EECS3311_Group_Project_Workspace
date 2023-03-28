package domain_objects_Rooms;

public abstract class Room {
	// Attributes of a room 
	// This class presents an opportunity to utilize a design pattern
	
	String roomType; 
	double fixedRatePerNight;
	String roomNum;
	String roomStatus;
	String reservationStatus;
	String arrivalDate;
	String departureDate;
	
	// getter methods
	
	public String getRoomType() {
		return this.roomType;
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
	
	public String getRoomStatus() {
		return roomStatus;
	}
	
	public String getReservationStatus() {
		return reservationStatus;
	}
	
	public abstract int getRoomsAvailable();

	
	// setterMethods
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	
	@Override
	public String toString() {
		return "Room [roomType=" + roomType + ", fixedRatePerNight=" + fixedRatePerNight + ", roomNum=" + roomNum
				+ ", roomStatus=" + roomStatus + ", reservationStatus=" + reservationStatus + ", arrivalDate="
				+ arrivalDate + ", departureDate=" + departureDate + "]";
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
	
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	
	public abstract void roomReserved();
	
}