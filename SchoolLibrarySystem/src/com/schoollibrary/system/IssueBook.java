package com.schoollibrary.system;

import java.time.LocalDate;
import java.util.Scanner;

public class IssueBook extends Admin {

	String name;
	String classname;
	String mobile;
	String date;

	IssueBook(String id) {
		super(id);
	}

	void issueBookName() {

		Scanner sc = new Scanner(System.in);
		LocalDate localDate = LocalDate.now();

		System.out.print("\n\tStudent Name: ");
		this.name = sc.next();
		System.out.print("\n\tStudent Class: ");
		this.classname = sc.next();
		System.out.print("\n\tStudent MobileNo: ");

		while (true) {
			
			this.mobile = sc.next();

			try {
				
				new validatePhoneNumber(mobile);
				
				break;
				// more code maybe update the database
			} catch (PhoneNotValidException pe) {
				// JOptionPane.showMessageDialog(null,"Please enter a valid phone number");
				System.err.println("Please enter a valid phone number");

			} 
			
		}
		
		this.date=String.valueOf(localDate);
		System.out.println("\n\tIssued Date: "+date);

	}

}
