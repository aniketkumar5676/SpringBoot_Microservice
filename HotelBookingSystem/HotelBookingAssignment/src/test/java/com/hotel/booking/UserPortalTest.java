package com.hotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class UserPortalTest {

	private UserPortal up=new UserPortal();
	@Test
	void UserPortal() throws IOException {
		assertEquals(1,up.userMenu(1));
	
	}

}
