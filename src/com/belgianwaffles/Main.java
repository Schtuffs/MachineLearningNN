package com.belgianwaffles;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Setup data structures
		FileManager fm = new FileManager("trainingData.txt");
		ArrayList<DataManager> trainingData = fm.read(true);
		ArrayList<DataManager> testingDataUnknown = fm.read(false);
		ArrayList<DataManager> testingDataKnown = fm.read(true);
		ArrayList<DataManager> standardDataUnknown = fm.read(false);
		
		// Test the program with the testing data
		Classifier nnClassifier = new NNClassifier(trainingData);
		int correctClassify = 0, incorrectClassify = 0;
		for (int i = 0; i < testingDataUnknown.size(); i++) {
			// Classify data point
			testingDataUnknown.get(i).setOrientation(nnClassifier.classify(testingDataUnknown.get(i)));
			
			// Check if the data is classified correctly
			if (testingDataUnknown.get(i).compare(testingDataKnown.get(i))) {
				System.out.println("Known: " + testingDataKnown.get(i) + "\nunknown: " + testingDataUnknown.get(i));
				correctClassify++;
			}
			else {
				incorrectClassify++;
			}
		}
		System.out.println("Correct Classifications: " + correctClassify + ", incorrect classifications: " + incorrectClassify);
		
		// Run through the unknown data and test it
		for (int i = 0; i < standardDataUnknown.size(); i++) {
			// Classify data point
			standardDataUnknown.get(i).setOrientation(nnClassifier.classify(standardDataUnknown.get(i)));
			System.out.println("Unknown data: " + standardDataUnknown.get(i));
		}
	}
}
