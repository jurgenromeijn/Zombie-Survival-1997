package com.incentro.zombie.game;

import java.awt.image.BufferedImage;

public class Entity extends GameObject
{
	private Integer speed;
	
    public Entity(BufferedImage image, Integer x, Integer y, Integer width, Integer height, Integer speed) {
        super(image, x, y, width, height);
        this.speed = speed;
    }
    
    public Integer getSpeed()
    {
    	return this.speed;
    }
    
    public void setSpeed(final Integer speed)
    {
    	this.speed = speed;
    }
}
