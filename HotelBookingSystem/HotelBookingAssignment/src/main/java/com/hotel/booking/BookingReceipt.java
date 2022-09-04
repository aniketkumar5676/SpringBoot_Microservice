package com.hotel.booking;

import java.util.Random;

public class BookingReceipt extends UserData {

	int position, days, room;
	String location;

	public void bookingReceipt(Hotel hotel, int position, int days, int room, String location) {

		CommonHotel ch = new CommonHotel();
		String lettersandnumbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer sb = new StringBuffer();
		String BookingId = "";

		// Generates Random ID
		for (int a = 0; a < 12; a++) {
			Random rndchar = new Random();
			int character = rndchar.nextInt(lettersandnumbers.length());
			sb.append(Character.toString(lettersandnumbers.charAt(character)));
			BookingId = sb.toString();
		}

		System.out.println("\n\t\t\t*********************************************************");
		System.out.println("\t\t\t--------            Booking Receipt              -------*");
		System.out.println("\t\t\t*********************************************************");
		
		System.out.print("\n\t\t\tBooking Id:- " +BookingId);

		System.out.print("\n\t\t\tUser Id:- " +userid.get(position));
		System.out.print("\n\t\t\tUser Name:- " +username.get(position));
		System.out.print("\n\t\t\tUser email:- " +useremail.get(position));
		System.out.print("\n\t\t\tHotel Name:- ");
		ch.hotelName(hotel);
		System.out.print("\n\t\t\tHotel Place:- " + location );
		System.out.print("\n\t\t\tNo of Days Staying:- " + days );
		System.out.print("\n\t\t\tNo of Room Booked:- " + room );
		System.out.print("\n\t\t\tPayment Made:- Rs " +days*ch.hotelRoomPrice(hotel));
		

		
	}

}
