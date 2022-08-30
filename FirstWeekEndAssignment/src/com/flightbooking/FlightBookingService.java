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
	        				
	        			String Flightno=bk.checkingFlights().toUpperCase();
	        			
	        			
	        			switch(Flightno)
	        			{
	        			  
		        			case(VISTARA_FLIGHT_NO):{
		        				Flight vs=new Flight(origin,destination,name,Flightno,"Vistara",VISTARA_SEAT);
		        				VISTARA_SEAT=vs.bookingFlight();
		        				break;
	    				        				
		        			}
		        			
	                    	case(INDIGO_FLIGHT_NO):{
		        				
	                    		Flight vs=new Flight(origin,destination,name,Flightno,"IndiGo",INDIGO_SEAT);
		        				INDIGO_SEAT=vs.bookingFlight();
		        				break;
		        			}
	                    	
	                    	case(GOAIR_FLIGHT_NO):{
		        				
	                    		Flight vs=new Flight(origin,destination,name,Flightno,"Go Air",GOAIR_SEAT);
		        				GOAIR_SEAT=vs.bookingFlight();
		        				break;
		        			}
	                    	
	                    	case(AIRINDIA_FLIGHT_NO):{
		        				
	                    		Flight vs=new Flight(origin,destination,name,Flightno,"Air India",AIRINDIA_SEAT);
		        				AIRINDIA_SEAT=vs.bookingFlight();
		        				break;
		        			}
	                    	default:{
	                    		System.out.println("Wrong Flight No");
	                    		break;
	                    	}
	        				
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



	
