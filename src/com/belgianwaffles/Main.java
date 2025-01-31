package com.belgianwaffles;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static final int CODE_EXIT		= 0;
	public static final int CODE_INVALID	=-1;

	public static void main(String[] args) {
		// Setup data structures
		ArrayList<DataManager> trainingData = FileManager.read("trainingData.txt", true);
		int K = 3;
		
		// Test the program with the testing data
		Classifier nnClassifier = new NNClassifier(trainingData);
		Classifier knnClassifier = new KNNClassifier(trainingData, K);
		 Classifier anotherClassifier = new AnotherClassifier(trainingData);

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
			if (userInput == CODE_EXIT) {
				break;
			}
			
			// Switch for changing classifier
			switch (userInput) {
				case 1:
					currentClassifier = nnClassifier;
					break;
				case 2:
					currentClassifier = knnClassifier;
					break;
				case 3:
					currentClassifier = anotherClassifier;
					break;
			}
			
			// Get filename input
			System.out.print("Enter a filename to classify: ");
			input.nextLine();
			String file = input.nextLine();
			ArrayList<DataManager> data = FileManager.read(file, false);
			
			// Call classify method
			classify(currentClassifier, data);
		} while (userInput != CODE_EXIT);
		input.close();
	}

	private static void classify(Classifier classifier, ArrayList<DataManager> data) {
		// Ensure no null
		if (classifier == null || data == null) {
			System.out.println("A parameter for classifying was null");
			return;
		}
		
		// Run through the unknown data and test it
		for (int i = 0; i < data.size(); i++) {
			// Classify data point
			data.get(i).setOrientation(classifier.classify(data.get(i)));
		}
		FileManager.write("result.txt", data);
	}
}
