package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BrickBreaker extends JComponent implements MouseMotionListener {
	
	//static Paddle myPaddle;
	int pX;
	int pY;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.fillRect(350, 500, 100, 20);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Brick Breaker");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				BrickBreaker canvas = new BrickBreaker(); 
						
				frame.setResizable(true);
				frame.setSize(800, 600);
				frame.setVisible(true);
				frame.setContentPane(canvas);
				//frame.getContentPane().setLayout(new GridLayout());
			}
		});
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("gfdgdfgdf");
		pX = e.getX();
		pY = e.getY();
	}
}
