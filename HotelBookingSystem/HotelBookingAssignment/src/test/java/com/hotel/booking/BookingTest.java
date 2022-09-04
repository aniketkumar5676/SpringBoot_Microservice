package com.hotel.booking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class BookingTest {

	
	private Booking b = new Booking();
	@Test
	void bookHotel() {
		
		assertEquals(0,b.bookHotel("Delhi", 5,"user001"));

		
	}
	


}
