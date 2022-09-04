package com.hotel.booking;

import java.util.HashMap;
import java.util.Map;

public class UserData {

	Map<Integer, String> userid = new HashMap<>();
	Map<Integer, String> username = new HashMap<>();
	Map<Integer, String> useremail = new HashMap<>();
	Map<Integer, String> userphoneno = new HashMap<>();
	Map<Integer, String> useraddress = new HashMap<>();

	UserData() {

		// userid
		this.userid.put(1, "user001");
		this.userid.put(2, "user002");
		this.userid.put(3, "user003");
		this.userid.put(4, "user004");
		this.userid.put(5, "user005");

		// username

		this.username.put(1, "Aniket");
		this.username.put(2, "Pinki");
		this.username.put(3, "Rahul");
		this.username.put(4, "Satyajeet");
		this.username.put(5, "Surjeet");

		// usermobileno

		this.userphoneno.put(1, "8709439922");
		this.userphoneno.put(2, "79009432443");
		this.userphoneno.put(3, "9409442976");
		this.userphoneno.put(4, "8809886975");
		this.userphoneno.put(5, "7708643929");

		// useremail

		this.useremail.put(1, "aniketkumar5676@gmail.com");
		this.useremail.put(2, "pinki.987@gmail.com");
		this.useremail.put(3, "rahul_techno99@gmail.com");
		this.useremail.put(4, "satyajeet23.dev@gmail.com");
		this.useremail.put(5, "surjeet22324@gmail.com");

		// useraddress

		this.useraddress.put(1, "East Colony,Jamalpur,811214");
		this.useraddress.put(2, "East Colony,Jamalpur,811214");
		this.useraddress.put(3, "Nayagaon,Munger,711614");
		this.useraddress.put(4, "West Rail Hub,WestBengal,115543");
		this.useraddress.put(5, "New Buddha Colony,Rampur,811235");

	}

}
