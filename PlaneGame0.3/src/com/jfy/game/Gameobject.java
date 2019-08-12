package com.jfy.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Gameobject {
	 Image image;
	 double x , y;
	 int speed;
	 int width;
	 int height;
	public Gameobject(Image image, double x, double y) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
	}
	public void drawSelf(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		
	}
	public Gameobject(Image image, double x, double y, int speed, int width) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
	}
	public Gameobject(){
		
	}
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y,width,height);
}
}
