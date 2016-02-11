package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class Paddle extends JComponent implements MouseMotionListener {
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		System.out.println(this.getWidth());
	}
	
	
	/*
	protected void processMouseMotionEvent(MouseEvent e) {
		// only detects button state WHILE moving!
		if (e.getID() == MouseEvent.MOUSE_DRAGGED)
			colour = Color.RED;
		else
			colour = Color.GRAY;
		x = e.getX();
		y = e.getY();
		repaint();
	}
	*/

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
