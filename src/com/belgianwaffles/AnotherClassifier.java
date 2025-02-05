package com.belgianwaffles;

import java.util.ArrayList;

public class AnotherClassifier extends Classifier {
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
