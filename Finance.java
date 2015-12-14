//Immad Mohamed
import java.io.*;
import java.util.*;

public class Finance {
	
	public static void main(String[] args) {
		
		double rate=-1; // Variable for the rate
		double cost=-1;// Variable for total cost
		double monthlypayment = -1;//Variable for the monthly payment
		double loanperiod=-1;//Variable for the loan period
		double totalinterest;// Variable to for the total amount of interest
		int choice;// Variable for choosing what you want to be calculated, monthly payment, loan period or cost.
		
		Scanner keyboard = new Scanner (System.in);
			while(rate<1)
			{
				System.out.printf("Welcome to the finance program please enter an interest rate from 0 to 100 in a double/integer format:");
				String ratestring = keyboard.nextLine();
				rate= Double.parseDouble(ratestring);
					if(rate>100)
						rate=0;
		    // creates a scanner that takes user input for the interest rate.
			}
		System.out.println("What would you like to calculate?" +
								"\n press 1 for the cost of the item"+
								"\n press 2 for monthly payment"+
								"\n press 3 for loan period");
		
		String choicestring=keyboard.nextLine();
		choice=Integer.parseInt(choicestring);
				// uses Int choice to decide what you need calculated depending on numbers 1-3.
			if(choice==1)
			{
				System.out.println("Enter a postive value for monthly payments:");
			
					while(monthlypayment<0)
					{
						String monthlystring=keyboard.nextLine();
						monthlypayment= Double.parseDouble(monthlystring);
						// takes input for monthlypayment and makes sure it's positive.
					}
					
				System.out.println("Enter a postive value for loan period:");
					
					while(loanperiod<0)
					{
						String loanstring=keyboard.nextLine();
						loanperiod= Double.parseDouble(loanstring);
						// takes input for loanperiod and makes sure it's positive.	
					}
				
				cost= (1200*monthlypayment*(1-Math.pow((1+(rate/1200)), (-12*loanperiod)))/rate);	
				System.out.println("The cost is: " + cost);
				// calculates cost and prints it out
			}
			if(choice==2)
			{
				System.out.println("Enter a postive value for the cost:");
			
					while(cost<0)
					{
						String coststring=keyboard.nextLine();
						cost= Double.parseDouble(coststring);
						// takes input for cost and makes sure it's positive.	
					}
					
				System.out.println("Enter a postive value for loan period:");
					
					while(loanperiod<0)
					{
						String loanstring=keyboard.nextLine();
						loanperiod= Double.parseDouble(loanstring);
						// takes input for loanperiod and makes sure it's positive.
					}
					
				monthlypayment=(rate*cost)/(1200*(1-Math.pow((1+(rate/1200)), (-12*loanperiod))));
				System.out.println("The monthly payment is: " + monthlypayment);
				// calculates monthlypayment and prints it out
			}
			if(choice==3)
			{
				while(loanperiod==-1)
				{
					System.out.println("Enter a postive value for the cost:");
			
						while(cost<0)
						{
							String coststring=keyboard.nextLine();
							cost= Double.parseDouble(coststring);
							// takes input for loanperiod and makes sure it's positive.
						}
						
						System.out.println("Enter a postive value for monthly payments:");
					
						while(monthlypayment<0)
						{
							String monthlystring=keyboard.nextLine();
							monthlypayment= Double.parseDouble(monthlystring);
							// takes input for monthlyperiod and makes sure it's positive.
						}
							if(rate>=(1200*monthlypayment)/cost)
							{
								System.out.println("Please enter the values of a proper loan!");
								loanperiod=-1;
								cost=-1;
								monthlypayment=-1;
								// makes sure that it's a proper loan.
							}
								else
								{
									loanperiod=Math.log(1-((rate*cost)/(1200*monthlypayment)))/(-12*Math.log(1+(rate/1200)));
									System.out.println("The loan period is: " + loanperiod);
									// loanperiod is calculated and printed out.
								}
								
				}
							
						
			}
					
				
			
			totalinterest=12*monthlypayment*loanperiod-cost;
			// finds total interest
			String interestamount = null;
				if(totalinterest>cost)
					interestamount=" exceeds the cost of the item.";
				if(totalinterest<cost)
					interestamount=" is less than the cost of the item.";
				if(totalinterest==cost)
					interestamount=" is equivalent to the cost of the item.";
			
			System.out.println("The total amount of interest is " + totalinterest + " and it" + interestamount);
				//Checks the total interest vs the cost of the item and displays it.
					
			
				
	
		

	}

}
