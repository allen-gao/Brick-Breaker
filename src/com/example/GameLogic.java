package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameLogic {
	
	public int windowWidth;
	public int windowHeight;
	
	public int brickWidth = 100;
	public int brickHeight = 30;
	
	ArrayList<Brick> bricks; // assume bricks are placed in sequence
	
	GameLogic(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}
	
	public Brick buildBrick(ArrayList<Brick> bricks) {
		int topX;
		int botY;
		if (bricks.size() == 0) {
			topX = 0;
			botY = brickHeight;
		}
		else {
			Brick lastBrick = bricks.get(bricks.size() - 1);
			
			if (lastBrick.topX + lastBrick.width >= this.windowWidth) {
				topX = 0;
				botY = lastBrick.botY + this.brickHeight;
			}
			else {
				topX = lastBrick.topX + this.brickWidth;
				botY = lastBrick.botY;
			}
		}
		return new Brick(windowWidth, windowHeight, topX, botY, brickWidth-2, brickHeight-2, Color.green);
	}
	
	public void createBricks(int n) {
		bricks = new ArrayList<Brick>();
		for (int i = 0; i < n; i++) {
			bricks.add(buildBrick(bricks));
		}
	}
	
	public void paintBricks(Graphics g) {
		//g.fillRect(10, 10, 100, 100);
		for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			g.setColor(brick.color);
			g.fillRect(brick.topX, brick.botY - brick.height, brick.width, brick.height);
		}
	}
	
}
