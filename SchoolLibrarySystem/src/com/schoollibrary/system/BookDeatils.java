package com.schoollibrary.system;
public class BookDeatils implements ItemDetails {

	String name;
	String category;
	String author;

	@Override
	public String itemName(String name) {
		this.name = name;
		return name;
	}

	@Override
	public String itemAuthor(String author) {
		this.author = author;
		return author;
	}

}
