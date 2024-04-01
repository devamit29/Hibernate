package com.controller;

import java.util.Scanner;

import com.service.ServiceImpl;
import com.service.Services;

public class HomeController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Services s=new ServiceImpl();
		boolean flag=true;
		
		while (flag) {
			System.out.println("Welcome to app: ");
			System.out.println("1.addStudentWithAddress");
			System.out.println("2.showStudentWithAddress");
			System.out.println("3.showAllStudentWithAddress");
			System.out.println("4.updateStudentAndAddress");
			System.out.println("5.deleteStudentAndAddress");
			System.out.println("6.Exist app");
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				s.addStudentWithAddress();
				break;
			case 2:
				s.showStudentWithAddress();
				break;
			case 3:
				s.showAllStudentWithAddress();
				break;
			case 4:
				s.updateStudentAndAddress();
				break;
			case 5:
				s.deleteStudentWithAddress();
				break;
			case 6:
				s.exist();
				break;

			default:
				System.out.println("Invalid input !!!");
				break;
			}
		}
	}

}
