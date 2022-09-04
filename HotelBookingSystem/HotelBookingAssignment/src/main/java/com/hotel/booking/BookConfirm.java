package com.hotel.booking;

import java.util.Scanner;

public class BookConfirm {

	String userid, location, room, confirm;
	int days, availability;

	int confirmBooking(Hotel hotel, String userid, String location, int days) {

		this.userid = userid;
		this.location = location;
		this.days = days;

		CommonHotel ch = new CommonHotel();
		Scanner sc = new Scanner(System.in);

		System.out.println("\n\t\t\t*********************************************************");
		System.out.println("\t\t\t--------           Booking Confirm              -------*");
		System.out.println("\t\t\t*********************************************************");

		System.out.print("\n\t\t\tHotel Name:- ");
		ch.hotelName(hotel);

		ch.hotelFacilities(hotel);
		System.out.println("\t\t\t(Per Night Cost: Rs " + ch.hotelRoomPrice(hotel) + ")");
		System.out.println(
				"\t\t\t(Total cost of " + days + " days and Nights : Rs " + ch.hotelRoomPrice(hotel) * days + ")");

		availability = ch.checkRoomAvailability(hotel);

		while (true) {

			while (true) {
				System.out.print("\n\t\t\tEnter No of Rooms you want to Book: ");
				room = sc.next();
				System.out.print("\n\t\t\tChecking Availability: ");
				new Loading();

				try {
					Integer.parseInt(room);
					break;

				} catch (Exception e) {
					System.err.print("\n\t\t\tEnter Correct No of Room\n ");
					continue;
				}
			}

			if (availability == 0) {
				System.out.println("\n\t\t\tSorry!! All Rooms in this Hotel are \n " + Constant.OCCUPIED);
				break;
			}

			if (Integer.parseInt(room) > availability) {
				System.out.println("\n\t\t\tSorry!! Only " + availability + " Rooms in this Hotel and rest are \n "
						+ Constant.OCCUPIED);
				continue;
			}

			if (Integer.parseInt(room) <= availability) {
				System.out.print("\n\t\t\t" + availability + " Rooms in this Hotel are " + Constant.AVAILABLE
						+ " continue to book " + Integer.parseInt(room) + " Room? Yes/No :");
				confirm = sc.next();

				if ("Yes".equalsIgnoreCase(confirm)) {

					new PaymentConfirm(hotel, userid, location, days, Integer.parseInt(room));

				} else {
					System.out.println("\n\t\t\t Thank You For Using Our Service");
					System.exit(1);
				}

			}
			break;
		}

		return 1;
	}

}
