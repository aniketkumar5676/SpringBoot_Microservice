/*
 ** Created By Aniket Kumar
 * Date 28/08/2022
 ** 
 */

package com.flightbooking;

import java.util.Scanner;






public class FlightBookingService {
	
	public static void main(String[] a) {
 
	         	int VISTARA_SEAT=6,INDIGO_SEAT=5,GOAIR_SEAT=9,AIRINDIA_SEAT=4;
	         	final String VISTARA_FLIGHT_NO = "563A";
	         	final String INDIGO_FLIGHT_NO = "453E";
	         	final String GOAIR_FLIGHT_NO = "234E";
	         	final String AIRINDIA_FLIGHT_NO = "43RF";

         	
	         	
	         	
				System.out.println("\n********************************************************");
				System.out.println("*                                                      *");
				System.out.println("*    ✈️ Welcome to Aarohi Flight Booking Service ✈️    *");
				System.out.println("*                                                      *");
				System.out.println("********************************************************");

				System.out.print("\n\tEnter Your Name: ");
				Scanner sc = new Scanner(System.in);
		        String name=sc.nextLine();
		 
				System.out.println("\n\n\tWelcome Sir/Madam, " + name.toUpperCase());
				System.out.println("\n<-- I hope you are well, staying safe and healthy, During this Pandemic.-->");
					
				
		   while(true)   {
					 
				System.out.println("\n\tChoose from below available option:-->");
				System.out.println("\n\t1.Book tickets: (Type 1)");
				System.out.println("\t2.Exit: (Type 2)");
				
				System.out.print("\nSelect Desired Option by entering Index number Ex '1' : ");
		        String option=sc.nextLine();
		        
          
          while(true){    
            	
        	if ("1".equals(option)||"2".equals(option))
            {
	
        		if ("1".equals(option))
        		{
	        			
        		    	//Adding User for Flight Service
        			
	        			System.out.print("\n\tEnter Origin: ");
	        			String origin=sc.nextLine();
	        			        			
	        			System.out.print("\tEnter Destination: ");
	        			String destination=sc.nextLine();
	        			
	        			BookTicket bk = new BookTicket(origin,destination,VISTARA_SEAT,INDIGO_SEAT,GOAIR_SEAT,AIRINDIA_SEAT);
	        			
	        			if( bk != null)
	        			{
	        				
	        			String Flightno=bk.checkingFlights();
	        			
	        				        			
	        			//checking flight no
	        			
	        			if (VISTARA_FLIGHT_NO.equalsIgnoreCase(Flightno)) 
	        			{
	        				Flight vs=new Flight(origin,destination,name,Flightno,"Vistara",VISTARA_SEAT);
	        				VISTARA_SEAT=vs.bookingFlight();
	        						
	        			}
	        			
	        			if (INDIGO_FLIGHT_NO.equalsIgnoreCase(Flightno)) 
	        			{
	        				Flight vs=new Flight(origin,destination,name,Flightno,"IndiGo",INDIGO_SEAT);
	        				INDIGO_SEAT=vs.bookingFlight();
	        						
	        			}
	        			
	        			if (GOAIR_FLIGHT_NO.equalsIgnoreCase(Flightno)) 
	        			{
	        				Flight vs=new Flight(origin,destination,name,Flightno,"Go Air",GOAIR_SEAT);
	        				GOAIR_SEAT=vs.bookingFlight();
	        						
	        			}
	        				        			
	        			if (AIRINDIA_FLIGHT_NO.equalsIgnoreCase(Flightno)) 
	        			{
	        				Flight vs=new Flight(origin,destination,name,Flightno,"Air India",AIRINDIA_SEAT);
	        				AIRINDIA_SEAT=vs.bookingFlight();
	        			        				        						
	        			}
        			
	        		}
	        			        				        			
        			    break;    			
        		}
        		
	        		  if ("2".equals(option))
	        		  {        
	        			 ThankYou message = new ThankYou();
	     			     message.exit();
    		          }
	
	            }else
	                 {
	             	   System.out.print("Invalid Input. Try Again, (Type in between 1 to 3): ");
	                   option=sc.nextLine();
	            
	                 }
	            
	            
	         }
	        
	     }  
     
       
	}
	
}




class BookTicket{
	
	String origin;
	String destination;
	String flightno;
	int VISTARA_SEAT,INDIGO_SEAT,GOAIR_SEAT,AIRINDIA_SEAT;
	
	BookTicket(){
		
	}
	
    BookTicket(String origin,String destination){
		this.origin=origin;
		this.destination=destination;
	}


