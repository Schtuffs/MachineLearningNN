package com.belgianwaffles;

import java.util.ArrayList;

public class KNNClassifier extends Classifier {
	private int K;
	
	public KNNClassifier(ArrayList<DataManager> trainingData, int k) {
		this.mTrainData = trainingData;
		this.K = k;
		
		// ensure k is not set to a value less than 1
		if (this.K < 1) {
			this.K = 1;
		}

		// Ensure K cannot be larger than dataset
		if (this.K > this.mTrainData.size()) {
			this.K = this.mTrainData.size();
		}
	}

	@Override
	public int classify(DataManager data) {
		// Keeps track of nearest-neighbour
		int[] indexes = new int[this.K];
		double[] closest = new double[this.K]; 
		int furthest = 0;
		
		// initalize the values in the arrays
		for (int i = 0; i<this.K;i++) {
			indexes[i] = i;
			closest[i] = this.dist(this.mTrainData.get(i), data);
		}
		
		// Loop through each set of training data to find the closest one
		
		for (int i = this.K; i < this.mTrainData.size(); i++) {
			// Compare vector distance
			double newDist = this.dist(this.mTrainData.get(i), data);
			
			
			
			// Check if new point is closer
			if (newDist < closest[furthest]) {
				closest[furthest] = newDist;
				indexes[furthest] = i;
				
				// find the largest of the current values and set it to the new largest
				double largestDistance = closest[0];
				furthest = 0;
				for (int j = 1; j<this.K;j++) {
					if (closest[j]>largestDistance) {
						largestDistance = closest[j];
						furthest = j;
					}
				}
			}
		}
		
		// determine which orientation between the k nearest points is most common
		ArrayList<Integer> orientations = new ArrayList<>();
		ArrayList<Integer> counters = new ArrayList<>();
		
		
		// initialize the first entry into the array
		orientations.add(this.mTrainData.get(indexes[0]).getOrientation());
		counters.add(1);
		
		for (int i = 1;i<this.K;i++) {
			
			boolean match = false;
			for (int j = 0;j<orientations.size();j++) {
				if (orientations.get(j)==this.mTrainData.get(indexes[i]).getOrientation()) {
					match=true;
					counters.set(j, counters.get(j) + 1);
				}
			}
			
			// if no match was found, add a new orientation
			if (!match) {
				orientations.add(this.mTrainData.get(indexes[i]).getOrientation());
				counters.add(1);
			}
		}
		
		// determine most common orientation
		int orientation = orientations.get(0);
		int occurences = counters.get(0);
		for (int i = 1;i<orientations.size();i++) {
			if (occurences<counters.get(i)) {
				occurences = counters.get(i);
				orientation = orientations.get(i);
			}
		}
		
		return orientation;
	}
}
