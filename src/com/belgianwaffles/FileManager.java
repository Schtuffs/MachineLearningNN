package com.belgianwaffles;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class FileManager {
	/**
	 * Writes the given data to a file
	 * @param filename the file to write to
	 * @param data the data to write
	 * @return true if the write was successful, false if not
	 */
	public static boolean write(String filename, ArrayList<DataManager> data) {
		PrintWriter file;
		try {
			file = new PrintWriter(filename);
			for (DataManager dm : data) {
				file.write(dm.toString() + "\n");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Failed to create file");
			return false;
		}
		file.close();
		return true;
	}
	
	/**
	 * Reads the given file and returns an arraylist of datapoints.
	 * @param filename the file to read
	 * @param readOrientation whether to read the orientation as well
	 * @return an arraylist of datapoints
	 */
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
	
	/**
	 * Parse a string array into a datapoint.
	 * @param data the string array to parse
	 * @param readOrientation whether to read the orientation as well
	 * @return a datapoint, or null if the string could not be parsed into a number.
	 */
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
