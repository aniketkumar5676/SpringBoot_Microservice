package com.hotel.booking;

import java.util.Random;
import java.util.Scanner;

public class Booking {

	String location;
	int days;
	String Userid;
	String option;

	int bookHotel(String location, int days, String Userid) {
		this.location = location;
		this.days = days;
		this.Userid = Userid;

		Scanner sc = new Scanner(System.in);
		BookConfirm bc=	new BookConfirm();

		
		System.out.println("\n\t\t\t*********************************************************");
		System.out.println("\t\t\t------We Have Found Some Hotels For You At " + location + " -------");
		System.out.println("\t\t\t*********************************************************");

		CommonHotel ch = new CommonHotel();

		System.out.println("\n\t\t\t1.Radission Blu");
		ch.hotelFacilities(new RadissonBluHotel());
		System.out.println("\t\t\t(Per Night Cost: Rs " + ch.hotelRoomPrice(new RadissonBluHotel()) + ")");
		System.out.println("\t\t\t(Total cost of " + days + " days and Nights : Rs "
				+ ch.hotelRoomPrice(new RadissonBluHotel()) * days + ")");
	//	System.out.println("\t\t\t(Availability of" + " Rooms : " + (Radissonroom = new Random().nextInt(0, 4)) + ")");

	

		System.out.println("\n\t\t\t2.Holiday Inn");
		ch.hotelFacilities(new HolidayInnHotel());
		System.out.println("\t\t\t(Per Night Cost: Rs " + ch.hotelRoomPrice(new HolidayInnHotel()) + ")");
		System.out.println("\t\t\t(Total cost of " + days + " days and Nights : Rs "
				+ ch.hotelRoomPrice(new HolidayInnHotel()) * days + ")");
		//System.out.println("\t\t\t(Availability of" + " Rooms : " + (Holidayroom = new Random().nextInt(0, 4)) + ")");

		

		System.out.println("\n\t\t\t3.Taj Palace");
		ch.hotelFacilities(new TajPalaceHotel());
		System.out.println("\t\t\t(Per Night Cost: Rs " + ch.hotelRoomPrice(new TajPalaceHotel()) + ")");
		System.out.println("\t\t\t(Total cost of " + days + " days and Nights : Rs "
				+ ch.hotelRoomPrice(new TajPalaceHotel()) * days + ")");
		//System.out.println("\t\t\t(Availability of" + " Rooms : " + (Tajroom = new Random().nextInt(0, 4)) + ")");

	

		System.out.println("\n\t\t\t4.Ambassador Hotel");
		ch.hotelFacilities(new AmbassadorHotel());
		System.out.println("\t\t\t(Per Night Cost: Rs " + ch.hotelRoomPrice(new AmbassadorHotel()) + ")");
		System.out.println("\t\t\t(Total cost of " + days + " days and Nights : Rs "
				+ ch.hotelRoomPrice(new AmbassadorHotel()) * days + ")");
	//	System.out.println("\t\t\t(Availability of" + " Rooms : " + (Ambasroom = new Random().nextInt(0, 4)) + ")");

		

		System.out.println("\n\t\t\t5.Pride Plaza Hotel");
		ch.hotelFacilities(new PridePlazaHotel());
		System.out.println("\t\t\t(Per Night Cost: Rs " + ch.hotelRoomPrice(new PridePlazaHotel()) + ")");
		System.out.println("\t\t\t(Total cost of " + days + " days and Nights : Rs "
				+ ch.hotelRoomPrice(new PridePlazaHotel()) * days + ")");
	//	System.out.println("\t\t\t(Availability of" + " Rooms : " + (Prideroom = new Random().nextInt(0, 4)) + ")");

		
		while(true) {
		System.out.print("\n\t\t\tSelect Hotel to Book:-");

		while (true) {
			option = sc.next();
			try {
				Integer.parseInt(option);
				break;

			} catch (Exception e) {
				System.err.print("\n\t\t\tTry to chooose correct option :");
				continue;
			}
		}
		
		

		switch (Integer.parseInt(option)) {

		case 1: {
			
			bc.confirmBooking(new RadissonBluHotel(),Userid,location,days);
			break;
		}

		case 2: {

			bc.confirmBooking(new HolidayInnHotel(),Userid,location,days);

			break;

		}

		case 3: {

			bc.confirmBooking(new AmbassadorHotel(),Userid,location,days);

			break;

		}
		case 4: {
			bc.confirmBooking(new RadissonBluHotel(),Userid,location,days);

			break;

		}
		case 5: {

			bc.confirmBooking(new PridePlazaHotel(),Userid,location,days);

			break;

		}
		default: {
			System.err.print("\n\t\t\tTry to chooose correct option :");
			continue;

		}

		}

		return 0;

	}
  }

}
