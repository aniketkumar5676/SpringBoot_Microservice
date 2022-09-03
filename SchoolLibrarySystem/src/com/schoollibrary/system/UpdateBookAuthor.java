package com.schoollibrary.system;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class UpdateBookAuthor extends Admin {

	UpdateBookAuthor(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	static Map reIndex(Map<Integer, String> bookauthor, String returnedBook) {

		bookauthor.put(bookauthor.size() + 2, returnedBook);

		ArrayList<String> tempBook = new ArrayList<>();
		Set<Integer> set = bookauthor.keySet();

		for (Integer k : set) {
			tempBook.add(bookauthor.get(k));
		}
		bookauthor.clear();

		for (int i = 0; i < tempBook.size(); i++) {
			bookauthor.put(i + 1, tempBook.get(i));
		}

		return bookauthor;

	}

}
