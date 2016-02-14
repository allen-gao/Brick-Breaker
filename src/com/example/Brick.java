package com.example;

import java.awt.Color;
import java.util.ArrayList;

public class Brick {
	
	public int windowWidth;
	public int windowHeight;
	
	// coordinates
	public int topX;
	public int topY;
	
	public int width;
	public int height;
	
	public boolean broken;
	
	public Color color;
	
	Brick(int windowWidth, int windowHeight, int topX, int topY, int width, int height, Color color) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		this.topX = topX;
		this.topY = topY;
		
		this.width = width;
		this.height = height;
		
		this.color = color;
	}
}
