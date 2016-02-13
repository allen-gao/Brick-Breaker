package com.example;

import java.awt.Color;
import java.util.ArrayList;

public class Ball {
	
	public int windowWidth;
	public int windowHeight;
	
	// coordinates
	public int topX;
	public int topY;
	
	public int width;
	
	public Color color;
	
	Ball(int windowWidth, int windowHeight, int topX, int topY, int width, Color color) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		this.topX = topX;
		this.topY = topY;
		
		this.width = width;
		
		this.color = color;
	}
}
