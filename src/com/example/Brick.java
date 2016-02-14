package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick extends Rectangle {
	
	public boolean broken;
	
	public Color color;

	
	Brick(int x, int y, int width, int height, Color color, boolean broken) {
		super(x, y, width, height);
		
		this.color = color;
		this.broken = broken;
	}
	
	public void paintComponent(Graphics g) {
		if (!this.broken) {
			g.setColor(this.color);
			g.fillRect(x, y, width-1, height-1);
		}
	}
}
