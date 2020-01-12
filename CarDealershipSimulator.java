//Humza Imran
//500522148

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class CarDealershipSimulator 
{
  static Scanner scanner1; 
  static CarDealership dealership = new CarDealership();
  static ArrayList<Car> newCars = new ArrayList<Car>();
  
  public static void main(String[] args)
  {
	  Car currentCar = null;
	  int carIndex = -1;
	  Transaction transaction = new Transaction();
	  SalesTeam salePerson = new SalesTeam();
		
	  
	  Scanner scanner = new Scanner(System.in);
	  System.out.print(">");
	  
	  while (scanner.hasNextLine())
	  {
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) 
          {
			System.out.print("\n>");
            continue;
		  }
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  if (command == null || command.equals("")) 
		  {
             System.out.print("\n>");
	         continue;
          }
		  else if (command.equals("L"))
		  {
			  dealership.displayInventory();
		  }
		  else if (command.equals("Q") || command.equals("QUIT"))
		  {	  
			  System.exit(0);
		  }
		  else if (command.equals("BUY"))
		  {
		  	//checks for errors 
		  	try{
		  		
			  carIndex = commandLine.nextInt(); 
			  String receipt = dealership.buyCar(carIndex);
			  if (receipt != null)
			  {
			    currentCar = dealership.getLastSoldCar();
			    // System.out.println(receipt);
			    System.out.println(receipt);
			  }
			  else
			    System.out.println("Invalid argument");
			}
			catch (Exception e) 
			{
				System.out.println("Invalid Vin");
			}

		  }
		  else if (command.equals("RET"))
		  {
		  	try {
		  		carIndex = commandLine.nextInt();
			  	System.out.print(dealership.returnCar(carIndex));
		  	} catch (Exception e) {
		  		System.out.print("Invalid Vin");
		  	}
		  }

		  else if (command.equals("ADD"))
		  {
		  	//function to open file and read in information 
		  	openFile();
		  	readFile();

			dealership.addCars(newCars);
		  }
		  else if (command.equals("SPR"))
		  {
			  dealership.sortByPrice();
		  }
		  else if (command.equals("SSR"))
		  {
			  dealership.sortBySafetyRating();
		  }
		  else if (command.equals("SMR"))
		  {
			  dealership.sortByMaxRange();
		  }
		  else if (command.equals("FPR"))
		  {
			  double minPrice = 0; 
			  double maxPrice = 0;
			  // Filter
			  if (!commandLine.hasNextDouble())
			  {				  
				  System.out.println("Invalid arguements");
				  continue;
			  }
			  minPrice = commandLine.nextDouble();
			  if (!commandLine.hasNextDouble())
			  {				  
				  System.out.println("Invalid arguements");
				  continue;
			  }	  
		      maxPrice = commandLine.nextDouble();
		      if (minPrice < 0 || maxPrice < 0 || minPrice > maxPrice)
		      {				  
				  System.out.println("Invalid arguements");
				  continue;
			  }	
			  dealership.filterByPrice(minPrice,maxPrice);
		  }
		  else if (command.equals("FEL"))
		  {
			  dealership.filterByElectric();
		  }
		  else if (command.equals("FAW"))
		  {
			  dealership.filterByAWD();
		  }
		  else if (command.equals("FCL"))
		  {
			  dealership.filtersClear();
		  }
		  //Sales Team command 
		  else if(command.equals("ST"))
		  {
		  	  salePerson.getSalesTeam();
		  }
		  //Sales command, displays all sales.
		  else if (command.equals("SALES"))
		  {
		  	  dealership.accountingSystem.getSalesRecords();
		  }
		  //sales stats command, displays all stats for sales.
		  else if(command.equals("SS"))
		  {
		  	  dealership.accountingSystem.salesStats();
		  }
		  //SALES M command, displays sales for requested month
		  else if(command.equals("SM"))
		  {
		  	  int month = commandLine.nextInt();
		  	  if (month >= 13 || month <= 0)
		  	  {
		  	  	System.out.println("Invalid Month");
		  	  }
		  	  else
		  	  dealership.accountingSystem.salesMonth(month);
		  }

		  System.out.print("\n>");
	  }
  }
  //method to open the cars.txt file 
  public static void openFile()
	  {
	  	// making sure car.txt is present
	  	try{
	  		scanner1 = new Scanner(new File("cars.txt"));
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println(e);
	  	}
	  }
	  // method to read in data from cars.txt
	  public static void readFile()
	  {
	  	while(scanner1.hasNext())
	  	{
	  		
	  		String[] temp;
	  		temp = scanner1.nextLine().split("\\s+");
	  		
	  		Car car ;
	  		ElectricCar eCar;
	  		//checks lenght of line from text file to call the proper function.
	  		if(temp.length == 8)
	  		{
	  			newCars.add(dealership.createCarList(temp));
	  		}
	  		else 
	  		{
	  			newCars.add(dealership.electricCarList(temp));
	  		} 

	  		
	  	}
	  }

}
