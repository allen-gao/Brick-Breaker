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
	
	public int paddleXPos;
	public int paddleYPos;
	public int paddleYOffset = 100;
	
	public int paddleWidth = 80;
	public int paddleHeight = 10;
	
	GameLogic gameLogic;

	public GameWindow(int width, int height) {
		this.width = width;
		this.height = height;
		this.setBackground(Color.WHITE);
		
		this.gameLogic = new GameLogic(width, height);
		
		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				if (x > width - paddleWidth/2)
					x = width - paddleWidth/2;
				if (x < paddleWidth/2)
					x = paddleWidth/2;
				x -= paddleWidth/2;
				paddleXPos = x;
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clear the previous paint
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		paddleYPos = height - paddleYOffset;
		g2.fillRect(paddleXPos, paddleYPos, paddleWidth, paddleHeight);
		
		gameLogic.paintBricks(g);
	}
	
	public void runEvents() {
		int delay = 30; //milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};
		new Timer(delay, taskPerformer).start();
	}
}
