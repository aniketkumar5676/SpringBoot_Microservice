package com.hotel.booking;

import java.util.Random;

public class HolidayInnHotel implements Hotel {

	String HotelName = "Holiday Inn";
	int HotelRoom;
	long Hotelroomprice = 6000;

	public void hotelName() {

		System.out.print("Holiday Inn\n");

	}

	public int hotelRoom() {
		return new Random().nextInt(0, 8);

	}


	public long hotelRoomPrice() {
		return Hotelroomprice;

	}

	public void hotelFacilities() {

		System.out.println("\n\t\t\tFacilities: ( Breakfast and Dinner, Wifi Campus, All AC Rooms, Airport Drop and Pickup )");
	
	}

}
