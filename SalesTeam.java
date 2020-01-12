//Humza Imran
//500522148

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
import java.util.ListIterator;

public class SalesTeam
{
	 //linked list is declared 
	LinkedList<String> salesTeam;

	//Constructor method to add in names of the sales team.
	public SalesTeam()
  	{
  		salesTeam = new LinkedList<String>();
  		salesTeam.add("Night King");
  		salesTeam.add("Ned Stark");
  		salesTeam.add("Jon Snow");
  		salesTeam.add("Daenerys Targaryen");
  		salesTeam.add("Tyrion Lanester");
  		salesTeam.add("Hodor");
  	}

  	//method to return a random sales person when called. 
  	public String getSalesPerson()
  	{
  		Random num = new Random();
  		int finalNum = num.nextInt(5);
  		return salesTeam.get(finalNum);
  	}

  	// methd to return entire sales team when called 
  	public void getSalesTeam()
  	{	

		ListIterator<String> iter = this.salesTeam.listIterator();

  		String team = "";
  		while (iter.hasNext())
  		{
  			String next = iter.next();
  			team += next + ", ";
  		}
  		System.out.println("Sales Team: " + team); 
  	}

  	//retruns the size of sales team 
  	public int salesTeamSize()
  	{
  		return salesTeam.size();
  	}

  	//returns selected sales person
  	public String selectedSalesPerson(int i)
  	{
  		return salesTeam.get(i);
  	}


}