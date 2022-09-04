package com.hotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookConfirmTest {
	
	private BookConfirm bc =new BookConfirm();
	@Test
	void test() {
		
		assertEquals(1,bc.confirmBooking(new RadissonBluHotel(),"user001","Pat",2));
		
	}

}
