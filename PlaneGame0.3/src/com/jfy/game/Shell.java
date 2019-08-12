package com.jfy.game;

import java.awt.Color;
import java.awt.Graphics;

/**
  * ÅÚµ¯Àà
  * @author HomieJ
  *
  */
public class Shell extends Gameobject{
	double degree;
	public Shell() {
		x=200;
		y=200;
		width=10;
		height=10;
		speed=2;
		degree = Math.random()*Math.PI*2;
	}
	public void draw(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x= x+speed*Math.cos(degree);
		y+= speed*Math.sin(degree);
		
		if (x<0||x>Const.GAME_WIDHT-height) {
			degree = Math.PI - degree;
		}
		if (y<30||y>Const.GAME_HEIGHT-width) {
			degree = -degree;
		}
	}
}
