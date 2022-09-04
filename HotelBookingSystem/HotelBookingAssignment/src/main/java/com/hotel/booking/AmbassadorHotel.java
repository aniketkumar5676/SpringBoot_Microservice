package com.hotel.booking;

import java.util.Random;

public class AmbassadorHotel implements Hotel {

	String HotelName="Ambassador Hotel";
	int HotelRoom;
	long Hotelroomprice =8500;
	
	public void hotelName() {

		System.out.print("Ambassador Hotel\n");

	}

	public int hotelRoom() {
		return new Random().nextInt(0, 8);

	}


	public long hotelRoomPrice() {
		return Hotelroomprice;
		

	}

	
	public void hotelFacilities() {
		
		System.out.println("\n\t\t\tFacilities: ( Breakfast only, Wifi Campus, Airport Drop and Pickup, Swimming Pool , Free Tour Car)");

		
	}

}
