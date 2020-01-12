//Humza Imran
//500522148

import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;


class AccountingSystem{
	//creata array list to store transactions 
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public String add(GregorianCalendar date, Car car, String salesPerson, String type, double salePrice)
	{
		Random ran = new Random();
		int id = ran.nextInt(99) + 1;
		Transaction transaction = new Transaction(date, car, salesPerson, type, salePrice);
		transactions.add(transaction);
		return transaction.display();

	}
	// method to get sales record 
    public void getSalesRecords() {
    	// goes through all the transcations 
    	for (Transaction t: transactions) {
    		// displays them all
    		System.out.println(t.display());
    	}
    }
    //method to get sales based on month requested. 
    public void salesMonth(int month) {
    	//goes through all the transactions 
 		for (Transaction t: transactions) {
 			// identifies which month was requested 
    		if (t.date.get(Calendar.MONTH) == month - 1) {
    			// prints out requested month's sales 
    			System.out.println(t.display());
    		}
    	}
    }
    //methof to display sales Stats information
    public void salesStats() {
    	int returnCount = 0;
    	int soldCount = 0;
    	double total = 0;
    	double averageSales = 0;

    	// goes through all transactions 
    	for(Transaction t: transactions)
    	{
    		// if the transaction has a "BUY" type 
    		if(t.getType().equals("BUY"))
    		{
    		// increase sold cars by 1
    		soldCount++;
    		// increase total by sold car price
    		total += t.getsalesPrice();
    		
    		}
    		//if the tranaction has a "RET" type
    		if (t.getType().equals("RET"))
    		{
    			//increase return car count by 1
    		returnCount++;
    		// subtract car price from total of cars sold
    		total -= t.getsalesPrice();
    		//subtract one from cars sold. 
    		soldCount--;
    		}
    		
    	}
    	//finds average of cars sold per month. 
    	averageSales = total /12;
    	System.out.printf("Total Sales: $%.2f Avg Sales: $%.2f",total, averageSales);
    	System.out.print(" Total Returned: " + returnCount +" Total Sold: " + soldCount); 

    }



}