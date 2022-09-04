package com.hotel.booking;

import java.util.Random;

public class RadissonBluHotel implements Hotel {

	String HotelName = "Radisson Blu Hotel";
	int HotelRoom;
	long Hotelroomprice = 8000;

	public void hotelName() {

		System.out.print("Radission Blu\n");

	}

	public int hotelRoom() {
		return new Random().nextInt(0, 8);

	}

	public long hotelRoomPrice() {
		return Hotelroomprice;

	}

	public void hotelFacilities() {

		System.out
				.println("\n\t\t\tFacilities: ( Breakfast only, Wifi Campus, Airport Drop and Pickup, Swimming Pool )");

	}
}
