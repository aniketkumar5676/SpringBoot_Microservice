package com.hotel.booking;

import java.util.Random;

public class PridePlazaHotel implements Hotel {

	String HotelName = "Pride Plaza Hotel";
	int HotelRoom;
	long Hotelroomprice = 10000;

	public void hotelName() {

		System.out.print("Pride Plaza\n");

	}

	public int hotelRoom() {
		return new Random().nextInt(0, 8);

	}

	public long hotelRoomPrice() {
		return Hotelroomprice;

	}

	public void hotelFacilities() {

		System.out.println(
				"\n\t\t\tFacilities: ( Breakfast only, Wifi Campus, Airport Drop and Pickup, Swimming Pool, Bar, Spa )");

	}

}
