/*
 ** Created By Aniket Kumar
 * Date 28/08/2022
 ** 
 */

package com.flightbooking;

import java.util.*;

public class FlightBookingService {
	public static void main(String[] a) {

		
		System.out.println("\n\n*****✈️ Welcome to Aarohi Flight Booking Service ✈️*****");
		
		System.out.print("\nEnter Your Name: ");
		Scanner sc = new Scanner(System.in);
        String name=sc.nextLine();
 
        
    
    	 
		System.out.println("\n\nWelcome sir, " + name);
		System.out.println("\n I hope you are well, staying safe and healthy, During this Pandemic.");
		
		int Vseat=6,Iseat=5,Gseat=9,Aseat=4;

		
		for(int j =0; j >=0 ;j++)   {
			 
		System.out.println("\nChoose from below available option:-->");
		System.out.println("\n1.Book tickets: (Type 1)");
		System.out.println("2.Exit: (Type 2)");
		
		System.out.print("\nSelect Desired Option by entering Index number Ex '1' : ");
        String opt=sc.nextLine();
        
          
            while(true)    {    
        	if (opt.equals("1") ||opt.equals("2"))
            {
	
        		if (opt.equals("1"))
        		{
        			
        			System.out.print("Enter Origin: ");
        			String origin=sc.nextLine();
        			        			
        			System.out.print("Enter Destination: ");
        			String dest=sc.nextLine();
        			
        			BookTicket bk = new BookTicket(origin,dest,Vseat,Iseat,Gseat,Aseat);
        			String Flightno=bk.checkingFlights();
        			
        			if (Flightno.equals("563A")||Flightno.equals("563a")) 
        			{
        				Flight vs=new Flight(origin,dest,name,Flightno,"Vistara",Vseat);
        				Vseat=vs.bookingFlight();
        						
        			}
        			
        			if (Flightno.equals("453E")||Flightno.equals("453e")) 
        			{
        				Flight vs=new Flight(origin,dest,name,Flightno,"IndiGo",Iseat);
        				Iseat=vs.bookingFlight();
        						
        			}
        			
        			if (Flightno.equals("234E")||Flightno.equals("234e")) 
        			{
        				Flight vs=new Flight(origin,dest,name,Flightno,"Go Air",Gseat);
        				Gseat=vs.bookingFlight();
        						
        			}
        			
        			if (Flightno.equals("43RF")||Flightno.equals("43rf")) 
        			{
        				Flight vs=new Flight(origin,dest,name,Flightno,"Air India",Aseat);
        				Aseat=vs.bookingFlight();
        			        				        						
        			}
        			
        			    break;    			
        		}
        		
        		if (opt.equals("2"))
        		{        
        			
        			 ThankYou ty = new ThankYou();
                     System.exit(1);        		}

            }
             else
               {
           
            	 System.out.print("Invalid Input. Try Again, (Type in between 1 to 3): ");
                 opt=sc.nextLine();
            
               }
            
            
        }
        
     }  
        
       
	}
	
}




class BookTicket{
	
	String origin;
	String dest;
	String flightno;
	int Vseat,Iseat,Gseat,Aseat;
	
	BookTicket(){
		
	}
    BookTicket(String origin,String dest){
		this.origin=origin;
		this.dest=dest;
	}


	BookTicket(String origin,String dest,int Vseat,int Iseat,int Gseat,int Aseat){
		
		this.origin=origin;
		this.dest=dest;
		this.Vseat=Vseat;
		this.Iseat=Iseat;
		this.Gseat=Gseat;
		this.Aseat=Aseat;
	}
	
