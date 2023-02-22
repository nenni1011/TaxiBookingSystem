package mtbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Driver extends User{
	/*
	 0) superToUserWithIsDriverT
	 1)	updateLocation
	 2) updateRating
	 3)	registerDriver
	 4) changePassword
	 5) changeVehicle
	 6) changeMobileNumber
	 7) getMyRidesAllDetails
	 8) getMyEarnings
	 9) registerTheVehicle
	 10) verifyDriverWithEmail
	 11) registerTheVehicle
	 
	  */
	
	/*
	 1) liscenseNo
	 2) vehicleNo
	 3) locationX
	 4) locationY
	 5) vehicleName
	 6) vehicleType
	 7) vehicleModel
	 8) driverRating
	  */
	
	/*
	 Driver
	
	 Ride
	  */
	private int driver_id;
	private String driver_name;
	private String liscense_no;
	private int locationX;
	private int locationY;
	private int driver_rating;
	private int vehicle_id;
	
	public int getTheDriverId(String email) throws SQLException {
		return getTheDriverId(email);
	}
	
	public String getTheDriverName(int driver_id) throws SQLException{
		return getTheUserName(driver_id);
	}
	
	public String getTheDriverName(String email) throws SQLException{
		return getTheUserName(email);
	}
	
	public Driver(int driver_id , String driver_name , String liscense_no , int locationX,  int locationY , int driverRating , int vehicle_id) {
		this.driver_id = driver_id;
		this.driver_name = driver_name;
		this.liscense_no = liscense_no;
		this.locationX = locationX;
		this.locationY = locationY;
		this.driver_rating = driverRating;
		this.vehicle_id = vehicle_id;
	}
	
	public Driver(String userName , int age , String gender , String email , String password , String mobileNumber ,
			String address , String liscenseNo , int locationX , int locationY,
			String vehicleNumber , String vehicleName , String vehicleType , int vehicleModel) throws SQLException {
		super(userName , age , gender , true , email , password , mobileNumber , address);
		int id = getTheUserId(email);
		Vehicle vehicle = new Vehicle();
		vehicle.registerVehicle(vehicleNumber, vehicleName, vehicleType, vehicleModel, id);
		int vid = vehicle.getTheVehicleId(id);
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Insert into driver values ("+id+",'"+userName+"','"+liscenseNo+"',"+locationX+","+locationY+",5,"+vid+");";
		st.execute(query);
		con.close();
	}
	
	public Driver() {
		super();
	}
	
	
	public void updateLocation(int x , int y , int id) throws SQLException {
		//int id = getTheUserId(email);
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Update driver set locationX = " + x + ", locationY = " + y + " where driver_id = " + id + ";";
		st.execute(query);
		con.close();
	}
	
	
	public void updateTheRating(int id , int newRating) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		//int id = getTheUserId(email);
		Statement st = con.createStatement();
		String query1 = "Select driver_rating from driver where driver_id = "+id+";";
		int prevRating = 0;
		ResultSet rs = st.executeQuery(query1);
		while(rs.next()) {
			prevRating = rs.getInt(1);
			break;
		}
		int upRating = (prevRating + newRating) / 2;
		String query2 = "Update driver set driver_rating = " + upRating + " where driver_id = " + id + ";";
		st.execute(query2);
		
		con.close();
	}
	
	public void changeDriverPassword(String email , String newPassWord) throws SQLException {
		changePassword(email, newPassWord);
	}
	
	public void changeDriverMobileNumber(String email , String newMobileNumber) throws SQLException {
		changeMobileNumber(email, newMobileNumber);
	}
	
	Ride ride = new Ride();
	
	public void printAllMyRides(String email) throws SQLException {
		int id = getTheUserId(email);
		ArrayList <Ride> al = ride.getRidesOfDriver(id);
		if(al.size() == 0) {
			System.out.println("There are no ride records for you !!");
			return ;
		}
		System.out.println("RideId    DriverId    RiderId    fromLoctionX    fromLocationY    toLocationX    toLocationY    vehicleId    totalCost");
		for(Ride r : al)
			System.out.println(r.getRide_id() + "    " + r.getDriverId() + "    " + r.getRiderId() + "    " + r.getFromLocationX() + "    " + r.getFromLocationY() + "    " + r.getToLocationX() + "    " + r.getToLocationY() + "    " + r.getVehicle_id() + "    " + r.getTotalCost());
	}
	
	public int printMyTotalEarnings(String email) throws SQLException {
		int id = getTheUserId(email);
		return ride.totalEarningsOfDriver(id);
		
	}
	
	public void changeTheVehicle(String vehicleNo , String vehicleName , String vehicleType , int vehicleModel , String email) throws SQLException {
		int id = getTheUserId(email);
		Vehicle vehicle  = new Vehicle();
		vehicle.changeTheVehicle(vehicleNo, vehicleName, vehicleType, vehicleModel, id);
	}
	
	public ArrayList <Driver> getAllDrivers() throws SQLException{
		ArrayList <Driver> al = new ArrayList <> ();
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select * from driver";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			al.add(new Driver(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getInt(4) , rs.getInt(5) , rs.getInt(6) , rs.getInt(7)));
		}
		return al;
	}
	
	public boolean verifyDriver(String email , String newPassword) throws SQLException{
		return verifyUser(email , newPassword);
	}
	public int getDriver_id() {
		return driver_id;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public String getLiscense_no() {
		return liscense_no;
	}

	public int getLocationX() {
		return locationX;
	}

	public int getLocationY() {
		return locationY;
	}

	public int getDriver_rating() {
		return driver_rating;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public Ride getRide() {
		return ride;
	}
	
	
	
	
	
}
