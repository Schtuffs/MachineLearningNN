package com.belgianwaffles;

import java.util.ArrayList;

public class NNClassifier extends Classifier {
	private ArrayList<DataManager> mTrainData;
	
	public NNClassifier(ArrayList<DataManager> trainingData) {
		this.mTrainData = trainingData;
	}

	@Override
	public int Classify(DataManager data) {
		// Keeps track of nearest-neighbour
		int index = 0;
		
		// Loop through each set of training data to find the closest one
		for (int i = 0; i < this.mTrainData.size(); i++) {
			
		}
		return this.mTrainData.get(index).getOrientation();
	}
}
