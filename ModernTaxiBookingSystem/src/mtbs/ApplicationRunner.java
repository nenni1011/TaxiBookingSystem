package mtbs;

import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationRunner {
	
	
	
	
	
	
	

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		CabBookingService cbs = new CabBookingService();
		boolean isDriver = false;
		
		System.out.println("Welcome to Modern Taxi Booking Application");
		System.out.println("----****----****----****----****----****----****----****----****");
		int choice = -1;
		
		while(choice != 1 && choice != 2) {
		System.out.println("Enter 1 to Driver login / signup");
		System.out.println("Enter 2 to Rider login / signup");
		 choice = sc.nextInt();
		if(choice == 1) {
			isDriver = true;
		}else if(choice == 2){
			isDriver = false;
		}else {
			System.out.println("Invalid input type");
			System.out.println("Please enter the valid input !!");
		}
		}
		
		
		//DRIVER PORTAL
		if(isDriver) {// STARTS
			
			System.out.println("Welcome to driver access portal !!");
			System.out.println("----****----****----****----****----****----****----****----****");
			int currChoice = -1;
			
			while(currChoice != 1 && currChoice != 2) {
				System.out.println("Enter 1 to login");
				System.out.println("Enter 2 to signup");
				currChoice = sc.nextInt();
				
				if(currChoice != 1 && currChoice != 2) {
					System.out.println("Please enter a valid input");
				}
			}
			
			if(currChoice == 1) {
				System.out.println("Welcome to login page of driver portal !!");
				System.out.println("----****----****----****----****----****----****----****----****");
				
				System.out.println("Please enter all of the required prompted fields !!");
				System.out.println("----****----****----****----****----****----****----****----****");
				
				boolean flag = false;
				String driverEmail = "";
				
				while(!flag) {
					
					System.out.println("Email : ");
					String email = sc.next();
					
					System.out.println("Password : ");
					String password = sc.next();
					
					boolean isValid = cbs.verifyDriver(email, password);
					if(isValid) {
						driverEmail = email;
						flag = true;
					}
					else {
						System.out.println("Please enter the correct email ID and password");
						System.out.println("------");
						System.out.println("If you haven't signed up yet , head towards sign up first !!");
						System.out.println("------");
					}
				}
				
				String driverName = cbs.getTheDriverName(driverEmail);
				
				System.out.println("Welcome Back Driver " + driverName);
				System.out.println("----****----****----****----****----****----****----****----****");
				
				System.out.println();
				System.out.println("Our Services for you are presented below !!");
				System.out.println("----****----****----****----****----****----****----****----****");
				System.out.println();
				int operationChoice = -1;
				
				
				while(operationChoice != 6) {
				System.out.println("1. Change your Password");
				System.out.println("2. Change your Vehicle");
				System.out.println("3. Change your MobileNumber");
				System.out.println("4. Print all your rides");
				System.out.println("5. Print your total Earnings");
				System.out.println("6. Exit from the application");
				
				System.out.println();
				System.out.println("Enter the number which assigned for your appropriate operation which had been mentioned above");
				System.out.println();
				System.out.println("----****----****----****----****----****----****----****----****");
				
				System.out.println();
				
				operationChoice = sc.nextInt();
				
				if(operationChoice == 6) break;
				
				if(!(operationChoice >= 1 && operationChoice <= 6)) {
					System.out.println("Please enter a valid option");
					System.out.println("-----");
					System.out.println();
					continue;
				}
				
				if(operationChoice == 1) {
					System.out.println("You have selected the option for changing your password");
					System.out.println();
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Please enter all of the required prompted fields !!");
					System.out.println("----****----****----****----****----****----****----****----****");
					
					System.out.println("Enter your new password");
					String newPassword = sc.next();
					
					cbs.changeDriverPassword(driverEmail, newPassword);
					System.out.println("Password had been changed successfully !!");
					System.out.println("You can cross check that by login again !!");
					
					
					
				}else if(operationChoice == 2) {
					System.out.println("You have selected the option for changing your vehicle");
					System.out.println();
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					System.out.println("Please enter all of the required prompted fields !!");
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Vehicle No. : ");
					String vehicleNo = sc.next();
					
					System.out.println("Vehicle Name. : ");
					String vehicleName = sc.next();
					
					System.out.println("Vehicle Type : ");
					String vehicleType = sc.next();
					
					System.out.println("Vehicle Model : ");
					String vehicleModel = sc.next();
					
					cbs.changeDriverVehicle(vehicleNo, vehicleName, vehicleType, operationChoice, driverEmail);
					System.out.println("Your vehicle had been changed successfully");
					System.out.println();
					
					
				}else if(operationChoice == 3) {
					System.out.println("You have selected the option for changing your mobileNumber");
					System.out.println();
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Please enter all of the required prompted fields !!");
					System.out.println("----****----****----****----****----****----****----****----****");
					
					System.out.println("Enter your new mobile number");
					String newMobileNumber = sc.next();
					
					cbs.changeDriverMobile(driverEmail, newMobileNumber);
					System.out.println("Mobile Number had been changed successfully !!");
					
				}else if(operationChoice == 4) {
					
					System.out.println("You have selected the option for printing all your rides");
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Your succesfully completed rides are listed below !!");
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					cbs.getDriverRides(driverEmail);
					System.out.println();
					
					
				}else if(operationChoice == 5) {
					System.out.println("You have selected the option for printing your total earnings");
					System.out.println();
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Your total earnings are " + cbs.getDriverEarnings(driverEmail));
					System.out.println();
				}
				
				
				}
				
				
				
				
				
				
				
				
				
			}else {
				System.out.println("Welcome to signup page of driver portal !!");
				
				System.out.println("----****----****----****----****----****----****----****----****");
				
				System.out.println("Please enter all of the required prompted fields !!");
				System.out.println("----****----****----****----****----****----****----****----****");
				
				
				System.out.println("Username : ");
				String userName = sc.next();
				
				System.out.println("Age : ");
				int age = sc.nextInt();
				
				System.out.println("Gender : ");
				String gender = sc.next();
				
				System.out.println("Email : ");
				String email = sc.next();
				
				System.out.println("Password : ");
				String password = sc.next();
				
				System.out.println("Mobile Number : ");
				String mobileNumber = sc.next();
				
				System.out.println("Address : ");
				String address = sc.next();
				
				System.out.println("Liscense No : ");
				String liscenseno = sc.next();
				
				System.out.println("Location X Coordinate : ");
				int locationX = sc.nextInt();
				
				System.out.println("Location Y Coordinate : ");
				int locationY = sc.nextInt();
				
				System.out.println("Vehicle No. : ");
				String vehicleNo = sc.next();
				
				System.out.println("Vehicle name : ");
				String vehicleName = sc.next();
				
				System.out.println("Vehicle Type : ");
				String vehicleType = sc.next();
				
				System.out.println("Vehicle Model : ");
				int vehicleModel = sc.nextInt();
				
				cbs.registerDriver(userName, age, gender, email, password, mobileNumber, address, liscenseno, locationX, locationY, vehicleNo, vehicleName, vehicleType, vehicleModel);
				System.out.println("Driver Registered Successfully");
				System.out.println();
				System.out.println("Please ReRun your application again to login !!");
				
			}
			
			
			
				
			
		}//DRIVER PORTAL ENDS
		
		
		//RIDER PORTAL
		else {//STARTS
			
			System.out.println("Welcome to rider access portal !! ");
			System.out.println("----****----****----****----****----****----****----****----****");
			
			int currChoice = -1;
			
			while(currChoice != 1 && currChoice != 2) {
				System.out.println("Enter 1 to login");
				System.out.println("Enter 2 to signup");
				currChoice = sc.nextInt();
				
				if(currChoice != 1 && currChoice != 2) {
					System.out.println("Please enter a valid input");
				}
			}
			
			if(currChoice == 1) {
				System.out.println("Welcome to login page of rider portal !!");
				System.out.println("----****----****----****----****----****----****----****----****");
				
				System.out.println("Please enter all of the required prompted fields !!");
				System.out.println("----****----****----****----****----****----****----****----****");
				
				
				
				
				
				boolean flag = false;
				String riderEmail = "";
				
				while(!flag) {
					System.out.println("Email : ");
					String email = sc.next();
					
					System.out.println("Password : ");
					String password = sc.next();
					
					boolean isValid = cbs.verifyRider(email, password);
					if(isValid) {
						flag = true;
						riderEmail = email;
					}
					else {
						System.out.println("Please enter the correct email ID and password");
						System.out.println("-----");
						System.out.println("If you haven't signed up yet , head towards sign up first !!");
						System.out.println("-----");
					}
				}
				
				String riderName = cbs.getTheRiderName(riderEmail);
				
				System.out.println("Welcome Back Rider " + riderName);
				System.out.println("----****----****----****----****----****----****----****----****");
				
				System.out.println();
				System.out.println("Our Services for you are presented below !!");
				System.out.println("----****----****----****----****----****----****----****----****");
				System.out.println();
				int operationChoice = -1;
				
				
				while(operationChoice != 6) {
				System.out.println("1. Book for a Ride");
				System.out.println("2. Change your Password");
				System.out.println("3. Change your MobileNumber");
				System.out.println("4. Print all your rides");
				System.out.println("5. Print your Total Expenses");
				System.out.println("6. Exit from the application");
				System.out.println();
				System.out.println("----****----****----****----****----****----****----****----****");
				
				System.out.println();
				
				System.out.println("Enter the number which assigned for your appropriate operation which had been mentioned above");
				operationChoice = sc.nextInt();
				
				if(operationChoice == 6) break;
				if(!(operationChoice >= 1 && operationChoice <= 6)) {
					System.out.println("Please enter a valid choice !!");
					System.out.println("-----");
					System.out.println();
					continue;
				}
				
				if(operationChoice == 1) {
					System.out.println("You have selected the option for booking a ride");
					System.out.println();
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Please enter all of the required prompted fields !!");
					System.out.println("----****----****----****----****----****----****----****----****");
					
					System.out.println("Enter X coordinate of source location : ");
					int fromLocationX = sc.nextInt();
					
					System.out.println("Enter Y coordinate of source location : ");
					int fromLocationY = sc.nextInt();
					
					System.out.println("Enter X coordinate of destination location : ");
					int toLocationX = sc.nextInt();
					
					System.out.println("Enter Y coordinate of destination location : ");
					int toLocationY = sc.nextInt();
					
					System.out.println("Enter your preffered vehicle type : ");
					String prefferedVehicleType = sc.next();
					
					cbs.bookRide(riderEmail, fromLocationX, fromLocationY, toLocationX, toLocationY, prefferedVehicleType);
					
					
				}else if(operationChoice == 2) {
					System.out.println("You have selected the option for changing your password");
					System.out.println();
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Please enter all of the required prompted fields !!");
					System.out.println("----****----****----****----****----****----****----****----****");
					
					System.out.println("Enter your new password");
					String newPassword = sc.next();
					
					cbs.changeRiderPassword(riderEmail, newPassword);
					System.out.println("Password had been changed successfully !!");
					System.out.println("You can cross check that by login again !!");
					
				}else if(operationChoice == 3) {
					System.out.println("You have selected the option for changing your mobileNumber");
					System.out.println();
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Please enter all of the required prompted fields !!");
					System.out.println("----****----****----****----****----****----****----****----****");
					
					System.out.println("Enter your new mobile number");
					String newMobileNumber = sc.next();
					
					cbs.changeRiderMobile(riderEmail, newMobileNumber);
					System.out.println("Mobile Number had been changed successfully !!");
					
				}else if(operationChoice == 4) {
					System.out.println("Your succesfully completed rides are listed below !!");
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					cbs.getRiderRides(riderEmail);
					System.out.println();
					
				}else if(operationChoice == 5) {
					System.out.println("You have selected the option for printing your total expenses");
					System.out.println();
					System.out.println("----****----****----****----****----****----****----****----****");
					System.out.println();
					
					System.out.println("Your total expenses are " + cbs.getRiderExpenses(riderEmail));
					System.out.println();
					
				}
				
				
				}
				
				
				
				
				
			}else {
				System.out.println("Welcome to signup page of rider portal !!");
				System.out.println("----****----****----****----****----****----****----****----****");

				System.out.println("Please enter all of the required prompted fields !!");
				System.out.println("----****----****----****----****----****----****----****----****");
				
				System.out.println("Name : ");
				String name = sc.next();
				
				System.out.println("Age : ");
				int age = sc.nextInt();
				
				System.out.println("Gender : ");
				String gender = sc.next();
				
				System.out.println("Email : ");
				String email = sc.next();
				
				System.out.println("Password : ");
				String password = sc.next();
				
				System.out.println("Mobile Number : ");
				String mobileNumber = sc.next();
				
				System.out.println("Address : ");
				String address = sc.next();
				
				cbs.registerRider(name, age, gender, email, password, mobileNumber, address);
				System.out.println("Rider registered successfully");
				System.out.println();
				System.out.println("Please ReRun your application again to login");
				
				
				
			}
			
			
			
		}//RIDER PORTAL ENDS..
		
		
		
		

	}

}
