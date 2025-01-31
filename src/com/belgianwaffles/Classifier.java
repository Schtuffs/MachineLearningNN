package com.belgianwaffles;

import java.util.ArrayList;

public abstract class Classifier {

	protected ArrayList<DataManager> mTrainData;
	
	public abstract int classify(DataManager data);
	
	protected double dist(DataManager dm1, DataManager dm2) {
		return (Math.sqrt(Math.pow(dm1.getX() - dm2.getX(), 2) + Math.pow(dm1.getY() - dm2.getY(), 2) + Math.pow(dm1.getZ() - dm2.getZ(), 2)));
	}
}
