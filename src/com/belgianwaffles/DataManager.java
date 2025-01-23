package com.belgianwaffles;

import java.util.HashMap;
import java.util.Map;

public class DataManager {
	private double mX, mY, mZ;
	private int mOrientation;
	
	private static final Map<Integer, String> mOrientationMap = new HashMap<>();
	static {
		DataManager.mOrientationMap.put(1, "Face up");
		DataManager.mOrientationMap.put(2, "Face down");
		DataManager.mOrientationMap.put(3, "Portrait");
		DataManager.mOrientationMap.put(4, "Portrait upside down");
		DataManager.mOrientationMap.put(5, "Landscape left");
		DataManager.mOrientationMap.put(6, "Landscape right");
	}
	
	public DataManager() {
		this.mX = 0;
		this.mY = 0;
		this.mZ = 0;
	}
	
	public DataManager(double x, double y, double z) {
		if (-1 <= x && x <= 1) {
			this.mX = x;
		}
		else {
			this.mX = 0;
		}
		if (-1 <= y && y <= 1) {
			this.mY = y;
		}
		else {
			this.mY = 0;
		}
		if (-1 <= z && z <= 1) {
			this.mZ = z;
		}
		else {
			this.mZ = 0;
		}
		
		this.determineOrientation();
	}
	
	public DataManager(double x, double y, double z, int orientation) {
		if (-1 <= x && x <= 1) {
			this.mX = x;
		}
		else {
			this.mX = 0;
		}
		if (-1 <= y && y <= 1) {
			this.mY = y;
		}
		else {
			this.mY = 0;
		}
		if (-1 <= z && z <= 1) {
			this.mZ = z;
		}
		else {
			this.mZ = 0;
		}

		this.mOrientation = orientation;
	}
	
	private void determineOrientation() {
		// Default to orientation 1
		this.mOrientation = 1;
	}

	public double getX() {
		return mX;
	}
	
	public double getY() {
		return mY;
	}
	
	public double getZ() {
		return mZ;
	}
	
	public String getOrientation() {
		if (DataManager.mOrientationMap.containsKey(this.mOrientation)) {
			return DataManager.mOrientationMap.get(this.mOrientation);
		}
		return "Not a valid orientation";
	}
	
	@Override
	public String toString() {
		return "X: " + this.getX() + ", Y: " + this.getY() + ", Z: " + this.getZ() + ", Orientation: " + this.getOrientation();
	}
}
