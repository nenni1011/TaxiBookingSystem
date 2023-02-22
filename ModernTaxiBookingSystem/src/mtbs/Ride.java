package mtbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ride {
	/*
	 1) getAllRidesWithUserId(Driver)
	 2) getAllRidesWithUserId(Rider)
	 3) getAllExpenses/EarningsWithUserId (Driver)
	 4) getAllExpenses/EarningsWithUserId (Rider)
	 5) registerTheRide
	 */
	
	/*
	 1) driverId
	 2) riderId
	 3) fromLocationX
	 4) fromLocationY
	 5) toLocationX
	 6) toLocationY
	 7) totalCost
	  */
	
	/*
	 1) Ride
	  
	   */
	private int ride_id;
	private int driverId;
	private int riderId;
	private int fromLocationX;
	private int fromLocationY;
	private int toLocationX;
	private int toLocationY;
	private int vehicle_id;
	private int totalCost;
	
	public Ride() {
	
	}
	
	public Ride(int ride_id , int driverId , int riderId , int fromLocationX , int fromLocationY , int toLocationX , int toLocationY , int vehicle_id , int totalCost) {
		this.ride_id = ride_id;
		this.driverId = driverId;
		this.riderId = riderId;
		this.fromLocationX = fromLocationX;
		this.fromLocationY = fromLocationY;
		this.toLocationX = toLocationX;
		this.toLocationY = toLocationY;
		this.vehicle_id = vehicle_id;
		this.totalCost = totalCost;
	}
	
	
	public  void registerRide(int driverId , int riderId , int fromLocationX , int fromLocationY , int toLocationX , int toLocationY ,int vehicleId ,  int totalCost)throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Insert into Ride (driver_id , rider_id , fromLocationX , fromLocationY , toLocationX , toLocationY , vehicle_id , amount)"
				+ " values (" + driverId + "," + riderId + "," + fromLocationX + "," + fromLocationY + "," + toLocationX + "," + toLocationY + "," + 
				vehicleId + "," + totalCost + ");";
		st.execute(query);
		con.close();
		
	}
	
	public ArrayList <Ride> getRidesOfRider(int userId) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		ArrayList <Ride> res = new ArrayList <> ();
		Statement st = con.createStatement();
		String query = "Select * from Ride where rider_id = " + userId + ";";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			res.add(new Ride(rs.getInt(1) , rs.getInt(2) , rs.getInt(3) , rs.getInt(4) , rs.getInt(5) , rs.getInt(6) , rs.getInt(7) , rs.getInt(8) , rs.getInt(9)));
		}
		con.close();
		return res;
	}
	
	public ArrayList <Ride> getRidesOfDriver(int userId) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		ArrayList <Ride> res = new ArrayList <> ();
		Statement st = con.createStatement();
		String query = "Select * from Ride where driver_id = " + userId + ";";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			res.add(new Ride(rs.getInt(1) , rs.getInt(2) , rs.getInt(3) , rs.getInt(4) , rs.getInt(5) , rs.getInt(6) , rs.getInt(7) , rs.getInt(8) , rs.getInt(9)));
		}
		con.close();
		return res;
	}
	
	public int totalEarningsOfDriver(int userId) throws SQLException{
		int totalEarnings = 0;
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select SUM(amount) from ride where driver_id = " + userId + ";";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			totalEarnings = rs.getInt(1);
			break;
		}
		return totalEarnings;
	}
	
	public  int totalExpensesOfRider(int userId) throws SQLException{
		int totalExpenses = 0;
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select SUM(amount) from ride where rider_id = " + userId + ";";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			totalExpenses = rs.getInt(1);
			break;
		}
		return totalExpenses;
	}


	public int getRide_id() {
		return ride_id;
	}


	public void setRide_id(int ride_id) {
		this.ride_id = ride_id;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public int getRiderId() {
		return riderId;
	}


	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}


	public int getFromLocationX() {
		return fromLocationX;
	}


	public void setFromLocationX(int fromLocationX) {
		this.fromLocationX = fromLocationX;
	}


	public int getFromLocationY() {
		return fromLocationY;
	}


	public void setFromLocationY(int fromLocationY) {
		this.fromLocationY = fromLocationY;
	}


	public int getToLocationX() {
		return toLocationX;
	}


	public void setToLocationX(int toLocationX) {
		this.toLocationX = toLocationX;
	}


	public int getToLocationY() {
		return toLocationY;
	}


	public void setToLocationY(int toLocationY) {
		this.toLocationY = toLocationY;
	}


	public int getVehicle_id() {
		return vehicle_id;
	}


	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}


	public int getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	
	
	
	
}
