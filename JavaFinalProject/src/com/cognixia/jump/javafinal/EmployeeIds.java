package com.cognixia.jump.javafinal;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeIds {

	public static int CreateEmployeeId() {
		// TODO Auto-generated method stub
		
		File file = new File("resources/employeeIds.data");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Integer> list = readObjectToFile(file);
		int newId = writeObjectToFile(file, list);
		
		return newId;
	}	
	
	public static int writeObjectToFile(File file, List<Integer> list) {
		
		int max = 0;
		
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			
			List<Integer> idArray = new ArrayList<>();
			
			if (list != null) {
			
				int biggest = list.stream()
						.reduce((num1, num2) -> num1 > num2 ? num1 : num2)
						.get();
				
				idArray.add(biggest + 1);
				max = (biggest);
			}
			
			else {
				idArray.add(1);
			}
			
			writer.writeObject(idArray);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (max);
	}
	
	public static void initializeObjectFile(File file) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			
			List<Integer> idArray = new ArrayList<>();
			
			idArray.add(1);
			
			writer.writeObject(idArray);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Integer> readObjectToFile(File file) {
		
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			
			List<Integer> idArray = (List<Integer>)reader.readObject();
			
			return idArray;	
			
		} catch (EOFException e) {
			initializeObjectFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
