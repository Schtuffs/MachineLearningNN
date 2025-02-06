package com.belgianwaffles;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main entry point class for the program
 * @author Kyle Wagler
 * @author Andrew Abrantes
 * @author Dylan Glass
 */
public class Main {
	/**
	 * User input code for exiting the program.
	 */
	public static final int CODE_EXIT		= 0;
	/**
	 * User input code for invalid input.
	 */
	public static final int CODE_INVALID	=-1;

		/**
		 * Main entry point for the program. This program reads data from a file and classifies it using different classifiers. The classifiers used are the Nearest Neighbor classifier, the K-Nearest Neighbors classifier, and the AnotherClassifier.
		 *
		 * The program runs in an infinite loop until the user chooses to exit.
		 * The user is first prompted to choose a classifier, and then to enter a filename to classify. The program then prints the classification of each data point in the file.
		 * 
		 * @param args the command line arguments as a string array.
		 */
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

/**
 * Classifies a list of data points using the provided classifier.
 *
 * @param classifier the classifier to use for classifying data points
 * @param data the list of data points to be classified
 * 
 * Ensures that neither parameter is null before proceeding. 
 * Each data point's orientation is set based on the classification result. 
 * The results are written to "result.txt".
 */

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
