package com.schoollibrary.system;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class UpdateLibraryBook extends Admin {
		
	
	UpdateLibraryBook(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	static Map reIndex(Map<Integer, String> bookname, String returnedBook) {
	
		
		bookname.put(bookname.size() + 2,returnedBook );

		ArrayList<String> tempBook = new ArrayList<>();
		Set<Integer> set = bookname.keySet();

		for (Integer k : set) {
			tempBook.add(bookname.get(k));
		}
		bookname.clear();

		for (int i = 0; i < tempBook.size(); i++) {
			bookname.put(i + 1, tempBook.get(i));
		}
		
		return bookname;
		
		
	}
	
	

}
