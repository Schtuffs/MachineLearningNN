package com.belgianwaffles;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
	private String mFilename;
	public FileManager(String filename) {
		this.mFilename = filename;
	}
	
	public ArrayList<DataManager> read(boolean readOrientation) {
		ArrayList<DataManager> dataPoints = new ArrayList<>();
		try {
			File file = new File(this.mFilename);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String[] data = reader.nextLine().split(",");
				DataManager dm = this.parse(data, readOrientation);
				if (dm != null) {
					dataPoints.add(dm);
				}
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Could not open file...");
		}
		
		return dataPoints;
	}
	
	private DataManager parse(String[] data, boolean readOrientation) {
		DataManager dm;
		try {
			double x = Double.parseDouble(data[0]);
			double y = Double.parseDouble(data[1]);
			double z = Double.parseDouble(data[2]);
			int orientation = 0;
			if (readOrientation) {
				orientation = Integer.parseInt(data[3]);
				dm = new DataManager(x, y, z, orientation);
			}
			else {
				dm = new DataManager(x, y, z);
			}
		}
		catch (NumberFormatException e) {
			System.out.println("String could not be parsed to number...");
			return null;
		}
		
		return dm;
	}
}