	BookTicket(String origin,String destination,int VISTARA_SEAT,int INDIGO_SEAT,int GOAIR_SEAT,int AIRINDIA_SEAT){
		
		this.origin=origin;
		this.destination=destination;
		this.VISTARA_SEAT=VISTARA_SEAT;
		this.INDIGO_SEAT=INDIGO_SEAT;
		this.GOAIR_SEAT=GOAIR_SEAT;
		this.AIRINDIA_SEAT=AIRINDIA_SEAT;
	}
	
	String checkingFlights(){
		
			System.out.println("\n We have found some flights from your Origin: " + this.origin.toUpperCase() +" and Destination: "+this.destination.toUpperCase());
	
			System.out.println("\nFlight 563A: Vistara            Time : 4:00"+ "    Available Seats =  " + VISTARA_SEAT);
			System.out.println("Flight 453E: Indigo             Time : 10:00" + "   Available Seats =  " + INDIGO_SEAT);
			System.out.println("Flight 234E: GoAir              Time : 16:00" + "   Available Seats =  " + GOAIR_SEAT);
			System.out.println("Flight 43RF: AirIndia           Time : 21:00" + "   Available Seats =  " + AIRINDIA_SEAT+"\n");
	
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Flight Number (Example:563A) :  ");
			this.flightno = sc.next();
		    return flightno;	
		    
	}
	
	
}


class Flight extends BookTicket {

	String origin;
	String destination,FlightName;
	String name,city;
	String yes;
	String PassengerName,confirm,FlightNo;
	int age,seat;

	Flight(String origin, String destination,String name,String FlightNo,String FlightName,int seat) {
		this.origin=origin;
		this.destination=destination;
		this.name=name;
		this.FlightNo=FlightNo;
		this.seat=seat;
		this.FlightName=FlightName;
	}
	
	int bookingFlight() {
		
		System.out.println("You have selected "+ FlightName.toUpperCase() +" Flight of Flight No: "+ FlightNo.toUpperCase());
		System.out.println("\nAlert: Only "+seat+" seat available for Flight No "+FlightNo.toUpperCase()+" on this route.");
		
		if(seat==0)
		{			
			System.out.println("Sorry!! No Seats Available");
			System.out.println("\nCheck other Option:");
			BookTicket bc = new BookTicket(origin,destination);
		
		}
		else {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("\n*****Booking Detailes to be Entered*****");
		
		System.out.print("Enter Passenger Name: ");
		PassengerName=sc.nextLine();
		System.out.print("Enter Passenger City: ");
		city=sc.nextLine();
	
		
		while(true) {
		try {
			System.out.print("\nEnter Passenger Age (Must be 18+): ");
			age=sc.nextInt();
			
		   	if(age<18) {
		   		
				throw new AgeErrorHandle("Notice : Age Must be greater than 18.");
		   	}
		   	
		   	break;
		}catch(AgeErrorHandle e){
					
				System.out.print(e.getMessage());

	 	}	  }
		
		
		System.out.println("Origin City: "+origin);
		System.out.println("Destination City: "+destination);

		
		System.out.print("\nConfirm to Book Ticket yes/no:");
		confirm=sc.next().toLowerCase();

		if("yes".equalsIgnoreCase(confirm))
		{
			
			seat--;
			
			System.out.println("\n\n"+FlightName +" Ticket Booked Successfully");
			
			
			BookingHistory bh=new BookingHistory();	
			
			bh.setPassengerName(PassengerName);
			bh.setAge(age);
			bh.setDest(destination);
			bh.setOrigin(origin);
			bh.setFlightName(FlightName);
			bh.setFlightNo(FlightNo);

			
			//Booking Output

			System.out.println("\n\nYour Booked Ticket of Flight " + bh.getFlightName().toUpperCase() + " : "+bh.getFlightNo().toUpperCase()+" is:");
			System.out.println("Passenger Name :           " + bh.getPassengerName().toUpperCase());
			System.out.println("Passenger age :            " + bh.getAge());
			System.out.println("Destination City :         " + bh.getDest().toUpperCase());
			System.out.println("Origin City :              " + bh.getOrigin().toUpperCase());
			System.out.println("\nHave A Nice Journey!!!");


			
			System.out.print("Go to Main Menu to Book Another Ticket: yes/no? :  ");
			yes=sc.next();
				
			if ("yes".equalsIgnoreCase(yes)){
											
			//call main class loop automatically
			 }
			else{
				
				ThankYou message = new ThankYou();
				message.exit();
				 
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
		private String destination;
		private String PassengerName,FlightName,FlightNo;
		private int age;
		
		
			public String getOrigin() {
				return origin;
			}
		
		
			public void setOrigin(String origin) {
				this.origin = origin;
			}
		
		
			public String getDest() {
				return destination;
			}
		
		
			public void setDest(String destination) {
				this.destination = destination;
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
			
			void exit() {
			    System.exit(1);		 	
			}
			
	}
	
