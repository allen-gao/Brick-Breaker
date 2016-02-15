package com.example;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class GameWindow extends JPanel {
	
	public int height;
	public int width;
	
	public int frameRate;
	public int ballSpeed;
	
	public boolean gameScreen = false;
	
	GameLogic gameLogic;

	public GameWindow(int width, int height, int frameRate, int ballSpeed) {
		this.width = width;
		this.height = height;
		this.frameRate = frameRate;
		this.ballSpeed = ballSpeed;
		
		this.setBackground(Color.BLACK);
		this.gameLogic = new GameLogic(width, height);
		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				gameLogic.handleMouseMoveEvent(e);
			}
			public void mouseClicked(MouseEvent e) {
				gameLogic.handleMouseClickEvent(e);
			}
		};
		this.addMouseListener(mouseAdapter);
		this.addMouseMotionListener(mouseAdapter);
		
		this.setLayout(null);
		
		JRadioButton collisionCheatOn = new JRadioButton("Off");
	    JRadioButton collisionCheatOff = new JRadioButton("On");
	    collisionCheatOn.setBounds(width/2 + 30, 311, 50, 30);
	    collisionCheatOn.setBackground(Color.BLACK);
	    collisionCheatOn.setForeground(Color.WHITE);
	    collisionCheatOff.setBounds(width/2 + 80, 311, 50, 30);
	    collisionCheatOff.setBackground(Color.BLACK);
	    collisionCheatOff.setForeground(Color.WHITE);
	    
	    ButtonGroup buttonGroup = new ButtonGroup();
	    buttonGroup.add(collisionCheatOn);
	    buttonGroup.add(collisionCheatOff);
	    this.add(collisionCheatOn);
	    this.add(collisionCheatOff);
	    collisionCheatOn.setSelected(true);
	    
	    JRadioButton infiniteLivesOn = new JRadioButton("Off");
	    JRadioButton infiniteLivesOff = new JRadioButton("On");
	    infiniteLivesOn.setBounds(width/2 + 30, 342, 50, 30);
	    infiniteLivesOn.setBackground(Color.BLACK);
	    infiniteLivesOn.setForeground(Color.WHITE);
	    infiniteLivesOff.setBounds(width/2 + 80, 342, 50, 30);
	    infiniteLivesOff.setBackground(Color.BLACK);
	    infiniteLivesOff.setForeground(Color.WHITE);
	    
	    ButtonGroup buttonGroup2 = new ButtonGroup();
	    buttonGroup2.add(infiniteLivesOn);
	    buttonGroup2.add(infiniteLivesOff);
	    this.add(infiniteLivesOn);
	    this.add(infiniteLivesOff);
	    infiniteLivesOn.setSelected(true);
	    
	    this.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clear the previous paint
		if (gameScreen) {
			gameLogic.paint(g);
		}
		else {
			paintSplashScreen(g);
		}
	}
	
	public void paintSplashScreen(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.BOLD, 50));
		drawCenterString(g, "Breakout!", 50, 0);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		drawCenterString(g, "Created by Allen Gao, 20529760", 80, 0);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		drawCenterString(g, "Use the mouse to aim where you want the ball to shoot.", 130, 0);
		drawCenterString(g, "Once you're ready, simply left click and start playing!", 150, 0);
		
		drawCenterString(g, "You have 3 lives to try and get the highest score possible.", 200, 0);
		drawCenterString(g, "Good luck!", 220, 0);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
		drawCenterString(g, "Cheats", 300, 0);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		drawCenterString(g, "Bounce on bottom screen:", 330, -60);
		drawCenterString(g, "Infinite lives:", 360, -20);
	}
	
	public void drawCenterString(Graphics g, String myString, int y, int xOffset) {
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rect2D = fm.getStringBounds(myString, g);
		int x = (width - (int)(rect2D.getWidth())) / 2;
		x += xOffset;
		g.drawString(myString, x, y);
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
				gameLogic.runGame();
			}
		};
		new Timer(delay, taskPerformer).start();
	}
}
