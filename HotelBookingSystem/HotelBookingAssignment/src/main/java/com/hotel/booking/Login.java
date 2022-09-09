package com.hotel.booking;

import java.util.Scanner;
import java.util.Set;

public class Login extends UserData {

	int found = 0;
	Integer k;

	void loginUserDetails() {

		new UserData();
		Scanner sc = new Scanner(System.in);

		int i = 5;

		while (i > 0) {
			System.out.print("\n\n\t\t\tEnter User Id (Try user001): ");
			String input = sc.next();

			Set<Integer> set = userid.keySet();
			for (Integer k : set) {

				if (userid.get(k).equalsIgnoreCase(input)) {
					this.k = k;
					this.found = 1;
					break;
				}

			}

			if (this.found == 1) {
				new Loading();
				UserPortal up = new UserPortal();
				up.userMenu(k);

			} else {
				i--;
				System.err.print("\n\t\t\tWrong User Id Try Again... ");
				if (i > 0) {
					System.out.print("\n\t\t\tOnly " + i + " attempts remaining..");
				} else {
					System.out.print("\n\t\t\tToo many Wrong Attempt.. System Terminating..");
					new Loading();
					System.exit(1);
				}

			}

			if (found == 1) {
				System.exit(1);
			}

		}

	}

}
