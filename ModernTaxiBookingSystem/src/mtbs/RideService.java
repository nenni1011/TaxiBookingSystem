package mtbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class RideService {
	
	Scanner sc = new Scanner(System.in);
	
	private int maxDistance = 4;

	public void bookRide(String riderEmail , int fromLocationX , int fromLocationY , int toLocationX , int toLocationY , String preferredVehicleType) throws SQLException{
		ArrayList <Driver> allDrivers = getAllDrivers();
		String vehicleNumber = "";
		ArrayList <Driver> eligible = new ArrayList <> ();
		for(Driver driver : allDrivers) {
			Vehicle v = new Vehicle();
			Vehicle currDriverVehicle = v.getTheVehicleObject(driver.getDriver_id());
			if(currDriverVehicle.getVehicleType().equals(preferredVehicleType) && distance(fromLocationX,fromLocationY,driver.getLocationX(),driver.getLocationY()) <= maxDistance) {
				eligible.add(driver);
				vehicleNumber = currDriverVehicle.getVehicleNo();
				break;
			}
		}
		
		if(eligible.size() == 0) {
			System.out.println("No drivers found nearby you .. try again afetr some time !!");
			return ;
		}
		
		Driver selectedDriver = eligible.get(0);
		Rider rider = new Rider();
		Driver driver = new Driver();
		
		int riderId = rider.getRiderId(riderEmail);
		int driverId = selectedDriver.getDriver_id();
		String driverEmail = selectedDriver.getEmail();
		
		
		Ride ride = new Ride();
		int distance = distance(fromLocationX , fromLocationY , toLocationX , toLocationY);
		int totalCost = calculateAmount(distance);
		
		
		
		
		registerTheRide(driverId, riderId, fromLocationX, fromLocationY, toLocationX, toLocationY, selectedDriver.getVehicle_id(), totalCost);
		
		System.out.println("Thus the driver " + selectedDriver.getDriver_name() + " was booked for your booking coming in a vehilce numbered " + vehicleNumber);
		System.out.println("The ride completed successfully");
		System.out.println("The total cost for the ride  is " + totalCost);
		
		System.out.println("Enter the rating (out of 5) fro the driver ");
		int newRating = sc.nextInt();
		
		driver.updateTheRating(driverId, newRating);
		System.out.println("Rating submitted successfully");
		
		driver.updateLocation(toLocationX, toLocationY, driverId);
			
	}
	
	public ArrayList <Driver> getAllDrivers () throws SQLException {
		Driver driver = new Driver();
		ArrayList <Driver> res = driver.getAllDrivers();
		return res;
	}
	
	public int distance(int fromLocationX , int fromLocationY , int toLocationX , int toLocationY) {
		int dist = (int)(Math.sqrt(Math.pow(toLocationX-fromLocationX,2) + Math.pow(fromLocationY-toLocationY,2)));
		return dist;
	}
	
	
	
	public int calculateAmount(int distance) {
		return distance*12;
	}
	
	public void registerTheRide(int driver_id , int rider_id , int fromLocationX , int fromLocationY , int toLocationX , int toLocationY , int vehicle_id , int amount) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Insert into ride (driver_id , rider_id , fromLocationX , fromLocationY , toLocationX , toLocationY , vehicle_id , amount) values "
				+ "("+driver_id+","+rider_id+","+fromLocationX+","+fromLocationY+","+toLocationX+","+toLocationY+","+vehicle_id+","+amount+");";
		st.execute(query);
		con.close();
	}
	
	
	
	
	
	
	
	

}
