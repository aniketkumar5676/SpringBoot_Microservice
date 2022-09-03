package com.schoollibrary.system;

/*
 *  Created by Aniket
 */




import java.text.ParseException;

public class SchoolLibrary {

	public static void main(String[] args) throws ParseException {

		System.out.println("\n********************************************************");
		System.out.println("*                School Library System                 *");
		System.out.println("********************************************************");

		while (true) {

			System.out.println("\n\n\tWelcome,");
			System.out.println("\n\n\tLogin as User or Admin, (admin and admin is default Admin credentials)");

			Login lg = new Login();

			CheckLogin cl = new CheckLogin();
			cl.setId(lg.user);
			cl.setPassword(lg.password);

			/* admin and admin is default Admin credentials */

			switch (cl.check()) {
			case 1: {
				Admin ad = new Admin(cl.getId());
				ad.adminAccess();

				break;
			}
			case 2: {

				System.out
						.println("\n\tCurrently No Student Database is Present,\n\tLogin with Admin credentials to create..");

				break;
			}
			default: {
				System.out.println("\n\tEnter Valid Details");
				break;
			}
			}

		}

	}

}
