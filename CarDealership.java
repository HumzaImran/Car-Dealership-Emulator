//Humza Imran
//500522148

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.lang.IllegalArgumentException;
import java.util.GregorianCalendar;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class CarDealership 
{
  Car lastSoldCar;
  ArrayList<Car> cars;
  ArrayList<Car> boughtCars;
  SalesTeam salesTeam = new SalesTeam();
  Map<Integer, String> salesPersonInfo = new HashMap<Integer, String>();
  AccountingSystem accountingSystem = new AccountingSystem();

  
  // Filters
  boolean electricFilter = false;
  boolean priceFilter = false;
  double  priceMin    = 0;
  double  priceMax    = 0;
  boolean AWDFilter = false;
  
  public CarDealership()
  {
	  cars = new ArrayList<Car>();
	  boughtCars = new ArrayList<Car>();
  }

  public void addCars(ArrayList<Car> newCars)
  {
	  cars.addAll(newCars);
	  newCars.clear();
  }
  
  public String buyCar(int VIN)
  {
  	
  	if(VIN <100 || VIN > 499)
  	{
  		throw new IllegalArgumentException();	
  	}
  		for(Car car: cars)
  		{
  			if (VIN == car.getVin())
  			{
  				cars.remove(car);
  				boughtCars.add(car);
  				String salesPerson = salesTeam.getSalesPerson();
  				salesPersonInfo.put(VIN, salesPerson);
  				Random num = new Random();
	  			int month = num.nextInt(11) + 1;
	  			int day = num.nextInt(20) + 1; 
	  			GregorianCalendar calendar = new GregorianCalendar(2019, month, day);
	  			double price = car.price;

	  			String receipt = accountingSystem.add(calendar, car, salesPerson, "BUY", price);
	  			lastSoldCar = car;

	  			return receipt;
	  		}
  		}
	return null;
	  
  }

  public String returnCar(int VIN)
  {

  	if(VIN <100 || VIN > 499)
  	{
  		throw new IllegalArgumentException();	
  	}
  		for(Car car: boughtCars)
  		{
  			if (VIN == car.getVin())
  			{
  				cars.add(car);
  				String salesPerson = salesPersonInfo.get(VIN);
  				Random num = new Random();

	  			int month = num.nextInt(11) + 1;
	  			int day = num.nextInt(20) + 1; 
	  			GregorianCalendar calendar = new GregorianCalendar(2019, month, day);
	  			double price = car.price;
	  			String receipt = accountingSystem.add(calendar, car, salesPerson, "RET", price);
	  			return (receipt);
	  		}
  		}
	return null;
  }

  public void displayInventory()
  {
	  System.out.println("");
	  
	  for (int i = 0; i < cars.size(); i++)
	  {
		Car car = cars.get(i);
		
		if (priceFilter && (car.price < priceMin || car.price > priceMax))
		   continue;
		
		if (electricFilter && car.power != Vehicle.PowerSource.ELECTRIC_MOTOR)
		   continue;
		
		if (AWDFilter && !car.AWD)
		   continue;
		if(i < 10)
		{
			System.out.println(""+ i + "      " + car.display());
		}
		else if(i>9) {
			System.out.println(""+ i + "     " + car.display());
		}
		
	  }
	  System.out.println("");
  }
  
  public void filtersClear()
  {
	  electricFilter = false;
	  priceFilter = false;
	  AWDFilter = false;
  }
  
  public void filterByPrice(double min, double max)
  {
	  priceFilter = true;
	  priceMin    = min;
	  priceMax    = max;
  }
  public void filterByElectric()
  {
	  electricFilter = true;
  }
  public void filterByAWD()
  {
	  AWDFilter = true;
  }
  

  public void sortByPrice()
  {
	  Collections.sort(cars);
  }
  
  private class SafetyRatingComparator implements Comparator<Car>
  {
  	public int compare(Car a, Car b)
  	{
  	  if      (a.safetyRating < b.safetyRating) return  1;
  	  else if (a.safetyRating > b.safetyRating) return -1;
  	  else                                      return  0;		  
  	}
  }
  public void sortBySafetyRating()
  {
	Collections.sort(cars,new SafetyRatingComparator());
  }
  
  private class RangeComparator implements Comparator<Car>
  {
  	public int compare(Car a, Car b)
  	{
  	  if      (a.maxRange < b.maxRange) return  1;
  	  else if (a.maxRange > b.maxRange) return -1;
  	  else                              return  0;		  
  	}
  }
  public void sortByMaxRange()
  {
	Collections.sort(cars,new RangeComparator());
  }

  public Car getLastSoldCar() {
  	return lastSoldCar;
  }
  public Car createCarList (String[] carList)
	  {
	  	
	  	
	  	//SEDAN, SUV, SPORTS, MINIVAN;
	  	Car.Model   model = null; 
	  	Vehicle.PowerSource power = null;
	  	if(carList[2].equals("SEDAN__"))
	  	{
	  		model = Car.Model.SEDAN__;
	  	}
	  	if(carList[2].equals("SPORTS_"))
	  	{
	  		model = Car.Model.SPORTS_;
	  	}
	  	if(carList[2].equals("SUV"))
	  	{
	  		model = Car.Model.SUV;
	  	}
	  	if(carList[2].equals("MINIVAN"))
	  	{
	  		model = Car.Model.MINIVAN;
	  	}
	  	if(carList[3].equals("GAS_ENGINE"))
	  	{
	  		power = Vehicle.PowerSource.GAS_ENGINE;
	  	}

	  	Car car = new Car(carList[0], carList[1], model, power,Double.parseDouble(carList[4]),
	  		Integer.parseInt(carList[5]), Boolean.parseBoolean(carList[6]),Double.parseDouble(carList[7]));
	  	
	  	return car; 
	  }
	  public ElectricCar electricCarList(String[] carList)
	  {

	  	
	  	//SEDAN, SUV, SPORTS, MINIVAN;
	  	Car.Model   model = null; 
	  	Vehicle.PowerSource power = null;
	  	if(carList[2].equals("SEDAN__"))
	  	{
	  		model = Car.Model.SEDAN__;
	  	}
	  	if(carList[2].equals("SPORTS_"))
	  	{
	  		model = Car.Model.SPORTS_;
	  	}
	  	if(carList[2].equals("SUV"))
	  	{
	  		model = Car.Model.SUV;
	  	}
	  	if(carList[2].equals("MINIVAN"))
	  	{
	  		model = Car.Model.MINIVAN;
	  	}
	  	if(carList[3].equals("ELECTRIC_MOTOR"))
	  	{
	  		power = Vehicle.PowerSource.ELECTRIC_MOTOR;
	  	}

	  	ElectricCar car = new ElectricCar(carList[0], carList[1], model, power,Double.parseDouble(carList[4]),
	  		Integer.parseInt(carList[5]), Boolean.parseBoolean(carList[6]),Double.parseDouble(carList[7]), Integer.parseInt(carList[8]));
	  	
	  	return car; 

	  }

}
