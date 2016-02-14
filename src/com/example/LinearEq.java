package com.example;

public class LinearEq {
	public double m; // slope
	public double b; // y intercept
	
	public boolean xPositive;
	public boolean yPositive;
	
	public LinearEq(double x1, double y1, double x2, double y2) {
		this.m = (y2 - y1) / (x2 - x1);
		this.b = y2 - (m * x2);
		this.yPositive = y2 >= y1;
		this.xPositive = x2 >= x1;
	}
	
	// exactly 1 of height or width must be 0
	public boolean intersectsLine(double posX, double posY, double height, double width) {
		double y;
		double x;
		if (height != 0) {
			x = posX;
			y = (this.m * x) + this.b;
			if (y >= posY && y <= posY + height) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			y = posY;
			x = (y - this.b) / this.m;
			if (x >= posX && x <= posX + width) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	// return 0 if no intersection, 1 if horizontal intersect, 2 if vertical
	public int intersectsRect(double posX, double posY, double width, double height) {
		double newPosX = 0;
		double newPosY = 0;
		// 4 possible sides of intersection on a rectangle
		if (yPositive && xPositive) {
			// do nothing to posX and posY
			newPosX = posX;
			newPosY = posY;
		}
		else if (yPositive && !xPositive) {
			newPosX = posX + width;
			newPosY = posY;
		}
		else if (!yPositive && xPositive) {
			newPosY = posY + height;
			newPosX = posX;
		}
		else if (!yPositive && !xPositive) {
			newPosY = posY + height;
			newPosX = posX + width;
		}
		if (intersectsLine(newPosX, newPosY, 0, height)) {
			return 2;
		}
		if (intersectsLine(posX, posY, width, 0)) {
			return 1;
		}
		return 0;
	}
}
