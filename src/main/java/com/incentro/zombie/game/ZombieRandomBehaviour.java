package com.incentro.zombie.game;

import java.util.Random;

import com.incentro.zombie.Framework;

public class ZombieRandomBehaviour implements IComputerCharBehaviour
{
	private Zombie	zombie;
	private Player	player;

	private Long	timeSinceLastMove	= 0l;
	private Long	lastUpdateTime		= 0l;

	private int		xMoving				= 0;
	private int		yMoving				= 0;

	public void init(Zombie zombie, Player player)
	{
		this.zombie = zombie;
		this.player = player;
	}

	public void move()
	{

	}

	public void update(long gametime)
	{
		if (timeSinceLastMove > (0.3 * Framework.secInNanosec))
		{
			Random rand = new Random();

			int moveX = rand.nextInt(2);
			int moveY = rand.nextInt(2);

			if (moveX == 0)
			{
				moveX = -1;
			}
			if (moveY == 0)
			{
				moveY = -1;
			}

			xMoving = moveX * zombie.getSpeed();
			yMoving = moveY * zombie.getSpeed();

			timeSinceLastMove = 0l;
		}
		else
		{
			zombie.setX(zombie.getX() + xMoving);
			zombie.setY(zombie.getY() + yMoving);
			timeSinceLastMove += gametime - lastUpdateTime;
			lastUpdateTime = gametime;
		}
	}

}
