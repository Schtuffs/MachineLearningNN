package com.belgianwaffles;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		FileManager fm = new FileManager("trainingData.txt");
		ArrayList<DataManager> points = fm.read(true);
		for (DataManager dm : points) {
			System.out.println(dm);
		}
	}
}
