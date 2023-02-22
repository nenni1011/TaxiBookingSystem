package mtbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class User {
	/* 
	 1)	registerUser
	 2) verifyUserWithEmail
	 3) changePassword
	 4) changeMobileNumber
	 5) getUserIdWithEmail
	 */
	
	/*
	 1)	name1
	 
	 2)	age
	 3) gender
	 4) isDriver
	 5) email
	 6) password
	 7) mobileNo
	 8) address
	  
	  */
	
	/*
	 1) User
	  */
	
	
	//VARIABLES
	private int userId;
	private String userName;
	private int age;
	private String gender;
	private boolean isDriver;
	private String email;
	private String password;
	private String mobileNumber;
	private String address;
	
//	public User(int userId , String userName , int age , String gender , boolean  isDriver , String email , String password , String mobileNumber , String address) {
//		this.userId = userId;
//		this.userName = userName;
//		this.gender = gender;
//		this.isDriver = isDriver;
//		this.email = email;
//		this.password = password;
//		this.mobileNumber = mobileNumber;
//		this.address = address;
//	}
	public User() {
		
	}
	
	public String getTheUserName(String email) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select user_name from user where email = '" + email + "';";
		String name = "";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			name = rs.getString(1);
			break;
		}
		return name;
	}
	
	
	public String getTheUserName(int user_id) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select user_name from user where user_id = " + user_id + ";";
		String name = "";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			name = rs.getString(1);
			break;
		}
		return name;
	}
	
	public User(String userName , int age , String gender , boolean  isDriver , String email , String password , String mobileNumber , String address) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Insert into user (user_name , age , gender , isDriver , email , password , mobile_no , address) Values ('" + userName + "'," + age + ",'" + gender + "'," + isDriver + ",'" + email + "','" + password + "','" + mobileNumber + "','" + address + "');";
		st.execute(query);
		con.close();
		if(isDriver) {
		System.out.println("----****----****----****----****----****----****----****----****");
		System.out.println("Driver " + userName + " registered successfully");
		}else {
		System.out.println("----****----****----****----****----****----****----****----****");
		System.out.println("Rider " + userName + " registered successfully");
		}
	}
	
	
	public  int getTheUserId(String email) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select user_id from user where email = '" + email + "';" ;
		ResultSet rs = st.executeQuery(query);
		int id = -1;
		//if(rs.getFetchSize() == 0) return id;
		while(rs.next()) {
			id = rs.getInt(1);
			break;
		}
		con.close();
		return id;
		
	}
	
	public  boolean verifyUser(String email , String password) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Select password from user where email = '" + email + "';";
		ResultSet rs = st.executeQuery(query);
		
		
		String pass = "";
		while(rs.next()) {
			pass = rs.getString(1);
			break;
		}
		
		con.close();
		if(pass.equals(password)) return true;
		return false;
	}
	
	
	
	public  void changePassword(String email , String newPassword) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Update user set password = '" + newPassword + "' where email = '" + email + "';";
		st.execute(query);
		con.close();
	}
	
	public void changeMobileNumber(String email , String newMobileNumber) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taxidb","root","Ragul@nenni1234");
		Statement st = con.createStatement();
		String query = "Update user set mobile_no = '" + newMobileNumber + "' where email = '" + email + "';";
		st.execute(query);
		con.close();
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public boolean isDriver() {
		return isDriver;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getAddress() {
		return address;
	}
	
	
	
	
	
	
	
	
	
	//FUNCTIONALITIES OR METHODS
	
	//1)REGISTER USER (Constructor)
	
	
	
}
