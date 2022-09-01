package com.flightbooking;

import java.util.Scanner;

class BookTicket {

	String origin;
	String destination;
	String flightno;
	int VISTARA_SEAT, INDIGO_SEAT, GOAIR_SEAT, AIRINDIA_SEAT;

	BookTicket() {

	}

	BookTicket(String origin, String destination) {

		this.origin = origin;
		this.destination = destination;

	}

	BookTicket(String origin, String destination, int VISTARA_SEAT, int INDIGO_SEAT, int GOAIR_SEAT,
			int AIRINDIA_SEAT) {

		this.origin = origin;
		this.destination = destination;
		this.VISTARA_SEAT = VISTARA_SEAT;
		this.INDIGO_SEAT = INDIGO_SEAT;
		this.GOAIR_SEAT = GOAIR_SEAT;
		this.AIRINDIA_SEAT = AIRINDIA_SEAT;

	}

	String checkingFlights() {

		System.out.println("\n We have found some flights from your Origin: " + this.origin.toUpperCase()
				+ " and Destination: " + this.destination.toUpperCase());

		System.out.println("\nFlight 563A: Vistara            Time : 4:00" + "    Available Seats =  " + VISTARA_SEAT);
		System.out.println("Flight 453E: Indigo             Time : 10:00" + "   Available Seats =  " + INDIGO_SEAT);
		System.out.println("Flight 234E: GoAir              Time : 16:00" + "   Available Seats =  " + GOAIR_SEAT);
		System.out.println(
				"Flight 43RF: AirIndia           Time : 21:00" + "   Available Seats =  " + AIRINDIA_SEAT + "\n");

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Flight Number (Example:563A) :  ");
		this.flightno = sc.next();
		return flightno;

	}

}
