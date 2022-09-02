package com.schoollibrary.system;

import java.util.Scanner;

public class Login {

	String user;
	String password;
	Login(){
		System.out.print("\n\tEnter Your UserId or Name: ");
		Scanner sc = new Scanner(System.in);
		String user = sc.next();
		this.user=user;

		System.out.print("\n\tEnter Your Password (Enter name incase you are Student): ");
		String password = sc.next();
		this.password=password;
	}
}
