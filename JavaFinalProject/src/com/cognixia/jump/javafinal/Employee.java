package com.cognixia.jump.javafinal;

import java.io.Serializable;

public class Employee implements Serializable {

	private static int idCounter = 1;

	private int id;
	private String firstName;
	private String lastName;
	private String employmentDate;
	private int salary;
	private String department;
	
	public Employee(int id, String firstName, String lastName, String employmentDate, int salary, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employmentDate = employmentDate;
		this.salary = salary;
		this.department = department;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", employmentDate="
				+ employmentDate + ", salary=" + salary + ", department=" + department + "]";
	}
	
			
	
}
