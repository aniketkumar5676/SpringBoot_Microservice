package com.flightbooking;

import java.util.Scanner;

class Flight extends BookTicket {

	String origin;
	String destination, FlightName;
	String name, city;
	String yes;
	String PassengerName, confirm, FlightNo;
	int age, seat;

	Flight(String origin, String destination, String name, String FlightNo, String FlightName, int seat) {

		this.origin = origin;
		this.destination = destination;
		this.name = name;
		this.FlightNo = FlightNo;
		this.seat = seat;
		this.FlightName = FlightName;

	}

	int bookingFlight() {

		System.out.println(
				"You have selected " + FlightName.toUpperCase() + " Flight of Flight No: " + FlightNo.toUpperCase());
		System.out.println("\nAlert: Only " + seat + " seat available for Flight No " + FlightNo.toUpperCase()
				+ " on this route.");

		if (seat == 0) {
			System.out.println("Sorry!! No Seats Available");
			System.out.println("\nCheck other Option:");
			BookTicket bc = new BookTicket(origin, destination);

		} else {

			Scanner sc = new Scanner(System.in);

			System.out.println("\n*****Booking Detailes to be Entered*****");

			System.out.print("Enter Passenger Name: ");
			PassengerName = sc.nextLine();
			System.out.print("Enter Passenger City: ");
			city = sc.nextLine();

			// Error handling on Age

			while (true) {
				try {
					System.out.print("\nEnter Passenger Age (Must be 18+): ");
					age = sc.nextInt();

					if (age < 18) {

						throw new AgeErrorHandle("Notice : Age Must be greater than 18.");
					}

					break;
				} catch (AgeErrorHandle e) {

					System.out.print(e.getMessage());

				}
			}

			System.out.println("Origin City: " + origin);
			System.out.println("Destination City: " + destination);

			System.out.print("\nConfirm to Book Ticket yes/no:");
			confirm = sc.next().toLowerCase();

			if ("yes".equalsIgnoreCase(confirm)) {

				seat--;

				System.out.println("\n\tWe are generating Ticket for your Journey. \n\tPlease Wait\t");
				System.out.print("\t*");

				for (int i = 0; i < 5; i++) {

					System.out.print("*");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.print(e.getMessage());
					}

				}

				System.out.println("\n\n" + FlightName + " Ticket Booked Successfully");

				BookingHistory bh = new BookingHistory();

				// Setting data in Encapsulation to secure passenger info

				bh.setPassengerName(PassengerName);
				bh.setAge(age);
				bh.setDest(destination);
				bh.setOrigin(origin);
				bh.setFlightName(FlightName);
				bh.setFlightNo(FlightNo);

				// Booking Output //fetching data from Encapsulation

				System.out.println("\n\nYour Booked Ticket of Flight " + bh.getFlightName().toUpperCase() + " : "
						+ bh.getFlightNo().toUpperCase() + " is:");
				System.out.println("Passenger Name :           " + bh.getPassengerName().toUpperCase());
				System.out.println("Passenger age :            " + bh.getAge());
				System.out.println("Destination City :         " + bh.getDest().toUpperCase());
				System.out.println("Origin City :              " + bh.getOrigin().toUpperCase());
				System.out.println("\nHave A Nice Journey!!!");

				System.out.print("Go to Main Menu to Book Another Ticket: yes/no? :  ");
				yes = sc.next();

				if ("yes".equalsIgnoreCase(yes)) {

					// call main class loop automatically
				} else {

					ThankYou message = new ThankYou();
					message.exit();

				}

			} else {
				System.out.println("Booking cancelled");

			}

		}
		return seat;

	}

}