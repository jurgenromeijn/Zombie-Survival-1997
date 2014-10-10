package com.incentro.zombie;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.incentro.zombie.game.Player;
import com.incentro.zombie.game.Zombie;
import com.incentro.zombie.game.ZombieSpawner;
import com.incentro.zombie.game.factory.PlayerFactory;
import com.incentro.zombie.game.factory.ZombieFactory;

/**
 * Actual game.
 * 
 * @author www.gametutorial.net
 */

public class Game
{
    private PlayerFactory playerFactory;

    private List<Zombie>	zombies;
	private Player			player;
	private ZombieSpawner	zombieSpawner;

    public Game()
	{
		Framework.gameState = Framework.GameState.GAME_CONTENT_LOADING;

		Thread threadForInitGame = new Thread()
		{
			@Override
			public void run()
			{
				// Sets variables and objects for the game.
				Initialize();
				// Load game files (images, sounds, ...)
				LoadContent();

				Framework.gameState = Framework.GameState.PLAYING;
			}
		};
		threadForInitGame.start();
	}

	/**
	 * Set variables and objects for the game.
	 */
	private void Initialize()
	{
        playerFactory = new PlayerFactory(this);
        ZombieFactory zombieFactory = new ZombieFactory(this);

		// TODO add the bufferedimage instead of null.
		player = playerFactory.create();
		zombies = new ArrayList<Zombie>();
		zombieSpawner = new ZombieSpawner(null, 0, 0, 0, 0, zombieFactory);
	}

	/**
	 * Load game files - images, sounds, ...
	 */
	private void LoadContent()
	{

	}

	/**
	 * Restart game - reset some variables.
	 */
	public void RestartGame()
	{

	}

	/**
	 * Update game logic.
	 * 
	 * @param gameTime
	 *            gameTime of the game.
	 * @param mousePosition
	 *            current mouse position.
	 */
	public void UpdateGame(long gameTime, Point mousePosition)
	{
		player.update(gameTime, mousePosition);
		for (Zombie zombie : zombies)
		{
			zombie.update(gameTime, mousePosition);
		}
		zombieSpawner.update(gameTime, mousePosition);
	}

	/**
	 * Draw the game to the screen.
	 * 
	 * @param g2d
	 *            Graphics2D
	 * @param mousePosition
	 *            current mouse position.
	 */
	public void Draw(Graphics2D g2d, Point mousePosition)
	{
		player.draw(g2d, mousePosition);
		for (Zombie zombie : zombies)
		{
			zombie.draw(g2d, mousePosition);
		}
		zombieSpawner.draw(g2d, mousePosition);
	}

	public PlayerFactory getPlayerFactory()
	{
		return playerFactory;
	}

	public void addZombie(Zombie zombie)
	{
		zombie.getBehaviour().init(zombie, player);
		this.zombies.add(zombie);
	}
	
	public List<Zombie> getZombies()
	{
		return zombies;
	}

	public Player getPlayer()
	{
		return player;
	}

	public ZombieSpawner getZombieSpawner()
	{
		return zombieSpawner;
	}
}
