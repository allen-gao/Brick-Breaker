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
	
	public int frameRate;
	public int ballSpeed;
	
	GameLogic gameLogic;

	public GameWindow(int width, int height, int frameRate, int ballSpeed) {
		this.width = width;
		this.height = height;
		this.frameRate = frameRate;
		this.ballSpeed = ballSpeed;
		
		this.setBackground(Color.BLACK);
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
	
	public void repaintWithFrameRate(int frameRate) {
		int delay = (int)(1000 / frameRate); //milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};
		new Timer(delay, taskPerformer).start();
	}
	
	public void runEvents() {
		int delay = this.ballSpeed; //milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int collisionInt = gameLogic.hasCollision();
				gameLogic.moveBall(collisionInt);
			}
		};
		new Timer(delay, taskPerformer).start();
	}
}
