package com.incentro.zombie.game;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Zombie extends Entity
{
	private IComputerCharBehaviour behaviour;
	
    public Zombie(BufferedImage image, Integer x, Integer y, Integer width, Integer height, IComputerCharBehaviour behaviour) {
        super(image, x, y, width, height, 2);
        this.behaviour = behaviour;
    }

	@Override
	public void update(long gameTime, Point mousePosition)
	{
		super.update(gameTime, mousePosition);
		behaviour.update(gameTime);
		behaviour.move();
	}

	public IComputerCharBehaviour getBehaviour()
	{
		return behaviour;
	}
    
}
