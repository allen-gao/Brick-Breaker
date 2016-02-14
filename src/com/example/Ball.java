package com.example;

import java.awt.Color;
import java.util.ArrayList;

public class Ball {
	
	public int windowWidth;
	public int windowHeight;
	
	// coordinates
	public double topX;
	public double topY;
	
	public int width;
	
	public Color color;
	
	// positive xSpeed = moving right, positive ySpeed = moving up
	public double xSpeed;
	public double ySpeed;
	
	Ball(int windowWidth, int windowHeight, double topX, double topY, int width, Color color) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		this.topX = topX;
		this.topY = topY;
		
		this.width = width;
		
		this.color = color;
		
		xSpeed = 10;
		ySpeed = 10;
	}
	
	// returns 0 if no collision, 1 if horizontal collision, 2 if vertical collision,
	// 3 if bottom y collision (game over)
	public int hasCollision() {
		if (this.topX < 0) {
			this.topX = 0;
			return 2;
		}
		else if (this.topX + this.width > this.windowWidth) {
			this.topX = this.windowWidth - this.width;
			return 2;
		}
		else if (this.topY < 0) {
			this.topY = 0;
			return 1;
		}
		else if (this.topY > this.windowHeight)
			return 3;
		else
			return 0;
	}
	
	public void setNewPosition(int collisionInt) { 
		if (collisionInt == 1 || collisionInt == 3) {
			this.ySpeed = -this.ySpeed;
		}
		else if (collisionInt == 2) {
			this.xSpeed = -this.xSpeed;
		}
		this.topX += xSpeed;
		this.topY -= ySpeed;
	}
}
