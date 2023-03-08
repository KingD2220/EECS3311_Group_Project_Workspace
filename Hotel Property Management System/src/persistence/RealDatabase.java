package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain_objects_Rooms.*;

public class RealDatabase implements Database {
	private final String HOST = "127.0.0.1";
	private final String PORT ="3306"; 
	private final String PASSWORD = "Sean@1234";
	private final String USERNAME ="root";
	private final String DATABASE ="domain_objects";
	private final String HOST_URL = String.format("jdbc:mysql://%s:%s/%s?useSSL=false", HOST, PORT, DATABASE);	
	private Connection connection;
	
	/*Constructor opens a connection to the database so each method does not  have to */
	public RealDatabase() {
		super();
		getConnection();
	}


	public void getConnection() {
		if(connection != null) {
			return;
		}
		try {
			System.out.println("Opening connection");
            connection = DriverManager.getConnection(HOST_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
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
	public boolean getUser(String userName, byte[] passHash) {
		
		try  { 
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(String.format("SELECT userName FROM Account WHERE hashPassWord=%x AND userName = %s", passHash, userName ));
			while (rs.next()) {
				if (rs.getString("userName").equals(userName)) {
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
	public boolean addUser(String userName, byte[] passHash) {
	   
	    try {
			PreparedStatement prepared = connection.prepareStatement(String.format("INSERT INTO Account VALUES(%s, %x)", userName, passHash));
			int changedrows = prepared.executeUpdate();
			prepared.close();
			//this implementation eliminates an if statement
			return changedrows > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
	}
	}

	@Override
	public int numOfReservations() {
		// TODO Auto-generated method stub
		return 0;
	}
 
	@Override
	public Reservation getReservation(int resNum) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM RESERVATION WHERE resNum = ?");
			statement.setInt(1, resNum);
			ResultSet rs = statement.executeQuery();
			// though using rs.next() it is only expected to return one tuple as resNum is a primary key
			while (rs.next()) {
				Reservation reservation = new Reservation(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("address"), Integer.toString(rs.getInt("phone_num")), Integer.toString(rs.getInt("credit_card")));
				reservation.setArrival_date(rs.getString("arrival_date"));
				reservation.setDeparture_date(rs.getString("departure_date"));
				reservation.setResNumber(resNum);
				return reservation;
			}
			statement.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
	

	@Override
	public boolean addReservation(Reservation reservation) {
		// separated the query for readability
		String query = String.format("INSERT INTO RESERVATION (%s, %s, %s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?, ?, ?)","arrival_date",
				"departure_date","last_name","first_name","address","phone_num","credit_card");
		
	try {
		PreparedStatement prepared = connection.prepareStatement(query); 
		//added the values after for readability and testing
		prepared.setString(1, reservation.getArrival_date());    
		prepared.setString(2, reservation.getDeparture_date());
		prepared.setString(3, reservation.customer.getLast_name());
		prepared.setString(4, reservation.customer.getFirst_name());
		prepared.setString(5, reservation.customer.getAddress());
		prepared.setInt(6, Integer.parseInt(reservation.customer.getPhone_num()));
		prepared.setInt(7, Integer.parseInt(reservation.customer.getCredit_card()));
		int changedRows= prepared.executeUpdate();
		prepared.close();
		System.out.println("Success "+ changedRows);
		return changedRows > 0;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	
	
  public static void main(String[] args) {
		/*
		 * Reservation reso = new Reservation("Miguel" , "Graham","Home", "647","1234"
		 * ); reso.setArrival_date("112011"); reso.setDeparture_date("12345");
		 * RealDatabase database = new RealDatabase(); database.addReservation(reso);
		 */
	Reservation res; 
	RealDatabase database = new RealDatabase(); 
	res = database.getReservation(1); 
	System.out.println(res.toString());

}
}
