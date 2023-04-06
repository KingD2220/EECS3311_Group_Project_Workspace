package persistence;

import java.util.ArrayList;
import java.util.List;

import domain_objects.Account;
import domain_objects_Rooms.DeluxeRoom;
import domain_objects_Rooms.ExecutiveSuite;
import domain_objects_Rooms.PresidentialSuite;
import domain_objects_Rooms.Reservation;
import domain_objects_Rooms.Room;
import domain_objects_Rooms.StandardRoom;
import domain_objects_Rooms.SuiteRoom;
import domain_objects_Users.Customer;
import domain_objects_Users.Employee;
import domain_objects_Users.Profile;

public class DatabaseStubs implements Database {
	private static List<Customer> customers = new ArrayList<>();
	private static List<Reservation> reservations = new ArrayList<>();
	private static List<Employee> employee = new ArrayList<>();
	private static List<Room> rooms = new ArrayList<>();
	private static List<Account> accounts = new ArrayList<>(); 

	
	
    public DatabaseStubs() {
    	if (rooms.isEmpty()) {
		populateRooms();
    	}
	}
	
	public void populateRooms() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 0; j < 10; j++) {
				Room room = getRoomType(j);
				room.setRoomNum(""+i+""+0+""+j);
				rooms.add(room);
			}
		}
	}
	
	public Room getRoomType(int i) {
		if(i < 2) {
			return new StandardRoom();
		}else if (i > 1 && i < 4) {
			return new DeluxeRoom();
		}else if (i > 3 && i < 6) {
			return new SuiteRoom();
		}else if (i > 5 && i < 8) {
			return new ExecutiveSuite();
		}else if (i >7 && i < 10) {
			return new PresidentialSuite();
		}
		return null;
	}
	
	@Override
	public boolean getUser(String userName, String passHash, String jobType) {
		for (Account account : accounts) {
			if (userName.equals(account.getUserName())&& passHash.equals(account.getPassword())) {
				return true;
			}
		}
		return false;
		
		
	}
	@Override
	public boolean addUser(String userName, String passHash, String jobType) {
		Account account = null;
		try {
			account = new Account(userName, passHash, jobType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accounts.add(account);
		
		
		
	}
	@Override
	public Reservation getReservation(int resNum) {
		for (Reservation reservation : reservations) {
			if (reservation.getResNumber() == resNum) {
				return reservation;
			}
		}
		return null;
	}
	
	
	
	@Override
	public boolean addReservation(Reservation reservation) {
		return reservations.add(reservation);
		
	}
	@Override
	public boolean removeReservation(int resNum) {
		for (Reservation reservation : reservations) {
			if(reservation.getResNumber()== resNum) {
			return reservations.remove(reservation);
		}
		}
		return false;
	}
	
	
	@Override
	public int getLastResNum() {
		int lastResNum = 0;
		if (!reservations.isEmpty()) {
			return lastResNum;
		  }
		for (Reservation reservation : reservations) {
			lastResNum = reservation.getResNumber();
		}
		return lastResNum;
	}
	
	
	@Override
	public boolean updateReservation(Reservation changedReservation) {
		for (Reservation reservation : reservations) {
			if (changedReservation.getResNumber() == reservation.getResNumber()) {
				reservation = changedReservation;
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public ArrayList<Room> getRoomStatus(String roomNumStart, String roomNumEnd) {
		int start = Integer.parseInt(roomNumStart);
		int end = Integer.parseInt(roomNumEnd);
		ArrayList<Room> roomList = new ArrayList<>();
		for (Room room : rooms) {
			if (Integer.parseInt(room.getRoomNum())>= start &&
					Integer.parseInt(room.getRoomNum())<= end ) {
				roomList.add(room);
			}
		}
		return roomList;
	}
	
	
	@Override
	public Employee getEmployee(int employeeNum) {
		for (Employee empl : employee) {
			if ((empl.getEmployeeID().equals(employeeNum+""))) {
				return empl;
			}
		}
		return null;
	}
	
	
	@Override
	public void updateRoomStatus(String roomNum, String roomStatus) {
		for (Room room : rooms) {
			if(room.getRoomNum().equals(roomNum)) {
				room.setRoomStatus(roomStatus.toUpperCase());
			}
		}
	}
	
	
	@Override
	public ArrayList<Reservation> getResByDate(String date, String caller) {
		ArrayList<Reservation> reList = new ArrayList<>();
		for (Reservation reservation : reservations) {
			if(caller.equals("Arrivals")&& date.equals(reservation.getArrival_date())) {
				reList.add(reservation);
			}else if(date.equals(reservation.getDeparture_date())) {
				reList.add(reservation);
			}
		}
		return reList;
	}

	@Override
	public boolean updateResStatus(int resNum, String roomNum, String caller) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int addEmployee(Employee emp) {
		 employee.add(emp);
		 emp.setEmployeeID(employee.size()+"");
		 return employee.size();
	}
	
	public boolean addRoom(Room room) {
		return rooms.add(room);
	}

	@Override
	public ArrayList<Reservation> inHouseReservation() {
		// TODO Auto-generated method stub
		return null;
	}
}

