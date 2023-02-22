package mtbs;

import java.sql.SQLException;

public class CabBookingService {
	UserService us = new UserService();
	RideService rs = new RideService();
	
	public void bookRide(String riderEmail , int fromLocationX , int fromLocationY , int toLocationX , int toLocationY , String preferredVehicleType) throws SQLException{
		rs.bookRide(riderEmail, fromLocationX, fromLocationY, toLocationX, toLocationY, preferredVehicleType);
	}
	
	
	public boolean verifyDriver(String email , String password) throws SQLException {
		return us.verifyDriver(email , password);
	}
	
	public boolean verifyRider(String email , String password) throws SQLException {
		return us.verifyRider(email, password);
	}

	public void registerDriver(String userName , int age , String gender , String email , String password , String mobileNumber ,
			String address , String liscenseNo , int locationX , int locationY,
			String vehicleNumber , String vehicleName , String vehicleType , int vehicleModel) throws SQLException {
		us.registerDriver(userName, age, gender, email, password, mobileNumber, address, liscenseNo, locationX, locationY, vehicleNumber, vehicleName, vehicleType, vehicleModel);
		
	}
	
	public void registerRider(String name , int age , String gender , String email , String password , String mobileNumber , String address) throws SQLException  {
		us.registerRider(name, age, gender, email, password, mobileNumber, address);
		
	}
	
	public void changeRiderPassword(String email , String newPassword) throws SQLException {
		us.changeRiderPassword(email, newPassword);
	}
	
	public void changeDriverPassword(String email , String newPassWord) throws SQLException {
		us.changeDriverPassword(email,newPassWord);
	}
	
	public void changeDriverVehicle(String vehicleNo , String vehicleName , String vehicleType , int vehicleModel , String email) throws SQLException {
		us.changeDriverVehicle(vehicleNo, vehicleName, vehicleType, vehicleModel, email);
	}
	
	public void changeDriverMobile(String email , String newMobileNumber) throws SQLException {
		us.changeDriverMobile(email, newMobileNumber);
	}
	
	public void changeRiderMobile(String email , String newMobileNumber) throws SQLException {
		us.changeRiderMobile(email, newMobileNumber);
	}
	
	public void getDriverRides(String email) throws SQLException {
		us.getDriverRides(email);
	}
	
	public void getRiderRides(String email) throws SQLException{
		us.getRiderRides(email);
	}
	
	public int getDriverEarnings(String email) throws SQLException {
		return us.getDriverEarnings(email);
	}
	
	public int getRiderExpenses(String email) throws SQLException {
		return us.getRiderExpenses(email);
	}
	
	public String getTheDriverName(String email) throws SQLException{
		return us.getTheDriverName(email);
	}
	
	public String getTheRiderName(String email) throws SQLException {
		return us.getTheRiderName(email);
	}
}