	String checkingFlights(){
		
		System.out.println("\n We have found some flights from your Origin: " + this.origin +" and Destination: "+this.dest);

		System.out.println("\nFlight 563A: Vistara            Time : 4:00"
				+ "    Available Seats =  " + Vseat );
		System.out.println("Flight 453E: Indigo             Time : 10:00"
				+ "   Available Seats =  " + Iseat );
		System.out.println("Flight 234E: GoAir              Time : 16:00"
				+ "   Available Seats =  " + Gseat );
		System.out.println("Flight 43RF: AirIndia           Time : 21:00"
				+ "   Available Seats =  " + Aseat+"\n" );

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Flight Number (Example:563A) :  ");
		this.flightno = sc.next();
	    return flightno;	
	}
	
	
}


class Flight extends BookTicket {

	String origin;
	String dest,FlightName;
	String name,city;
	String yes1;
	String PassengerName,confirm,FlightNo;
	int age,seat;

	Flight(String origin, String dest,String name,String FlightNo,String FlightName,int seat) {
		this.origin=origin;
		this.dest=dest;
		this.name=name;
		this.FlightNo=FlightNo;
		this.seat=seat;
		this.FlightName=FlightName;
	}
	
	int bookingFlight() {
		
		System.out.println("You have selected "+ FlightName +" Flight of Flight No:"+ FlightNo);
		System.out.println("\nAlert: Only "+seat+" seat available for Flight No "+FlightNo+" on this route.");
		
		if(seat==0)
		{			
			System.out.println("Sorry!! No Seats Available");
			System.out.println("\nCheck other Option:");
			BookTicket bc = new BookTicket(origin,dest);
		
		}
		else {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Passenger Name: ");
		PassengerName=sc.nextLine();
		System.out.print("Enter Passenger City: ");
		city=sc.nextLine();
		
		System.out.print("Enter Passenger Age: ");
		age=sc.nextInt();
		System.out.println("Origin City: "+origin);
		System.out.println("Destination City: "+dest);

		
		System.out.print("\nConfirm to Book Ticket yes/no:");
		confirm=sc.next().toLowerCase();

		if(confirm.equals("yes"))
		{
			
			seat--;
			
			System.out.println("\n\n"+FlightName +" Ticket Booked Successfully");
			
			BookingHistory bc=new BookingHistory();	
			bc.setPassengerName(PassengerName);
			bc.setAge(age);
			bc.setDest(dest);
			bc.setOrigin(origin);
			bc.setFlightName(FlightName);
			bc.setFlightNo(FlightNo);

			
		
			System.out.println("\n\nYour Booked Ticket of Flight " + bc.getFlightName() + " : "+bc.getFlightNo()+" is:");
			System.out.println("Passenger Name :           " + bc.getPassengerName());
			System.out.println("Passenger age :            " + bc.getAge());
			System.out.println("Destination City :         " + bc.getDest());
			System.out.println("Origin City :              " + bc.getOrigin() );
			System.out.println("\nHave A Nice Journey!!!");


			
			System.out.print("Go to Main Menu to Book Another Ticket: yes/no? :  ");
			yes1=sc.next();
			
				if (yes1.equals("yes"))
				{
										
				}
				else
				{
				 ThankYou ty = new ThankYou();
                  System.exit(1);		 
				}
			
			
												
		}
		else
		{
			System.out.println("Booking cancelled");

		}
		
		
	}
		return seat;	

	
		
    }
		
	
}

class BookingHistory{
	
	private String origin;
	private String dest;
	private String PassengerName,FlightName,FlightNo;
	private int age;
	
	
	BookingHistory(){
		
	}
	

	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDest() {
		return dest;
	}


	public void setDest(String dest) {
		this.dest = dest;
	}


	public String getPassengerName() {
		return PassengerName;
	}


	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}


	public String getFlightName() {
		return FlightName;
	}


	public void setFlightName(String flightName) {
		FlightName = flightName;
	}


	public String getFlightNo() {
		return FlightNo;
	}


	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}


	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	

}


class ThankYou{
	ThankYou()
	{
		System.out.println("\n\n ******✈️ Thank You for using our Service ✈️******");
	}
}

