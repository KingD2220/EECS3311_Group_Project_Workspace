package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import domain_objects_Rooms.*;
import domain_objects_Users.Employee;

public class RealDatabase implements Database {
	private static final String HOST = "127.0.0.1";
	private static final String PORT ="3306";
	private static final String PASSWORD = "Sean@1234";
	private static final String USERNAME ="root";
	private static final String DATABASE ="domain_objects";
	private static final String HOST_URL = String.format("jdbc:mysql://%s:%s/%s?useSSL=false", HOST, PORT, DATABASE);	
	private Connection connection;
	
	/*Constructor opens a connection to the database so each method does not  have to */
	public RealDatabase() {
		super();
		getConnection();
	}
	


	public boolean getConnection() {
		if(connection != null) {
			return false;
		}
		try {
            connection = DriverManager.getConnection(HOST_URL, USERNAME, PASSWORD);
            return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
			return false;
		}
	}
	
	/*This method gives the ability to close the connection to the database if needed*/
	public void closeConnection() {
		  try {
	            System.out.println("Closing connection");
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	/*This method returns the last reservation number in the database*/
	@Override
	public int getLastResNum() {
		int resNum = 0; 
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MAX(resNum)as MAXRES FROM RESERVATION");
			while (rs.next()) {
				resNum = rs.getInt("MAXRES");
			}
			statement.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			resNum = 0; 
		}
		return resNum;
	}
   /*This method gets a user and returns true is the user exists for authentication purposes */
	@Override
	public boolean getUser(String userName, String passHash, String jobType) {
		
		try  { 
			PreparedStatement statement = connection.prepareStatement(String.format("SELECT * FROM Account WHERE hashPassWord= ? AND userName = ?"));
			statement.setString(1, passHash);
		    statement.setString(2, userName);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getString("userName").equals(userName) && rs.getString("jobType").equals(jobType)) {
					return true;
				}
			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
/*Adds user to the Account table in the database to allow registration*/
	@Override
	public boolean addUser(String userName, String passHash, String jobType) {
		int changedrows=0;
	    try {
			PreparedStatement prepared = connection.prepareStatement(String.format("INSERT INTO Account VALUES(?, ?, ?)"));
			prepared.setString(1, userName);
			prepared.setString(2, passHash);
			prepared.setString(3, jobType);
			changedrows = prepared.executeUpdate();
			prepared.close();
			
			return retunedRows(changedrows);
		} catch (Exception e) {
			e.printStackTrace();
			return retunedRows(changedrows);
	}
	}

 /*Returns the matching reservation for the reservation number, returns null otherwise*/
	@Override
	public Reservation getReservation(int resNum) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM RESERVATION WHERE resNum = ?");
			statement.setInt(1, resNum);
			ResultSet rs = statement.executeQuery();
			// though using rs.next() it is only expected to return one tuple as resNum is a primary key
			while (rs.next()) {
				Reservation reservation = new Reservation(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("address"), rs.getString("phone_num"), rs.getString("credit_card"));
				reservation.setArrival_date(rs.getString("arrival_date"));
				reservation.setDeparture_date(rs.getString("departure_date"));
				reservation.setRoomType(rs.getString("roomType"));
				reservation.setResNumber(resNum);
				return reservation;
			}
			statement.close();
			rs.close();
		} catch (Exception e) {
			
			return null;
		}
		return null;
		
	}
	
/*Adds a reservation to the database, uses a helper method to reduce duplicated code also updates the customer table 
 * as they work together*/
	@Override
	public boolean addReservation(Reservation reservation) {
		String caller = "ADD";
		boolean queryPerfomed = false;
		String query = String.format("INSERT INTO RESERVATION (%s, %s, %s, %s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?, ?, ?, ?)","arrival_date",
				"departure_date","last_name","first_name","address","phone_num","credit_card", "roomType");
	 	queryPerfomed  = reserVationHelper(reservation, query, caller);//Helper method
	 	if (queryPerfomed) {
	 		//Inserts relevant info into the customer table
	 		addCustomer(reservation);
	 		return queryPerfomed;
		}
	 	else {
			return false;
		}
	}
	/*updates a reservation and adds any changes to the database uses a helper method for readability and 
	 * reduction of duplicate code*/
	@Override
	public boolean updateReservation(Reservation changed) {
		String caller = "UPDATE";
		boolean queryPerformed = false; 
		String query = String.format("UPDATE RESERVATION SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE resNum = ?","arrival_date",
				"departure_date","last_name","first_name","address","phone_num","credit_card");
		queryPerformed = reserVationHelper(changed, query, caller);
		updateCustomer(changed);
		return queryPerformed;
	}
	
