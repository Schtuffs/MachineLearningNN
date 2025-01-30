package com.belgianwaffles;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static final int CODE_EXIT	= 0;
	public static final int CODE_INVALID= -1;

	public static void main(String[] args) {
		// Setup data structures
		ArrayList<DataManager> trainingData = FileManager.read("trainingData.txt", true);
		ArrayList<DataManager> testingDataUnknown = FileManager.read("testingData.txt", false);
		ArrayList<DataManager> testingDataKnown = FileManager.read("testingData.txt", true);
		ArrayList<DataManager> standardDataUnknown = FileManager.read("unknownData.txt", false);
		int K = 3;
		
		// Test the program with the testing data
		Classifier nnClassifier = new NNClassifier(trainingData);
		Classifier knnClassifier = new KNNClassifier(trainingData, K);
		// Classifier anotherClassifier = new AnotherClassifier(trainingData);

		// Main loop
		Scanner input = new Scanner(System.in);
		int userInput = CODE_EXIT;
		do {
			
			Classifier currentClassifier = null;

			// Loop until valid input entered
			do {
				// Print menu options
				System.out.println("Choose a classifier");
				System.out.println("1. NNClassifier");
				System.out.println("2. KNNClassifier");
				System.out.println("3. AnotherClassifier");

				// Catch wrong input
				try {
					userInput = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Not a number");
					userInput = CODE_INVALID;
				}

				// Check number in range
				if (0 > userInput || userInput > 3) {
					System.out.println("Not an option");
					userInput = CODE_INVALID;
				}
			} while (userInput == CODE_INVALID);
			
			// Switch for changing classifier
			switch (userInput) {
				case 1:
					currentClassifier = nnClassifier;
					break;
				case 2:
					currentClassifier = knnClassifier;
					break;
				case 3:
					// currentClassifier = anotherClassifier;
					break;
			}
			
			// Call classify method
			if (currentClassifier != null) {
				classify(currentClassifier, testingDataUnknown, testingDataKnown, standardDataUnknown);
			}
		} while (userInput != CODE_EXIT);
		input.close();
	}

	private static void classify(Classifier classifier, ArrayList<DataManager> testingDataUnknown, ArrayList<DataManager> testingDataKnown, ArrayList<DataManager> standardDataUnknown) {
		// Ensure no null
		if (classifier == null || testingDataUnknown == null || testingDataKnown == null || standardDataUnknown == null) {
			System.out.println("A parameter for classifying was null");
			return;
		}

		// Tracks classifications
		int correctClassify = 0, incorrectClassify = 0;
		for (int i = 0; i < testingDataUnknown.size(); i++) {
			// Classify data point
			testingDataUnknown.get(i).setOrientation(classifier.classify(testingDataUnknown.get(i)));

			// Check if the data is classified correctly
			if (testingDataUnknown.get(i).compare(testingDataKnown.get(i))) {
				correctClassify++;
			}
			else {
				incorrectClassify++;
			}
		}
		// Testing data results
		System.out.println("Testing data with Classifier");
		System.out.println("Correct Classifications: " + correctClassify + ", incorrect classifications: " + incorrectClassify + "\n");

		// Run through the unknown data and test it
		for (int i = 0; i < standardDataUnknown.size(); i++) {
			// Classify data point
			standardDataUnknown.get(i).setOrientation(classifier.classify(standardDataUnknown.get(i)));
			System.out.println("Unknown data:  " + standardDataUnknown.get(i));
		}
	}
}
