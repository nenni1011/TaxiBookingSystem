package mtbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vehicle {

	/* 
	 1) registerVehicle
	 2) getVehicleObjectWithDriverId
	 3) changeTheVehicle
	 
	 */
	
	/*
	 1) vehicleNo
	 2) vehicleName
	 3) vehicleType
	 4) vehicleModel
	  */
	
	/*
	 1)	Vehicle
	 */
	private int vehicle_id;
	private String vehicleNo;
	public String vehicleName;
	private String vehicleType;
	
	public int getVehicle_id() {
		return vehicle_id;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public int getVehicleModel() {
		return vehicleModel;
	}

	public int getDriver_id() {
		return driver_id;
	}

	private int  vehicleModel;
	private int driver_id;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int vehicle_id , String vehicleNo , String vehicleName , String vehicleType , int  vehicleModel , int driver_id) {
		this.vehicle_id = vehicle_id;
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.driver_id = driver_id;
	}
	
	public void registerVehicle(String vehicleNo , String vehicleName , String vehicleType , int  vehicleModel , int driver_id) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query  = "Insert into vehicle (vehicle_no , vehicle_name , vehicle_type , vehicle_model , driver_id) values"
				+ " ('" + vehicleNo + "','" + vehicleName + "','" + vehicleType + "','" + vehicleModel + "', " + driver_id + ");" ;
		st.execute(query);
		con.close();
	}
	
	public int getVehicleId(String vehicleNo) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select vehicle_id from vehicle where vehicle_no = '" + vehicleNo + "';";
		ResultSet rs = st.executeQuery(query);
		int vid = -1;
		while(rs.next()) {
			vid = rs.getInt(1);
			break;
		}
		con.close();
		return vid;
	}
	
	public void changeTheVehicle(String vehicleNo , String vehicleName , String vehicleType , int vehicleModel , int driver_id) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query1 = "Delete from vehicle where driver_id = " + driver_id + ";";
		String query2  = "Insert into vehicle (vehicle_no , vehicle_name , vehicle_type , vehicle_model , driver_id) values"
				+ " ('" + vehicleNo + "','" + vehicleName + "','" + vehicleType + "','" + vehicleModel + "', " + driver_id + ");" ;
		st.execute(query1);
		st.execute(query2);
		int vehicle_id = getVehicleId(vehicleNo);
		String query3 = "Update driver set vehicle_id = " + vehicle_id + " where driver_id = " + driver_id + ";";
		st.execute(query3);
		con.close();		
	}
	
	public Vehicle getTheVehicleObject(int driverId) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select * from vehicle where driver_id = " + driverId + ";";
		ResultSet rs = st.executeQuery(query);
		Vehicle obj = null;
		while(rs.next()) {
			obj = new Vehicle(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getInt(5) , rs.getInt(6));
		}
		return obj;
	}
	
	public int getTheVehicleId(int driverId) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "select vehicle_id from vehicle where driver_id = " + driverId + ";";
		ResultSet rs = st.executeQuery(query);
		int vid = -1;
		while(rs.next()) {
			vid = rs.getInt(1);
			break;
		}
		return vid;
		
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setVehicleModel(int vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	
	

}
