package com.belgianwaffles;

import java.util.ArrayList;

/**
 * Abstract base class for all classifiers
 * @author Kyle Wagler
 */
public abstract class Classifier {


	/**
	 * List of data points to be classified.
	 */
	protected ArrayList<DataManager> mTrainData;
	

	/**
	 * Abstract function that is meant to classify a given data point as one of the orientations in the training data set.
	 * @param data the point to classify
	 * @return the orientation of the data point
	 */
	public abstract int classify(DataManager data);
	
	/**
	 * Calculates the distance between two points in 3D space
	 * @param dm1 the first point
	 * @param dm2 the second point
	 * @return the distance between the two points
	 */
	protected double dist(DataManager dm1, DataManager dm2) {
		return (Math.sqrt(Math.pow(dm1.getX() - dm2.getX(), 2) + Math.pow(dm1.getY() - dm2.getY(), 2) + Math.pow(dm1.getZ() - dm2.getZ(), 2)));
	}
}
