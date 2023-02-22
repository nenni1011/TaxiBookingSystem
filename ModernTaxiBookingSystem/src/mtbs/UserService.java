package mtbs;

import java.sql.SQLException;

public class UserService {
	public boolean verifyDriver(String email , String newPssword) throws SQLException {
		Driver driver = new Driver();
		return driver.verifyDriver(email, newPssword);
	}
	
	public boolean verifyRider(String email , String newPassword) throws SQLException {
		Rider rider = new Rider();
		return rider.verifyRider(email, newPassword);
	}

	public void registerDriver(String userName , int age , String gender , String email , String password , String mobileNumber ,
			String address , String liscenseNo , int locationX , int locationY,
			String vehicleNumber , String vehicleName , String vehicleType , int vehicleModel) throws SQLException {
		Driver driver = new Driver(userName , age , gender , email , password , mobileNumber , address , liscenseNo , locationX , locationY , vehicleNumber , vehicleName , vehicleType , vehicleModel);;
		
		
	}
	
	public void registerRider(String name , int age , String gender , String email , String password , String mobileNumber , String address) throws SQLException  {
		Rider rider = new Rider(name , age , gender , email , password , mobileNumber , address);
		
	}
	
	public void changeRiderPassword(String email , String newPassword) throws SQLException {
		Rider rider = new Rider();
		rider.changePassword(email, newPassword);
	}
	
	public void changeDriverMobileNumber(String email , String newPassWord) throws SQLException {
		Driver driver = new Driver();
		driver.changeDriverMobileNumber(email, newPassWord);
	}
	
	public void changeDriverPassword(String email , String newPassword) throws SQLException {
		Driver driver = new Driver();
		driver.changeDriverPassword(email, newPassword);
	}
	
	public void changeDriverVehicle(String vehicleNo , String vehicleName , String vehicleType , int vehicleModel , String email) throws SQLException {
		Driver driver = new Driver();
		driver.changeTheVehicle(vehicleNo, vehicleName, vehicleType, vehicleModel, email);
	}
	
	public void changeDriverMobile(String email , String newMobileNumber) throws SQLException {
		Driver driver = new Driver();
		driver.changeDriverMobileNumber(email, newMobileNumber);
	}
	
	public void changeRiderMobile(String email , String newMobileNumber) throws SQLException {
		Rider rider = new Rider();
		rider.changeMobileNumber(email, newMobileNumber);
	}
	
	public void getDriverRides(String email) throws SQLException {
		Driver driver = new Driver();
		driver.printAllMyRides(email);
	}
	
	public void getRiderRides(String email) throws SQLException{
		Rider rider = new Rider();
		rider.printAllMyRides(email);
	}
	
	public int getDriverEarnings(String email) throws SQLException {
		Driver driver = new Driver();
		return driver.printMyTotalEarnings(email);
	}
	
	public int getRiderExpenses(String email) throws SQLException {
		Rider rider = new Rider();
		return rider.printMyTotalExpenses(email);
	}
	
	public String getTheDriverName(String email) throws SQLException{
		Driver driver = new Driver();
		return driver.getTheDriverName(email);
	}
	
	public String getTheRiderName(String email) throws SQLException{
		Rider rider = new Rider();
		return rider.getTheRiderName(email);
	}

	

}
