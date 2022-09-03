package com.schoollibrary.system;

import java.util.Map;
import java.util.Set;

public class BookLibrary {
	
	BookLibrary(Map<Integer, String> bookname, Map<Integer, String> bookauthor){
		System.out.println("\n\t Books Available to get issued:");

		Set<Integer> set = bookname.keySet();
		System.err.println("\n\t" + " " + "Book Name" + "\t|\t" + "Book Author");

		int i = 1;
		for (Integer k : set) {
			System.out.println("\t" + i + " " + bookname.get(k) + "\t|\t" + bookauthor.get(k));
			i++;
		}
	}

}
