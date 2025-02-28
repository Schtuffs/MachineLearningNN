package com.belgianwaffles;

import java.util.HashMap;
import java.util.Map;
/**
 * Representation of a data point in the training data set.
 * @author Kyle Wagler
 */
public class DataManager {

	/**Point coordinates */
	private double mX, mY, mZ;
	/** Orientation of the data point representing a phone's orientation */
	private int mOrientation;
	
	/** Invalid orientation code */
	public static final int INVALID_ORIENTATION = 0; 
	
	/** Map of orientation codes to their names */
	public static final Map<Integer, String> OrientationMap = new HashMap<>();
	static {
		DataManager.OrientationMap.put(DataManager.INVALID_ORIENTATION, "Invalid");
		DataManager.OrientationMap.put(1, "Face up");
		DataManager.OrientationMap.put(2, "Face down");
		DataManager.OrientationMap.put(3, "Portrait");
		DataManager.OrientationMap.put(4, "Portrait upside down");
		DataManager.OrientationMap.put(5, "Landscape left");
		DataManager.OrientationMap.put(6, "Landscape right");
	}
	
	/**
	 * The default constructor
	 */
	public DataManager() {
		
		// blank initialization 
		this.mX = 0;
		this.mY = 0;
		this.mZ = 0;
		this.mOrientation = DataManager.INVALID_ORIENTATION;
	}
	
	/**
	 * Constructor with coordinates only
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * 	@param z Z-coordinate
	 */
	public DataManager(double x, double y, double z) {
		
		// set x value if given is valid, otherwise set it to 0
		if (-1 <= x && x <= 1) {
			this.mX = x;
		}
		else {
			this.mX = 0;
		}
		
		// set y value if given is valid, otherwise set it to 0
		if (-1 <= y && y <= 1) {
			this.mY = y;
		}
		else {
			this.mY = 0;
		}
		
		// set z value if given is valid, otherwise set it to 0
		if (-1 <= z && z <= 1) {
			this.mZ = z;
		}
		else {
			this.mZ = 0;
		}
		this.mOrientation = DataManager.INVALID_ORIENTATION;
	}
	
	/**
	 * Constructor with coordinates and orientation
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param z Z-coordinate
	 * @param orientation orientation code
	 */
	public DataManager(double x, double y, double z, int orientation) {
		
		// set x value if given is valid, otherwise set it to 0
		if (-1 <= x && x <= 1) {
			this.mX = x;
		}
		else {
			this.mX = 0;
		}
		
		// set y value if given is valid, otherwise set it to 0
		if (-1 <= y && y <= 1) {
			this.mY = y;
		}
		else {
			this.mY = 0;
		}
		
		// set z value if given is valid, otherwise set it to 0
		if (-1 <= z && z <= 1) {
			this.mZ = z;
		}
		else {
			this.mZ = 0;
		}

		// set orientation if given is valid, otherwise set it to invalid
		if (0 < orientation && orientation <= 6) {
			this.mOrientation = orientation;
		}
		else {
			this.mOrientation = DataManager.INVALID_ORIENTATION;
		}
	}

/**
 * Retrieves the X-coordinate of the data point.
 * @return the current X-coordinate as a double
 */
	public double getX() {
		return mX;
	}
	
/**
 * Retrieves the Y-coordinate of the data point.
 * @return the current Y-coordinate as a double
 */
	public double getY() {
		return mY;
	}
	
/**
 * Retrieves the Z-coordinate of the data point.
 * @return the current Z-coordinate as a double
 */
	public double getZ() {
		return mZ;
	}
	
/**
 * Retrieves the orientation of the data point.
 * @return the current orientation as an integer
 */
	public int getOrientation() {
		return this.mOrientation;
	}
	
	/**
	 * Sets the orientation of the data point, if the new orientation is in range.
	 * @param newOrientation the new orientation to set
	 * @return true if the orientation was set, false otherwise
	 */
	public boolean setOrientation(int newOrientation) {
		
		// set the orientation to new orientation if its within the set key values 
		if (0 <= newOrientation && newOrientation <= 6) {
			this.mOrientation = newOrientation;
			return true;
		}
		return false;
	}
	
	/**
	 * Compare this DataManager with another one.
	 * @param dm the other DataManager
	 * @return true if the two DataManagers are equal, false otherwise
	 */
	public boolean compare(DataManager dm) {
		
		// compare x values
		if (this.mX != dm.getX()) {
			return false;
		}
		
		// compare y values
		if (this.mY != dm.getY()) {
			return false;
		}
		
		// compare z values
		if (this.mZ != dm.getZ()) {
			return false;
		}
		
		// compare orientations
		if (this.mOrientation != dm.mOrientation) {
			return false;
		}
		
		// there are same data piece if all the above is equal
		return true;
	}
	
	/**
	 * Return a string representation of this DataManager in the format x,y,z,orientation,nameOfOrientation
	 * @return a string representation of this DataManager
	 */
	@Override
	public String toString() {
		String ori;
		if (DataManager.OrientationMap.containsKey(this.mOrientation)) {
			ori = DataManager.OrientationMap.get(this.mOrientation);
		}
		else {
			ori = Integer.toString(this.mOrientation);
		}
		return this.mX+ "," + this.mY + "," + this.mZ + "," +this.mOrientation + "," + ori;
	}
}
