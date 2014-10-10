package com.incentro.zombie.game;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.incentro.zombie.Canvas;

public class Player extends Entity
{

	public Player(BufferedImage image, Integer x, Integer y, Integer width, Integer height)
	{
		super(image, x, y, width, height, 2);
	}

	public void move()
	{	
		boolean isWPressed = Canvas.keyboardKeyState(KeyEvent.VK_W);
		boolean isDPressed = Canvas.keyboardKeyState(KeyEvent.VK_D);
		boolean isAPressed = Canvas.keyboardKeyState(KeyEvent.VK_A);
		boolean isSPressed = Canvas.keyboardKeyState(KeyEvent.VK_S);
		
		int xPosition = getX();
		int yPosition = getY();
		
		if (isAPressed)
		{
			xPosition -= getSpeed();
		}
		if (isDPressed)
		{
			xPosition += getSpeed();
		}
		if (isWPressed)
		{
			yPosition -= getSpeed();
		}
		if (isSPressed)
		{
			yPosition += getSpeed();
		}		

		setX(xPosition);
		setY(yPosition);
	}

}
