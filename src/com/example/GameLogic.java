package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameLogic {
	
	public int windowWidth;
	public int windowHeight;
	
	public int brickWidth = 100;
	public int brickHeight = 50;
	
	Ball ball;
	public int ballWidth = 10;
	
	Paddle paddle;
	public int paddleYOffset = 100;
	public int paddleWidth = 80;
	public int paddleHeight = 10;
	
	ArrayList<Brick> bricks; // assume bricks are placed in sequence
	
	GameLogic(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		addBall();
		addPaddle();
	}
	
	public void paint(Graphics g) {
		paddle.paintComponent(g);
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
	
	public void addBall() {
		this.ball = new Ball(windowWidth, windowHeight, 300, 300, ballWidth, Color.BLACK, bricks);
	}
	
	public void paintBall(Graphics g) {
		g.setColor(ball.color);
		g.fillOval((int)(ball.topX), (int)(ball.topY), ball.width, ball.width);
	}
	
	public void addPaddle() {
		this.paddle = new Paddle(0, windowHeight - paddleYOffset, paddleWidth, paddleHeight, Color.BLUE);
	}
	
	public Brick buildBrick(ArrayList<Brick> bricks) {
		int topX;
		int topY;
		if (bricks.size() == 0) {
			topX = 0;
			topY = 0;
		}
		else {
			Brick lastBrick = bricks.get(bricks.size() - 1);
			
			if (lastBrick.topX + lastBrick.width >= this.windowWidth) {
				topX = 0;
				topY = lastBrick.topY + this.brickHeight;
			}
			else {
				topX = lastBrick.topX + this.brickWidth;
				topY = lastBrick.topY;
			}
		}
		return new Brick(windowWidth, windowHeight, topX, topY, brickWidth-2, brickHeight-2, Color.green);
	}
	
	public void createBricks(int n) {
		bricks = new ArrayList<Brick>();
		for (int i = 0; i < n; i++) {
			bricks.add(buildBrick(bricks));
		}
	}
	
	public void paintBricks(Graphics g) {
		for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			if (!brick.broken) {
				g.setColor(brick.color);
				g.fillRect(brick.topX, brick.topY, brick.width, brick.height);
			}
			
		}
	}
	
}
