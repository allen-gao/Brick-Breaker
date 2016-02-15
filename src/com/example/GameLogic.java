package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GameLogic {
	
	public int windowWidth;
	public int windowHeight;
	
	Ball ball;
	public int ballLength = 10;
	public double ballXSpeed = 2;
	public double ballYSpeed = 2;
	
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
		this.ball = new Ball(300, 300, ballLength, ballXSpeed, ballYSpeed, Color.BLACK);
		this.paddle = new Paddle(0, windowHeight - paddleYOffset, paddleWidth, paddleHeight, Color.BLUE);
	}
	
	public void paint(Graphics g) {
		paddle.paintComponent(g);
		paintBricks(g);
		ball.paintComponent(g);
	}
	
	public void paintBricks(Graphics g) {
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
	
	public void moveBall(int collisionInt) {
		if (collisionInt == 1 || collisionInt == 3) {
			ball.ySpeed = -ball.ySpeed;
		}
		else if (collisionInt == 2) {
			ball.xSpeed = -ball.xSpeed;
		}
		ball.lastX = ball.x;
		ball.lastY = ball.y;
		
		ball.setFrame(ball.x + ball.xSpeed, ball.y - ball.ySpeed, ball.length, ball.length);
	}
	
	
	public int hasCollision() {
		// returns 0 if no collision, 1 if horizontal collision, 2 if vertical collision,
		// 3 if bottom y collision (game over)
		int brickCollisionInt = brickCollision(this.bricks);
		if (brickCollisionInt != 0) {
			return brickCollisionInt;
		}	
		if (paddleCollision() != 0) {
			return 1;
		}
		return windowCollision();	
	}
	
	public int paddleCollision() {
		if (ball.intersects(paddle))
			return 1;
		return 0;
	}
	
	public int brickCollision(ArrayList<Brick> bricks) {
		for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			if (!brick.broken && ball.intersects(brick)) {
				brick.broken = true;
				int myint = brickCollisionType(brick);
				System.out.println(myint);
				return myint;
			}
		}
		return 0;
	}
	
	public int brickCollisionType(Brick brick) {
		// assuming collision exists
		// utilizing the Minkowski sum
		// source: http://gamedev.stackexchange.com/questions/29786/a-simple-2d-rectangle-collision-algorithm-that-also-determines-which-sides-that
		double width = 0.5 * (ball.length + brick.width);
		double height = 0.5 * (ball.length + brick.height);
		double xDistance = ball.getCenterX() - brick.getCenterX();
		double yDistance = ball.getCenterY() - brick.getCenterY();
		
		double widthY = width * yDistance;
		double heightX = height * xDistance;
		
		if (widthY > heightX) {
			if (widthY > -heightX) { //collision at the top
				return 1;
			}
			else { // collision on the left
				return 2;
			}
		}
		else {
			if (widthY > -heightX) { // collision on the right
				return 2;
			}
			else { // collision at the bottom
				return 1;
			}
		}
	}
	
	public int windowCollision() {
		if (ball.x < 0) {
			ball.x = 0;
			return 2;
		}
		else if (ball.x + ball.length > this.windowWidth) {
			ball.x = this.windowWidth - ball.length;
			return 2;
		}
		else if (ball.y < 0) {
			ball.y = 0;
			return 1;
		}
		else if (ball.y > this.windowHeight)
			return 3;
		else
			return 0;
	}
	
}
