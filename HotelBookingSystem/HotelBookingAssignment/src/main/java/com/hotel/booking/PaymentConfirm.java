package com.hotel.booking;

import java.util.Scanner;

public class PaymentConfirm extends UserData {

	String useriddata, location, confirm;
	int days, room;
	int position;

	PaymentConfirm(Hotel hotel, String useriddata, String location, int days, int room) {

		this.useriddata = useriddata;
		this.days = days;
		this.location = location;
		this.room = room;

		CommonHotel ch = new CommonHotel();
		FindUserDetails fud = new FindUserDetails();
		Scanner sc = new Scanner(System.in);
		CommonPayment cp = new CommonPayment();
		BookingReceipt br = new BookingReceipt();

		System.out.println("\n\t\t\t*********************************************************");
		System.out.println("\t\t\t--------            Confirm Payment              -------*");
		System.out.println("\t\t\t*********************************************************");

		this.position = fud.findUserDetail(useriddata);

		System.out.print("\n\t\t\tUser Id:- " + useriddata);
		System.out.print("\n\t\t\tUser Name:- " + username.get(position));
		System.out.print("\n\t\t\tUser email:- " + useremail.get(position));
		System.out.print("\n\t\t\tHotel Name:- ");
		ch.hotelName(hotel);
		System.out.print("\n\t\t\tPayment of Rs:- " + days * ch.hotelRoomPrice(hotel));

		System.out.print("\n\t\t\tDo you want to make payment? Yes/No:- ");
		confirm = sc.next();

		if ("Yes".equalsIgnoreCase(confirm)) {

			System.out.print("\n\t\t\tPayment Methods : ");
			System.out.print("\n\t\t\t1.Credit card : ");
			System.out.print("\n\t\t\t2.Debit Card : ");

			while (true) {

				System.out.print("\n\n\t\t\tSelect Payment method: ");

				while (true) {
					confirm = sc.next();

					try {
						Integer.parseInt(confirm);
						break;

					} catch (Exception e) {
						System.err.print("\n\t\t\tTry to Enter Correct Option :");
						continue;
					}
				}

				switch (Integer.parseInt(confirm)) {

				case 1: {

					System.out.print("\n\t\t\tDoing Payment: ");
					new Loading();
					cp.payment(new CreditCard());
					
					System.out.print("\n\t\t\tGenerating Booking Id: ");
					new Loading();
					br.bookingReceipt(hotel, position, days, room, location);

					break;

				}
				case 2: {
					System.out.print("\n\t\t\tDoing Payment: ");
					new Loading();
					cp.payment(new DebitCard());
					
					System.out.print("\n\t\t\tGenerating Booking Id: ");
					new Loading();
					br.bookingReceipt(hotel, position, days, room, location);

					break;
				}

				default: {

					System.err.print("\n\t\t\tWrong Input Try Again... ");

					continue;
				}

				}
				break;
			}

		} else {
			System.out.println("\n\t\t\t Thank You For Using Our Service");
			System.exit(1);
		}

	}

}
