package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameLogic {
	
	public int windowWidth;
	public int windowHeight;
	
	Ball ball;
	public int ballWidth = 10;
	
	Paddle paddle;
	public int paddleYOffset = 100;
	public int paddleWidth = 80;
	public int paddleHeight = 10;
	
	ArrayList<Brick> bricks; // assume bricks are placed in sequence
	public int brickWidth = 100;
	public int brickHeight = 50;
	
	
	GameLogic(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.ball = new Ball(windowWidth, windowHeight, 300, 300, ballWidth, Color.BLACK, bricks);
		this.paddle = new Paddle(0, windowHeight - paddleYOffset, paddleWidth, paddleHeight, Color.BLUE);
	}
	
	public void paint(Graphics g) {
		paddle.paintComponent(g);
		for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			brick.paintComponent(g);
		}
	}
	
	public void handleMouseEvent(MouseEvent e) {
		int x = e.getX();
		if (x > windowWidth - paddle.width/2)
			x = windowWidth - paddle.width/2;
		if (x < paddle.width/2)
			x = paddle.width/2;
		x -= paddle.width/2;
		paddle.setLocation(x, paddle.y);
	}
	
	public void paintBall(Graphics g) {
		g.setColor(ball.color);
		g.fillOval((int)(ball.topX), (int)(ball.topY), ball.width, ball.width);
	}
	
	public Brick buildBrick(ArrayList<Brick> bricks) {
		int topX;
		int topY;
		boolean broken = false;
		if (bricks.size() == 0) {
			topX = 0;
			topY = 0;
		}
		else {
			Brick lastBrick = bricks.get(bricks.size() - 1);
			
			if (lastBrick.x + lastBrick.width >= this.windowWidth) {
				topX = 0;
				topY = lastBrick.y + this.brickHeight;
			}
			else {
				topX = lastBrick.x + this.brickWidth;
				topY = lastBrick.y;
			}
		}
		return new Brick(topX, topY, brickWidth-2, brickHeight-2, Color.green, broken);
	}
	
	public void createBricks(int n) {
		bricks = new ArrayList<Brick>();
		for (int i = 0; i < n; i++) {
			bricks.add(buildBrick(bricks));
		}
	}
}
