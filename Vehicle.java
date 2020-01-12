//Humza Imran
//500522148

import java.util.Random;

public class Vehicle 
{

	public enum PowerSource
	{
		GAS_ENGINE, DIESEL_ENGINE, ELECTRIC_MOTOR;
	}
	
	public PowerSource power;
	String manuf;
	String color;
	int    numWheels;
	int    vin; 
	
	public Vehicle()
	{
		this.manuf = "";
	}
	
	public Vehicle(String manuf, String color, int numWheels, PowerSource power)
	{
	  // generate random numbers between 100 and 499
	  Random num = new Random();
	  //assign number to vin 
	  vin = num.nextInt(400) + 100;
	  this.manuf     = manuf;
	  this.color     = color;
	  this.numWheels = numWheels;
	  this.power     = power;
	}
	
	public String display()
	{
		return "VIN " + vin + " " + manuf + " " + color;
	}
	
	public boolean equals(Object other)
	{
		Vehicle otherV = (Vehicle) other;
		return power == otherV.power && manuf.equals(otherV.manuf) && numWheels == otherV.numWheels;
	}

	public int getVin()
	{
		return this.vin; 
	}

}