	/*Helper method to insert the information into the Customer table
	 * the reservation is passed to avoid creating a a new reservation instance*/
	public void addCustomer(Reservation reservation) {
		String query = String.format("INSERT INTO CUSTOMER (%s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?)",
				"last_name","first_name","address","phone_num","credit_card");
		customerHelper(reservation, query, "");
	
	}
	
	
	public void updateCustomer(Reservation changedReservation) {
		String caller= "UPDATE_CUSTOMER";
		String query = String.format("UPDATE CUSTOMER SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE phone_num = ?",
				"last_name","first_name","address","phone_num","credit_card");
		customerHelper(changedReservation, query, caller);
	}
	/*With a giver reservation number any reservation matching that number gets deleted*/
	@Override
	public boolean removeReservation(int resNum) {
		String query = String.format("DELETE FROM RESERVATION WHERE resNum = ?");
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, resNum);
			return statement.executeUpdate() > 0 ;
			
		} catch (Exception e) {
		return false;
	}
		
		}
	
	/*This is a helper method that helps to determine how many rows were changed, returns
	 * true if one or more lines were changed*/
	public boolean retunedRows(int changedRows) {
		if(changedRows > 0) {
			return true;
		}else {
			return false;
		}
	}
	
/*this is a helper method that extracts duplicate code from the customer methods
 * and does the heavy lifting after receiving a query*/
	public void customerHelper(Reservation reservation, String query, String caller ) {
		try {
			PreparedStatement prepared = connection.prepareStatement(query); 
			//added the values after for readability and testing
			prepared.setString(1, reservation.customer.getLast_name());
			prepared.setString(2, reservation.customer.getFirst_name());
			prepared.setString(3, reservation.customer.getAddress());
			prepared.setString(4, reservation.customer.getPhone_num());
			prepared.setString(5, reservation.customer.getCredit_card());
			if (caller.equals("UPDATE_CUSTOMER")) {//if it is the update customer method that calls
				prepared.setString(6, reservation.customer.getPhone_num());	
			}
			int changedRows= prepared.executeUpdate();
			prepared.close();
			System.out.println("Success "+ changedRows);
		} catch (Exception e) {
		  System.out.println("ERROR");
		}
	}
	/*Helper method that gets the query and does the actual execution*/
	public boolean reserVationHelper(Reservation reservation, String query, String caller){
	
		int changedRows= 0;
	try {
		PreparedStatement prepared = connection.prepareStatement(query); 
		//added the values after for readability and testing
		prepared.setString(1, reservation.getArrival_date());    
		prepared.setString(2, reservation.getDeparture_date());
		prepared.setString(3, reservation.customer.getLast_name());
		prepared.setString(4, reservation.customer.getFirst_name());
		prepared.setString(5, reservation.customer.getAddress());
		prepared.setString(6, reservation.customer.getPhone_num());
		prepared.setString(7, reservation.customer.getCredit_card());
		prepared.setString(8, reservation.getRoomType());
		if (caller.equalsIgnoreCase("UPDATE")) {//if it is the update method that calls
		prepared.setInt(8, reservation.getResNumber());
		}
		changedRows= prepared.executeUpdate();
		prepared.close();
		System.out.println("Success "+ changedRows);
	    return retunedRows(changedRows);
	} catch (Exception e) {
		return retunedRows(changedRows);
	}
}


//This return an Arraylist of rooms between two given room numbers
	@Override
	public ArrayList<Room> getRoomStatus(String roomNumStart, String roomNumEnd) {
		ArrayList<Room> roomList = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(String.format("SELECT * FROM ROOM WHERE roomNumber BETWEEN ? AND ?"));
			statement.setString(1, roomNumStart);
			statement.setString(2, roomNumEnd);
			ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			if(rs.getString("roomType").equals("Standard")) {
				Room newRoom = new StandardRoom();
				roomList.add(roomHelper(rs,newRoom));
			}else if (rs.getString("roomType").equals("Deluxe")) {
				Room newRoom = new DeluxeRoom();
				roomList.add(roomHelper(rs,newRoom));
			}else if (rs.getString("roomType").equals("Suite")) {
				Room newRoom = new SuiteRoom();
				roomList.add(roomHelper(rs,newRoom));
			}else if (rs.getString("roomType").equals("Executive")) {
				Room newRoom = new ExecutiveSuite();
				roomList.add(roomHelper(rs,newRoom));
			}else if (rs.getString("roomType").equals("Presidential")) {
				Room newRoom = new PresidentialSuite();
				roomList.add(roomHelper(rs,newRoom));
			}
		}
		   return roomList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	// helps assign data to each room type
	public Room roomHelper(ResultSet rs, Room room) {
		try {
		room.setRoomNum(rs.getString("roomNumber"));
		room.setArrivalDate(rs.getString("start_date"));
		room.setArrivalDate(rs.getString("end_date"));
		room.setRoomStatus(rs.getString("roomSatus"));
	    room.setRoomType(rs.getString("roomType"));
	    room.setReservationStatus(rs.getString("reservationStatus"));
	    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room;
	}



	@Override
	public Employee getEmployee(String employeeNum) {
		Employee newEmployee = new Employee();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE employeeNum = ?");
			statement.setString(1, employeeNum);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				newEmployee.setFirst_name(rs.getString(""));
				newEmployee.setLast_name(rs.getString(""));
				newEmployee.setWeeklyWage(rs.getString(""));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public static void main(String[] args) {
		ArrayList<Room> roomtest = new ArrayList();
		RealDatabase db = new RealDatabase();
		
		roomtest = db.getRoomStatus("100", "209");
		
		for (Room room : roomtest) {
			System.out.println(room.toString());
		}
	}
	

}

  
