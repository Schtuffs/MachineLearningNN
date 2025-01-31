package com.belgianwaffles;

import java.util.HashMap;
import java.util.Map;

public class DataManager {
	private double mX, mY, mZ;
	private int mOrientation;
	
	public static final int INVALID_ORIENTATION = 0; 
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
	
	public DataManager() {
		this.mX = 0;
		this.mY = 0;
		this.mZ = 0;
		this.mOrientation = DataManager.INVALID_ORIENTATION;
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
		this.mOrientation = DataManager.INVALID_ORIENTATION;
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

		if (0 < orientation && orientation <= 6) {
			this.mOrientation = orientation;
		}
		else {
			this.mOrientation = DataManager.INVALID_ORIENTATION;
		}
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
	
	public int getOrientation() {
		return this.mOrientation;
	}
	
	public boolean setOrientation(int newOrientation) {
		if (0 <= newOrientation && newOrientation <= 6) {
			this.mOrientation = newOrientation;
			return true;
		}
		return false;
	}
	
	public boolean compare(DataManager dm) {
		if (this.mX != dm.getX()) {
			return false;
		}
		if (this.mY != dm.getY()) {
			return false;
		}
		if (this.mZ != dm.getZ()) {
			return false;
		}
		
		if (this.mOrientation != dm.mOrientation) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		String ori = DataManager.OrientationMap.get(this.mOrientation);
		return this.mX+ "," + this.mY + "," + this.mZ + "," +this.mOrientation + "," + ori;
	}
}
