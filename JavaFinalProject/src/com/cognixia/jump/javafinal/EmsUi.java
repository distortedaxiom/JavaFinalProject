package com.cognixia.jump.javafinal;

import java.util.Scanner;

public class EmsUi {
	
	public static void Run() throws EmployeeNotFound {
		
		System.out.println("\nWelcome to the Employee Management System \n");
		System.out.println("Here you can add new employees, update employees information, remove employees and list employees information\n");
		System.out.println("-----------------------------------------\n");
		System.out.println("Type 'help' for more commands\n");
		
		System.out.print("> ");
		
		boolean isRunning = true;
		
		while(isRunning == true) {
			
			Scanner userInput = new Scanner(System.in);
			String entry = userInput.nextLine();
			
			switch(entry) {
				case "help":
					EmsCommands.helpCommand();
					break;
				case "add":
					EmsCommands.createCommand(userInput);
					break;
				case "employee":
					EmsCommands.readCommand(userInput);
					break;
				case "update":
					EmsCommands.updateCommand(userInput);
					break;
				case "delete":
					EmsCommands.deleteCommand(userInput);
					break;
				case "quit":
					System.out.println("\nExiting...");
					isRunning = false;
					break;
				default:
					System.out.println("\nCommand not found, type 'help' for more\n");
					System.out.print("> ");
					break;
			}
		}
	}
	
}
