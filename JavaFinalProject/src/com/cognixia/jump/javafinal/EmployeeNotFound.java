package com.cognixia.jump.javafinal;

public class EmployeeNotFound extends Exception {
	
	public EmployeeNotFound(String errorMessage) {
	
		super(errorMessage);
		System.out.println("\n" + errorMessage + "\nterminating app...");
		System.exit(1);
	}
	
}
