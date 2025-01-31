package com.belgianwaffles;

import java.util.ArrayList;

public class AnotherClassifier extends Classifier {
	public AnotherClassifier(ArrayList<DataManager> trainingData) {
		this.mTrainData = trainingData;
		System.out.println("AnotherClassifier constructor");
	}

	@Override
	public int classify(DataManager data) {
		System.out.println("AnotherClassifier.classify(data)");
		return 0;
	}

}
