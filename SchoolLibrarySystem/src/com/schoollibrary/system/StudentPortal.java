package com.schoollibrary.system;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentPortal {

	ArrayList<String> name = new ArrayList<>();
	ArrayList<String> classname = new ArrayList<>();
	ArrayList<String> mobile = new ArrayList<>();
	ArrayList<String> book = new ArrayList<>();
	ArrayList<String> date = new ArrayList<>();
	ArrayList<String> author = new ArrayList<>();


	String Stuname;
	int innerloop;

	NormalUser nu = new NormalUser();
	Scanner sc = new Scanner(System.in);

	String studentPortal(ArrayList<String> name, ArrayList<String> classname, ArrayList<String> mobile,
			ArrayList<String> book, String Stuname,ArrayList<String> date, ArrayList<String> author) throws ParseException {

		int count = 0;
		int innerloop = 0;

		this.name.addAll(name);
		this.classname.addAll(classname);
		this.mobile.addAll(mobile);
		this.book.addAll(book);
		this.author.addAll(author);
		this.date.addAll(date);
		this.Stuname = Stuname;
		
		  
		System.out.print("\n\tSearching in Student Database  -- ");

		for (int j = 0; j < 5; j++) {

			System.out.print("*");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.print(e.getMessage());
			}

		}

		for (int i = 0; i < name.size(); i++) {

			if (name.get(i).equalsIgnoreCase(Stuname)) {
				count = 1;
				nu.setName(name.get(innerloop));
				nu.setClassname(classname.get(innerloop));
				nu.setMobile(mobile.get(innerloop));
				nu.setBookname(book.get(innerloop));
				break;
			}

			innerloop++;
		}

		if (count == 0) {
			System.err.println("\n\nNo Student Database Found");
			return "0";
		}

		if (count == 1) {
			System.out.println("\n\t"+Stuname+" Details: --");
			System.out.println("\tStudent Name: " + nu.getName().toUpperCase());
			System.out.println("\tStudent Mobile: " + nu.getMobile());

			if ("No Book Borrowed".equals(nu.getBookname())) {

				System.out.println("\n\tYou haven't Borrowed Any Book Yet..\n");

			} else {

				System.out.println("\n\tBook Borrowed: " + nu.getBookname());
				System.out.println("\tIssued Date: " + this.date);
				
				LocalDate localDate =  LocalDate.parse(this.date.get(innerloop));
				
				System.out.println("\tReturn Date: " + localDate.plusDays(5) );
				System.out.println("\tFine after Date: " + "Rs 120");
			}

		}

		if ("No Book Borrowed".equals(nu.getBookname())) {
			return "0";

		} else {

			System.out.print("\n\tWant to return the Book? yes/no: - ");
			String option = sc.next();

			if ("yes".equalsIgnoreCase(option)) {
				String returnedBook = nu.getBookname();
				this.innerloop = innerloop;
				return returnedBook;

			}

		}

		return "0";

	}

}
