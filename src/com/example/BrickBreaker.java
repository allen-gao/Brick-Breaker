package com.example;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BrickBreaker extends JFrame {
	
	public static GameWindow gameWindow;
	public static int width = 800;
	public static int height = 600;
	
	public static int numBricks = 30;
	
	public BrickBreaker() {
		super();
		this.setTitle("Brick Breaker");
		this.setSize(width, height);
		this.getContentPane().setLayout(new GridLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BrickBreaker frame = new BrickBreaker();
				
				gameWindow = new GameWindow(width, height);
				frame.add(gameWindow);
				gameWindow.runEvents();
				gameWindow.gameLogic.createBricks(numBricks);
			}
		});
	}
}

