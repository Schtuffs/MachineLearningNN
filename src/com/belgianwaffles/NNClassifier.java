package com.belgianwaffles;

import java.util.ArrayList;

/**
 * Nearest Neighbor classifier that classifies a given data point to one of the orientations in the training data set.
 * @author Kyle Wagler
 */
public class NNClassifier extends Classifier {
	
	/**
	 * Constructor for the Nearest Neighbor classifier that sets the training data.
	 * @param trainingData the training data
	 */
	public NNClassifier(ArrayList<DataManager> trainingData) {
		this.mTrainData = trainingData;
	}

	/**
	 * Classify a given data point to one of the orientations in the training data set.
	 * @param data the point to classify
	 * @return the orientation of the closest known point
	 */
	@Override
	public int classify(DataManager data) {
		// Keeps track of nearest-neighbour
		int index = 0;
		
		// Loop through each set of training data to find the closest one
		double closest = 10;
		for (int i = 0; i < this.mTrainData.size(); i++) {
			// Compare vector distance
			double newDist = this.dist(this.mTrainData.get(i), data);
			
			// Check if new point is closer
			if (newDist < closest) {
				closest = newDist;
				index = i;
			}
		}
		
		return this.mTrainData.get(index).getOrientation();
	}
}
