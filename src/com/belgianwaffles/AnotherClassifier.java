package com.belgianwaffles;

import java.util.ArrayList;
/**
 * A classifier that doesn't really do anything. This is implemented to satisfy the requirements of the assignment.
 * @author Kyle Wagler
 */
public class AnotherClassifier extends Classifier {
	/**
	 * Constructor for the AnotherClassifier class that prints its name when the object is created.
	 * @param trainingData the training data set
	 */
	public AnotherClassifier(ArrayList<DataManager> trainingData) {
		this.mTrainData = trainingData;
		System.out.println("AnotherClassifier constructor");
	}

	/**
	 * Classify a given data point to one of the orientations in the training data set.
	 * @param data the point to classify
	 * @return the orientation of the closest known point
	 */
	@Override
	public int classify(DataManager data) {
		System.out.println("AnotherClassifier.classify(data)");
		return 0;
	}

}
