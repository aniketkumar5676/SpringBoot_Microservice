package com.hotel.booking;

public class Loading {
	
	Loading() {
		
		System.out.print("\t\t\t");
		for (int j = 0; j < 3; j++) {
			System.out.print("*");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.print(e.getMessage());
			}

		}
	}

}
