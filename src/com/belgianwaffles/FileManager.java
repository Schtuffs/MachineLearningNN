package com.belgianwaffles;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
	public static ArrayList<DataManager> read(String filename, boolean readOrientation) {
		// Create datapoint list
		ArrayList<DataManager> dataPoints = new ArrayList<>();
		
		try {
			// Open file and begin reading
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String[] data = reader.nextLine().split(",");
				DataManager dm = FileManager.parse(data, readOrientation);
				
				// Only add datapoint if its valid
				if (dm != null) {
					dataPoints.add(dm);
				}
			}
			reader.close();
		}
		// File failed to open
		catch (FileNotFoundException e) {
			System.out.println("Could not open file...");
		}
		
		return dataPoints;
	}
	
	private static DataManager parse(String[] data, boolean readOrientation) {
		DataManager dm;
		try {
			// Parse the pieces of data
			double x = Double.parseDouble(data[0]);
			double y = Double.parseDouble(data[1]);
			double z = Double.parseDouble(data[2]);
			
			// If the data is already classified, then it can be initialized with orientation
			int orientation = 0;
			if (readOrientation) {
				orientation = Integer.parseInt(data[3]);
				dm = new DataManager(x, y, z, orientation);
			}
			else {
				dm = new DataManager(x, y, z);
			}
		}
		// Catch invalid parsing
		catch (NumberFormatException e) {
			System.out.println("String could not be parsed to number...");
			return null;
		}
		
		return dm;
	}
}
