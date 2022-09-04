package com.hotel.booking;

import java.util.Scanner;

public class UserPortal extends UserData {
	Integer position;
	String days, option;

	int userMenu(Integer position) {

		this.position = position;
		
		
		try (Scanner sc = new Scanner(System.in)) {
			Booking bk = new Booking();

			System.out.println("\n\t\t\t*********************************************************");
			System.out.println("\t\t\t*--------      User Portal to Book Hotels        -------*");
			System.out.println("\t\t\t*********************************************************");

			System.out.println("\n\tWelcome " + username.get(position) + ",");

			while (true) {
				
				System.out.println("\n\n\t\t\tOur Services to you:\n");
				System.out.println("\t\t\t1.Book Hotels");
				System.out.println("\t\t\t2.Your Profile");
				System.out.println("\t\t\t3.Logout");

				System.out.print("\n\n\t\t\tChoose Option:");
				
				while (true) {
					option = sc.next();

					try {
						Integer.parseInt(option);
						break;

					} catch (Exception e) {
						System.err.print("\n\t\t\tTry to Enter Correct Option :");
						continue;
					}
				}

				switch (Integer.parseInt(option)) {

				case 1: {

					System.out.print("\n\t\t\tEnter Location: ");
					String location = sc.next();
					System.out.print("\n\t\t\tEnter Days You want to Stay: ");

					while (true) {
						days = sc.next();

						try {
							Integer.parseInt(days);
							break;

						    } catch (Exception e) {
							System.err.print("\n\t\t\tTry to Enter Correct Days :");
							continue;
						}
					}

					new Loading();

					bk.bookHotel(location,Integer.parseInt(days), userid.get(position));

					break;

				}
				case 2: {
					
					new Profile(username.get(position),userphoneno.get(position),useremail.get(position),useraddress.get(position));
							
					continue;

					

				}
				
				case 3: {

					System.out.print("\n\t\t\tThank You For Using Our Service.. System Terminating..");
	    			new Loading();
	                System.exit(1);
					
					break;

				}

				default: {

					System.err.print("\n\t\t\tWrong Input Try Again... ");

					continue;
				}

				}
              break;
			}

		}

		return 1;

	}

}
