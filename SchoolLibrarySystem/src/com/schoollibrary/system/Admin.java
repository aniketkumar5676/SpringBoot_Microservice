package com.schoollibrary.system;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Admin extends CheckLogin {

	String id;

	Admin(String id) {

		this.id = id;

	}

	void adminAccess() throws ParseException {

		Map<Integer, String> bookname = new HashMap<>();
		Map<Integer, String> bookauthor = new HashMap<>();

		System.out.println("\n\n\tWelcome," + id.toUpperCase());
		int loop = 1;
		
		//Predefined Book

		bookname.put(1, "Cinder");
		bookname.put(2, "Fair");
		bookname.put(3, "Winter");
		bookname.put(4, "Insurgent");
		bookname.put(5, "Divergent");

		bookauthor.put(1, "Marissa");
		bookauthor.put(2, "Stephanie");
		bookauthor.put(3, "Chronicles");
		bookauthor.put(4, "Colleen");
		bookauthor.put(5, "Laurie");

		ArrayList<String> name = new ArrayList<>();
		ArrayList<String> classname = new ArrayList<>();
		ArrayList<String> mobile = new ArrayList<>();
		ArrayList<String> book = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();


		Map<Integer, String> selectedbook = new HashMap<>();


		while (loop < 2) {

			System.out.println("\n\n\tChoose Option:- ");
			System.out.println("\t1.Add Book ");
			System.out.println("\t2.Issue Book ");
			System.out.println("\t3.Search Student Details");
			System.out.println("\t4.Exit to Login ");

			System.out.print("\n\n\tEnter Your Option: - ");

			int count = 0;

			Scanner sc = new Scanner(System.in);
			String option = sc.next();

			switch (Integer.parseInt(option)) {

			case 1: {
				BookDeatils bk = new BookDeatils();

				System.out.println("\t\nAdd Book Name: ");
				String enteredbookname = sc.next();

				Set<Integer> set = bookname.keySet();

				for (Integer k : set) {

					if (bookname.get(k).equals(enteredbookname)) {
						count = 1;
						System.out.println("\t\nData Already Available...");
						break;
					}

				}

				if (book.size() >= 1) {

					for (int i = 0; i < book.size(); i++) {

						if (book.get(i).equalsIgnoreCase(enteredbookname)) {
							count = 1;
							System.out.println("\t\nBorrowed by Someone..");
							break;
						}
					}

				}

				if (count == 0) {
					bookname.put(bookname.size() + 1, bk.itemName(enteredbookname));

					System.out.println("\t\nAdd Book Author: ");
					String enteredauthor = sc.next();

					bookauthor.put(bookauthor.size() + 1, bk.itemAuthor(enteredauthor));
					System.out.println("\t\n---Book Added Successfully:--");
				}

				break;
			}

			case 2: {

				IssueBook ib = new IssueBook(id);
				System.out.println("\n\t Books Available to get issued:");
				System.out.println("\n\t" + bookname);
				System.out.print("\n\t Enter your Choice between 1 to " + bookname.size() + " :--");
				int bookoption = 0;

				try {
					bookoption = sc.nextInt();
					if (bookoption > bookname.size()) {
						throw new OptionExceptionHandle("");

					}

				} catch (Exception e) {
					System.err.println("\nTry to chooose correct option :");
					break;
				}

				ib.issueBookName();

				selectedbook.put(selectedbook.size(), (bookname.get(bookoption)));

				name.add(ib.name);
				classname.add(ib.classname);
				mobile.add(String.valueOf(ib.mobile));
				book.add((bookname.get(bookoption)));
				date.add(ib.date);

				bookname.remove(bookoption);
				bookauthor.remove(bookoption);

				System.out.println("\t\n---Book Issued Successfully to " + ib.name.toUpperCase());

				break;
			}

			case 3: {

				User ur = new User();
				StudentPortal s = new StudentPortal();
				String returnedBook = s.studentPortal(name, classname, mobile, book, ur.user,date);
				if ("0".equals(returnedBook)) {

				} else {
					// ----Logic to reIndex Hasmap Data---

					bookname.put(bookname.size() + 2, returnedBook);

					ArrayList<String> tempBook = new ArrayList<>();
					Set<Integer> set = bookname.keySet();

					for (Integer k : set) {
						tempBook.add(bookname.get(k));
					}
					bookname.clear();

					for (int i = 0; i < tempBook.size(); i++) {
						bookname.put(i + 1, tempBook.get(i));
					}

					book.add(s.innerloop, "No Book Borrowed");
					System.out.println("\t\n---Book Returned Successfully to Library");
				}

				break;
			}

			case 4: {

				loop = 3;
				System.out.println("\t\n Thank you..");
				System.exit(1);
				break;

			}
			default: {
				System.out.print("\t\nEnter Valid Details, Try Again : ");
				break;
			}

			}

		}
	}
}
