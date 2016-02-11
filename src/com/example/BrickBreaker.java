package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BrickBreaker extends JFrame {
	
	static Paddle myPaddle;
	
	public BrickBreaker() {
		super();
		this.setTitle("Brick Breaker");
		this.setSize(800,  600);
		this.getContentPane().setLayout(new GridLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
		//Graphics2D g2 = (Graphics2D) g;
		//g2.setStroke(new BasicStroke(32));
		//g2.setColor(Color.blue);
		//g2.drawLine(0, 0, getWidth(), getHeight());
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BrickBreaker frame = new BrickBreaker(); 
					
				myPaddle = new Paddle();
				myPaddle.setLocation(0, 0);
				//myPaddle.set
				myPaddle.setSize(10, 10);
				frame.add(myPaddle);
				 
				
				
			}
		});
	}
}
