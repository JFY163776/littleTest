package com.jfy.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	private GameUtil() {

}
	/**
	 * 指定路径的文件对象
	 * @param pathString
	 * @return
	 */
	public static Image getImage(String pathString) {
		BufferedImage bImage = null;
		URL u = GameUtil.class.getClassLoader().getResource(pathString);
		try {
			bImage = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bImage;
	}
}
