package com.incentro.zombie.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public abstract class GameObject implements ImageObserver
{
	private BufferedImage	image;
	private int x,y;
	
	public GameObject(BufferedImage image)
	{
		this.image = image;
	}

	public void update(long gameTime, Point mousePosition)
	{

	}

	public void draw(Graphics2D g2d, Point mousePosition)
	{
		g2d.drawImage(image, x, y, this);
	}

	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height)
	{
		return false;
	}		
}
