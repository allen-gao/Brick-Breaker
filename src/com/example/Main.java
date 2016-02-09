package com.example;

import java.awt.event.*;
import javax.swing.*;

public class Main extends JComponent {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame("Brick Breaker");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				JPanel panel = new JPanel();
				JButton button = new JButton("Ok");
				panel.add(button);
				button.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						System.exit(1);
					}
				});
				
				frame.add(panel);
				
				frame.setResizable(true);
				frame.setSize(500, 500);
				frame.setVisible(true);
			}
		});
	}
}
