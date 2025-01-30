package com.belgianwaffles;

import java.util.ArrayList;

public class NNClassifier extends Classifier {
	private ArrayList<DataManager> mTrainData;
	
	public NNClassifier(ArrayList<DataManager> trainingData) {
		this.mTrainData = trainingData;
	}

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
