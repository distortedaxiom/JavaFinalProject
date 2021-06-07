package com.cognixia.jump.javafinal;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmsCommands {

	public static void helpCommand() {
			
		System.out.println("\nPlease see the options below, simply type in the command and follow the steps");
		System.out.println("\nadd: Create a new employee with the following specification (First Name, Last Name, Employment Date, Salary and Department ");
		System.out.println("\nemployee: View detailed information about an employee in the system");
		System.out.println("\nupdate: Update an existing employee with new information");
		System.out.println("\ndelete: Delete an employee from the system");
		System.out.println("\nquit: Exit the program");
		System.out.print("\n> ");
		
	}
	
	public static void createCommand(Scanner sc) {
		
		String firstName = null;
		String lastName = null;
		String dateEmployed = null;
		int salary = 0;
		String department = null;

		Pattern datePattern = Pattern.compile("^(0?[1-9]|1[012])[\\/\\-](0?[1-9]|[12][0-9]|3[01])[\\/\\-]\\d{4}$");
		
		boolean isRunning = true;
		
		while (isRunning) {
			System.out.println("What is the first name of the Employee? ");
			firstName = sc.nextLine();
			
			System.out.println("What is the last name of the Employee? ");
			lastName = sc.nextLine();
			
			System.out.println("When was this employee hired? (Use the format MM-DD-YYYY, ex: 03-24-2019");
			dateEmployed = sc.nextLine();
			
			Matcher dateMatcher = datePattern.matcher(dateEmployed);
			boolean dateMatches = dateMatcher.matches();
			
			if (!dateMatches) {
				boolean retry = true;
				while(retry) {
					System.out.println("Please enter the date again and check your format");
					dateEmployed = sc.nextLine();
					Matcher dateMatcherRetry = datePattern.matcher(dateEmployed);
					boolean dateMatchesRetry = dateMatcherRetry.matches();
					
					if (dateMatchesRetry) {
						retry = false;
					}
					else {

					}
				}
			}
			
			else {
				
			}
			
			System.out.println("How much is this employee making?");
			
			if (!sc.hasNextInt()) {
				boolean isInt = false;
				while (!isInt) {
					System.out.println("Input is not a number.");
					sc.nextLine();
					if (sc.hasNextInt()) {
						isInt = true;
						salary = sc.nextInt();
					}
				}
			}
			
			else {
				salary = sc.nextInt();
			}
		   
		    
			System.out.println("What is the department that this employee belongs to? ");

			sc.nextLine();
			department = sc.nextLine();
			
			isRunning = false;
		}
		
		CreateEmployeeObject.CreateRunner(firstName, lastName, dateEmployed, salary, department);
	
	}
	
	public static void readCommand(Scanner sc) {
		
		System.out.println("Enter the name of the employee to gain more information, ex: 'FirstName LastName' / 'John Doe' ");
		
		String[] fullName = sc.nextLine().split(" ");
		
		String firstName = fullName[0];
		String lastName = fullName[1];
		
		File file = new File("resources/" + firstName + lastName + ".data");
		
		CreateEmployeeObject.readObjectToFile(file);
		
	}
	
	public static void updateCommand(Scanner sc) throws EmployeeNotFound {
		
		System.out.println("Enter the name of the employee to update their information, ex: 'FirstName LastName' / 'John Doe' ");
		
		String[] fullName = sc.nextLine().split(" ");
		
		String firstName = fullName[0];
		String lastName = fullName[1];
		
		File file = new File("resources/" + firstName + lastName + ".data");
		
		String dateEmployed = null;
		int salary = 0;
		String department = null;

		Pattern datePattern = Pattern.compile("^(0?[1-9]|1[012])[\\/\\-](0?[1-9]|[12][0-9]|3[01])[\\/\\-]\\d{4}$");
		
		boolean isRunning = true;
		
		if (!file.isDirectory()) {
			String errorMessage = (firstName + " " + lastName + " is not a valid employee");
			throw new EmployeeNotFound(errorMessage);
		}
		
		while (isRunning) {
			
			System.out.println("When was this employee hired? (Use the format MM-DD-YYYY, ex: 03-24-2019");
			dateEmployed = sc.nextLine();
			
			Matcher dateMatcher = datePattern.matcher(dateEmployed);
			boolean dateMatches = dateMatcher.matches();
			
			if (!dateMatches) {
				boolean retry = true;
				while(retry) {
					System.out.println("Please enter the date again and check your format");
					dateEmployed = sc.nextLine();
					Matcher dateMatcherRetry = datePattern.matcher(dateEmployed);
					boolean dateMatchesRetry = dateMatcherRetry.matches();
					
					if (dateMatchesRetry) {
						retry = false;
					}
					else {

					}
				}
			}
			
			else {
				
			}
			
			System.out.println("What is the salary for this employee?");
			
			if (!sc.hasNextInt()) {
				boolean isInt = false;
				while (!isInt) {
					System.out.println("Input is not a number.");
					sc.nextLine();
					if (sc.hasNextInt()) {
						isInt = true;
						salary = sc.nextInt();
					}
				}
			}
			
			else {
				salary = sc.nextInt();
			}
		   
		    
			System.out.println("What is the department that this employee belongs to? ");

			sc.nextLine();
			department = sc.nextLine();
			
			isRunning = false;
		}
		
		int id = CreateEmployeeObject.getObjectId(file);
		
		System.out.println("\nUpdate successful");
		CreateEmployeeObject.updateObjectToFile(file, id, firstName, lastName, dateEmployed, salary, department);
		
	}
	
	public static void deleteCommand(Scanner sc) throws EmployeeNotFound {
		
		System.out.println("\nEnter the name of the employee to delete their profile, ex: 'FirstName LastName' / 'John Doe' ");
		
		String[] fullName = sc.nextLine().split(" ");
		
		String firstName = fullName[0];
		String lastName = fullName[1];
		
		File file = new File("resources/" + firstName + lastName + ".data");
		
		if (!file.isDirectory()) {
			String errorMessage = (firstName + " " + lastName + " is not a valid employee");
			throw new EmployeeNotFound(errorMessage);
		}
		
		CreateEmployeeObject.deleteObjectFile(file);
	}
	
}
