package com.jfy.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;





public class MyGameFrame extends JFrame{
	 
	Image plane = GameUtil.getImage("images/plane.png");
	
	Plane p = new Plane(plane,250,250);
	Shell []s = new Shell[100];
	Date startTime = new Date();
	Date endTime = new Date();
	int preiod; //��Ϸ������ʱ��
	int count=0;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		p.drawSelf(g);
		for (Shell shell : s) {
			shell.draw(g);
			boolean intersects = shell.getRect().intersects(p.getRect());
			if (intersects) {
				p.live = false;
				endTime = new Date();
				if (count==0) {
					preiod = (int)((endTime.getTime()-startTime.getTime())/1000);
					count++;
				}
				
			}
		}
		if (!p.live) {
			Font font = g.getFont();
			Color color = g.getColor();
			g.setColor(Color.red);
			Font font2 = new Font("����",Font.BOLD,50);
			g.setFont(font2);
			g.drawString(preiod+"", (int)p.x, (int)p.y);
			g.setFont(font);
			g.setColor(color);
		}
		
	}
	
	//�����ػ�����
	class PaintThread extends Thread{
		@Override
		public void run() {
			while(true) {
				repaint();  //�ػ�
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//���̷���  ���̼����ڲ���
	class Keymonnitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
		
	}
	/**
	 * ��ʼ������
	 */
	
	public void launchFrame() {
		this.setTitle("����");
		this.setVisible(true);
		this.setSize(Const.GAME_WIDHT, Const.GAME_HEIGHT);
		this.setLocation(200, 200);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		PaintThread paintThread = new PaintThread();
		paintThread.start();
		addKeyListener(new Keymonnitor());
		//��ʼ��100���ڵ�
		for (int i = 0; i < s.length; i++) {
			s[i] = new Shell();
		}
	}
	public static void main(String[] args) {
		MyGameFrame myGameFrame = new MyGameFrame();
		myGameFrame.launchFrame();
	}
}
