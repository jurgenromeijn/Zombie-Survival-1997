package com.incentro.zombie.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public abstract class GameObject implements ImageObserver
{
	private BufferedImage	image;
    private Integer x,y,width,height;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public GameObject(BufferedImage image, Integer x, Integer y, Integer width, Integer height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
