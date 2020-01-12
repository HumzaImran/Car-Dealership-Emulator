//Humza Imran
//500522148

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Random;


class Transaction{
	

	int id;
	GregorianCalendar date; 
	Car car;
	String salesPerson; 
	String type; 
	double salePrice;
	SalesTeam saleperson = new SalesTeam();
	Car inventoryInfo = new Car();

	public Transaction(){}

	public Transaction(GregorianCalendar date, Car car, String salesPerson, String type, double salePrice)
	{
		Random num = new Random();
		id = num.nextInt(100) + 1;
		this.id = id;
		this.date = date;
		this.car = car;
		this.salesPerson = salesPerson;
		this.type = type;
		this.salePrice = salePrice;
	}


	//method to return the display of Tranaction type
	public String display()
	{

		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
		String printDate = "Date : " + sdf.format(date.getTime());

		String printString = "ID: " + id + " " + printDate + " " + type + " SalesPerson: " + salesPerson + " " + car.display();
		return printString;
	}

	//getter for sales price
	public double getsalesPrice()
	{
		return this.salePrice;
	}
	//getter for Buy or RET
	public String getType()
	{
		return this.type;
	}



}