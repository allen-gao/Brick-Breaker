package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameWindow extends JPanel {
	
	public int height;
	public int width;
	
	GameLogic gameLogic;

	public GameWindow(int width, int height) {
		this.width = width;
		this.height = height;
		this.setBackground(Color.WHITE);
		
		this.gameLogic = new GameLogic(width, height);
		
		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				gameLogic.handleMouseEvent(e);
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clear the previous paint
		gameLogic.paint(g);
	}
	
	public void runEvents() {
		int delay = 5; //milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
				//int collisionInt = gameLogic.ball.hasCollision(paddleXPos, paddleYPos, paddleWidth, paddleHeight);
				//gameLogic.ball.setNewPosition(collisionInt);
			}
		};
		new Timer(delay, taskPerformer).start();
	}
}
