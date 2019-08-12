package com.jfy.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends Gameobject{
	boolean left , up , right , down;
	int speed=4;
	boolean live = true;
	public Plane(Image plane, int i, int j) {
		this.image=plane;
		this.x= i;
		this.y = j;
		this.speed=3;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
	}

	@Override
	public void drawSelf(Graphics g) {
		
		if (live) {
			g.drawImage(image, (int)x, (int)y, null);
			if (left) {
				x-=speed;
			}
			if (down) {
				y+=speed;
			}
			if (right) {
				x+=speed;
			}
			if (up) {
				y-=speed;
			}
		}else {
			g.drawString("peng", 150, 250);
		}
		
	}
	//增加方向  摁下某个键增加相同方向
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
				right = true;
				break;
		case KeyEvent.VK_DOWN:
				down=true;
				break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getKeyCode());
		}

	}
	//取消方向
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
				right = false;
				break;
		case KeyEvent.VK_DOWN:
				down=false;
				break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getKeyCode());
		}

	}
}
