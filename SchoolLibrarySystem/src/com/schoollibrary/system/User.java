package com.schoollibrary.system;

import java.util.Scanner;

public class User {
	
	String user;

	User(){
		System.out.print("\n\tEnter StudentId or Name: ");
		Scanner sc = new Scanner(System.in);
		String user = sc.next();
		this.user=user;
		}
	
}
