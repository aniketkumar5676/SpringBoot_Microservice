package com.hotel.booking;

import java.util.Scanner;

public class HotelBookingMain {

	public static void main(String[] args) {
		String option;
		System.out.println("\n\t\t\t*********************************************************");
		System.out.println("\t\t\t--------      Hotel Booking Application         -------*");
		System.out.println("\t\t\t*********************************************************");

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\tWelcome Guest,");
		Login lg = new Login();

		while (true) {

			System.out.println("\n\n\t\t\tOur Services to you:\n");
			System.out.println("\t\t\t1.Login to Book Hotels");
			System.out.println("\t\t\t2.Exit");

			System.out.print("\n\n\t\t\tChoose Option:");

			while (true) {
				option = sc.next();

				try {
					Integer.parseInt(option);
					break;

				} catch (Exception e) {
					System.err.print("\n\tTry to chooose correct option :");
					continue;
				}
			}

			switch (Integer.parseInt(option)) {

			case 1: {

				lg.loginUserDetails();

				break;

			}
			case 2: {
				System.out.print("\n\t\t\tThank You For Using Our Service.. System Terminating..");
    			new Loading();
                System.exit(1);
			}

			default: {

				System.err.print("\n\t\t\tWrong Input Try Again... ");
				break;
			}

			}
			break;
		}

	}

}
