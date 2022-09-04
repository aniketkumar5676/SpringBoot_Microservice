package com.hotel.booking;

public class CommonHotel {

	void hotelName(Hotel ht) {
		ht.hotelName();
	}

	int checkRoomAvailability(Hotel ht) {
		return ht.hotelRoom();

	}

	long hotelRoomPrice(Hotel ht) {
		return ht.hotelRoomPrice();
	}
	
    void hotelFacilities(Hotel ht) {
		ht.hotelFacilities();
	}

}
