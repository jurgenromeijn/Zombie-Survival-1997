package com.incentro.zombie.game;

/**
 * Defines the interface which all computer based characters must implement.
 * @author Joey
 *
 */
public interface IComputerCharBehaviour
{
	void init(Zombie zombie, Player player);
	void move();
	void update(long gametime);
}
