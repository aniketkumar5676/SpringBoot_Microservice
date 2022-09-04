package com.hotel.booking;

import java.util.Random;

public class TajPalaceHotel implements Hotel {

	String HotelName = "Taj Palace";
	int HotelRoom;
	long Hotelroomprice = 12000;

	public void hotelName() {

		System.out.print("Taj Palace\n");

	}

	public int hotelRoom() {
		return new Random().nextInt(0, 8);

	}

	public long hotelRoomPrice() {
		return Hotelroomprice;

	}

	public void hotelFacilities() {

		System.out.println("\n\t\t\tFacilities: ( Breakfast and Dinner, All AC Room , Wifi Campus, Airport Drop and Pickup, Swimming Pool, Bar, Game Parlour )");

	}
}
