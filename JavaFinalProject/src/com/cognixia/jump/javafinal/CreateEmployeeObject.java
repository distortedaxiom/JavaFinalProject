package com.cognixia.jump.javafinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.cognixia.jump.javafinal.Employee;

public class CreateEmployeeObject {

	public static void CreateRunner(String firstName, String lastName, String dateEmployed, int salary, String department) {
		// TODO Auto-generated method stub
		
		File file = new File("resources/" + firstName + lastName + ".data");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		writeObjectToFile(file, firstName, lastName, dateEmployed, salary, department);
		System.out.println("\nSuccess! Employee created: ");
		readObjectToFile(file);
		
	}	
	
	public static void writeObjectToFile(File file, String firstName, String lastName, String dateEmployed, int salary, String department) {
		
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			EmployeeIds.CreateEmployeeId();
			
			Employee employee = new Employee(EmployeeIds.CreateEmployeeId(),firstName, lastName, dateEmployed, salary, department);
			
			writer.writeObject(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateObjectToFile(File file, int id, String firstName, String lastName, String dateEmployed, int salary, String department) {
		
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			EmployeeIds.CreateEmployeeId();
			
			Employee employee = new Employee(id, firstName, lastName, dateEmployed, salary, department);
			
			writer.writeObject(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		readObjectToFile(file);
	}
	
	public static void readObjectToFile(File file) {
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			
			Employee employee = (Employee) reader.readObject();
			
			System.out.println("\nName: " + employee.getFirstName() + " " + employee.getLastName());
			System.out.println("Id: " + employee.getId());
			System.out.println("Employment Date: " + employee.getEmploymentDate());
			System.out.println("Salary: " + employee.getSalary());
			System.out.println("Department: " + employee.getDepartment());
			System.out.print("\n> ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getObjectId(File file) {
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			
			Employee employee = (Employee) reader.readObject();
			
			return employee.getId();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static void deleteObjectFile(File file) {
		
		if (file.delete()) {
			System.out.println("The employee has been deleted from the system\n");
			System.out.print("> ");
		}
		
		else {
			System.out.println("Failed to delete the employee\n");
			System.out.print("> ");
		}
		
	}

}
