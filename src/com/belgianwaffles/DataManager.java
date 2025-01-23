package com.belgianwaffles;

public class DataManager {
	private double mX, mY, mZ;
	
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
}
