package com.belgianwaffles;

import java.util.ArrayList;

public abstract class Classifier {

	protected ArrayList<DataManager> mTrainData;
	
	public abstract int classify(DataManager data);
	
	/**
	 * Calculates the Euclidean distance between two points in 3D space
	 * @param dm1 the first point
	 * @param dm2 the second point
	 * @return the Euclidean distance between the two points
	 */
	protected double dist(DataManager dm1, DataManager dm2) {
		return (Math.sqrt(Math.pow(dm1.getX() - dm2.getX(), 2) + Math.pow(dm1.getY() - dm2.getY(), 2) + Math.pow(dm1.getZ() - dm2.getZ(), 2)));
	}
}
