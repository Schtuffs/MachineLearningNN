package com.belgianwaffles;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Setup data structures
		ArrayList<DataManager> trainingData = FileManager.read("trainingData.txt", true);
		ArrayList<DataManager> testingDataUnknown = FileManager.read("testingData.txt", false);
		ArrayList<DataManager> testingDataKnown = FileManager.read("testingData.txt", true);
		ArrayList<DataManager> standardDataUnknown = FileManager.read("unknownData.txt", false);
		
		// Test the program with the testing data
		Classifier nnClassifier = new NNClassifier(trainingData);
		int correctClassify = 0, incorrectClassify = 0;
		for (int i = 0; i < testingDataUnknown.size(); i++) {
			// Classify data point
			testingDataUnknown.get(i).setOrientation(nnClassifier.classify(testingDataUnknown.get(i)));
			
			// Check if the data is classified correctly
			if (testingDataUnknown.get(i).compare(testingDataKnown.get(i))) {
				correctClassify++;
			}
			else {
				incorrectClassify++;
			}
		}
		System.out.println("Testing data");
		System.out.println("Correct Classifications: " + correctClassify + ", incorrect classifications: " + incorrectClassify + "\n");
		
		// Run through the unknown data and test it
		for (int i = 0; i < standardDataUnknown.size(); i++) {
			// Classify data point
			standardDataUnknown.get(i).setOrientation(nnClassifier.classify(standardDataUnknown.get(i)));
			System.out.println("Unknown data: " + standardDataUnknown.get(i));
		}
	}
}
