package com.example;

import java.awt.Color;
import java.util.ArrayList;

public class Ball {
	
	public int windowWidth;
	public int windowHeight;
	
	public ArrayList<Brick> bricks;
	
	// coordinates
	public double topX;
	public double topY;
	// last coordinates
	public double lastTopX;
	public double lastTopY;
	
	public int width;
	
	public Color color;
	
	// positive xSpeed = moving right, positive ySpeed = moving up
	public double xSpeed;
	public double ySpeed;
	
	Ball(int windowWidth, int windowHeight, double topX, double topY, int width, Color color, ArrayList<Brick> bricks) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		this.topX = topX;
		this.topY = topY;
		
		this.width = width;
		
		this.color = color;
		
		this.bricks = bricks;
		
		xSpeed = 1;
		ySpeed = 1;
	}
	
	// returns 0 if no collision, 1 if horizontal collision, 2 if vertical collision,
	// 3 if bottom y collision (game over)
	public int hasCollision(int paddleXPos, int paddleYPos, int paddleWidth, int paddleHeight) {
		int brickCollisionInt = brickCollision(this.bricks);
		if (brickCollisionInt != 0) {
			return brickCollisionInt;
		}
		if (paddleCollision(paddleXPos, paddleYPos, paddleWidth, paddleHeight)) {
			return 1;
		}
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
	
	public int brickCollision(ArrayList<Brick> bricks) {
		for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			if (this.topY + this.width >= brick.topY && this.topY <= brick.topY + brick.height && !brick.broken) {
				if (this.topX + this.width >= brick.topX && this.topX <= brick.topX + brick.width) {
					LinearEq linearEq = new LinearEq(this.lastTopX, this.lastTopY, this.topX, this.topY, this);
					int collisionInt = linearEq.ballIntersectsRect(brick.topX, brick.topY, brick.width, brick.height);
					System.out.println(collisionInt);
					if (collisionInt == 1) {
						brick.broken = true;
						return collisionInt;
					}
					
				}
			}
		}
		return 0;
	}
	
	public boolean paddleCollision(int paddleXPos, int paddleYPos, int paddleWidth, int paddleHeight) {
		if (this.topY + width > paddleYPos && this.topY + width < paddleYPos + paddleHeight) { // ball inside paddle (on y axis)
			if (this.topX >= paddleXPos && this.topX <= paddleXPos + paddleWidth) {
				this.topY = paddleYPos - width;
				return true;
			}
		}
		return false;
	}
	
	public void setNewPosition(int collisionInt) {
		if (collisionInt == 1 || collisionInt == 3) {
			this.ySpeed = -this.ySpeed;
		}
		else if (collisionInt == 2) {
			this.xSpeed = -this.xSpeed;
		}
		this.lastTopX = this.topX;
		this.lastTopY = this.topY;
		
		this.topX += xSpeed;
		this.topY -= ySpeed;
	}
}
