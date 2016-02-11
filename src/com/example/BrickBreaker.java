package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BrickBreaker extends JComponent {
	
	static Paddle myPaddle;
	
	public void paintComponent(Graphics g) {
		//Graphics2D g2 = (Graphics2D) g;
		//g2.setStroke(new BasicStroke(32));
		//g2.setColor(Color.blue);
		//g2.drawLine(0, 0, getWidth(), getHeight());
	}


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame("Brick Breaker");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				BrickBreaker canvas = new BrickBreaker(); 
						
				//JPanel panel = new JPanel();
				JButton button = new JButton("Ok");
				/*
				panel.add(button);
				button.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						System.exit(1);
					}
				});
				
				//frame.add(panel);
				*/
				myPaddle = new Paddle();
				myPaddle.setLocation(10, 10);
				myPaddle.setSize(10, 10);

				canvas.add(myPaddle);
				frame.setResizable(true);
				frame.setSize(600, 600);
				frame.setVisible(true);
				frame.setContentPane(canvas);
				//frame.getContentPane().setLayout(new GridLayout());
				
				
				
				
				
			}
		});
	}
}
