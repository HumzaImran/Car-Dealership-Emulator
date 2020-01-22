//Humza Imran
//500522148

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Arrays;

public class Car extends Vehicle implements Comparable<Car>
{
  public static enum Model
  {
	  SEDAN__, SUV, SPORTS_, MINIVAN;
  }
  
  Model   model; 
  int     maxRange; 
  double  safetyRating;
  boolean AWD;
  double  price;
  
  public Car()
  {
	  this.model = Model.SEDAN__;
  }
  
  public Car(String manuf, String color, Model model, Vehicle.PowerSource power, 
		     double safety, int range, boolean awd, double price)
  {
	  super(manuf, color, 4, power);
	  this.model = model;
	  this.price = price;
	  AWD = awd;
	  safetyRating = safety;
	  maxRange = range;
  }
  
  public String display()
  {
	  return super.display() + "     " + model + "   " + price + "$" + " SF:     " + safetyRating + " RNG:     " + maxRange;
  }
  
  public String toString()
  {
	return "";
  }
  
  
  public boolean equals(Object other)
  {
	  Car otherCar = (Car) other;
	  return super.equals(other) && this.model == otherCar.model && this.AWD == otherCar.AWD; 
  }
  
  public int compareTo(Car other)
  {
    if      (this.price > other.price) return  1;
	else if (this.price < other.price) return -1;
	else                               return  0;
  }
  
   

}
