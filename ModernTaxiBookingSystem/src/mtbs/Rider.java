package mtbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Rider extends User{
	/*
	 0) superToUseWithUserWithF
	 1)	registerRider
	 2) getMyRidesAllDetails
	 3) getMyExpenses
	 4) verifyRiderWithEmail
	 5) changePassword
	 6) changeMobileNumber
	 
	 */
	
	/*
	 */
	
	/*
	 1) Rider
	 2) Ride
	   */
	
	private int riderId;
	private String riderName;
	
	public Rider() {
		
	}
	
	public int getRiderId(String email) throws SQLException{
		return getTheUserId(email);
	}
	
	public String getRiderName(int rider_id) throws SQLException{
		return getTheUserName(rider_id);
	}
	
	public String getTheRiderName(String email) throws SQLException {
		return getTheUserName(email);
	}
	public Rider(String name , int age , String gender , String email , String password , String mobileNumber , String address) throws SQLException {
		super(name , age , gender , false , email , password , mobileNumber , address);
		riderId = getTheUserId(email);
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Insert into rider values ("+riderId+",'" + name + "');";
		st.execute(query);
		con.close();
	}
	
	public void changeRiderPassword(String email , String newPassword) throws SQLException {
		changePassword(email, newPassword);
	}
	
	public void changeRiderMobileNumber(String email , String newMobileNumber) throws SQLException {
		changeMobileNumber(email, newMobileNumber);
	}
	
	Ride ride = new Ride();
	
	public void printAllMyRides(String email) throws SQLException {
		int id = getTheUserId(email);
		ArrayList <Ride> al = ride.getRidesOfRider(id);
		if(al.size() == 0) {
			System.out.println("There are no records for you !!");
			return ;
		}
		System.out.println("RideId    DriverId    RiderId    fromLoctionX    fromLocationY    toLocationX    toLocationY    vehicleId    totalCost");
		for(Ride r : al)
			System.out.println(r.getRide_id() + "    " + r.getDriverId() + "    " + r.getRiderId() + "    " + r.getFromLocationX() + "    " + r.getFromLocationY() + "    " + r.getToLocationX() + "    " + r.getToLocationY() + "    " + r.getVehicle_id() + "    " + r.getTotalCost());
	}
	
	public int printMyTotalExpenses(String email) throws SQLException {
		int id = getTheUserId(email);
		return ride.totalExpensesOfRider(id);
		
	}
	
	public boolean verifyRider(String email , String newPassword) throws SQLException{
		return verifyUser(email, newPassword);
	}

	public int getRiderId() {
		return riderId;
	}

	

	public String getRiderName() {
		return riderName;
	}

	

	public Ride getRide() {
		return ride;
	}

	
	
	
	
	
	
	
	
	
}
