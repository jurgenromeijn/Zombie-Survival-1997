package com.incentro.zombie.game;

import com.incentro.zombie.Framework;
import com.incentro.zombie.game.factory.ZombieFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ZombieSpawner extends GameObject
{
	ZombieFactory	zombieFactory;
	Long			timeSinceLastSpawn	= 0l;
	Long			lastUpdateTime		= 0l;
	private int		timesSpawned		= 0;

	public ZombieSpawner(BufferedImage image, Integer x, Integer y, Integer width, Integer height, ZombieFactory zombieFactory)
	{
		super(image, x, y, width, height);
		this.zombieFactory = zombieFactory;
	}

	public void update(long gameTime, Point mousePosition)
	{
		if (timeSinceLastSpawn > (5 * Framework.secInNanosec))
		{
			spawn();
			timeSinceLastSpawn = 0l;
		}
		timeSinceLastSpawn += gameTime - lastUpdateTime;
		lastUpdateTime = gameTime;
		super.update(gameTime, mousePosition);
	}

	private void spawn()
	{
		timesSpawned += 1;
		int amount = new Random().nextInt(timesSpawned) + 1;
		
		System.out.println("Spawning " + amount + " zombies");
		
		for(int i = 0; i < amount; i++)
		{
			zombieFactory.create();
		}
	}
}
