package com.incentro.zombie.game;

import com.incentro.zombie.game.factory.ZombieFactory;

import java.awt.image.BufferedImage;

public class ZombieSpawner extends GameObject
{
    ZombieFactory zombieFactory;

    public ZombieSpawner(BufferedImage image, Integer x, Integer y, Integer width, Integer height, ZombieFactory zombieFactory) {
        super(image, x, y, width, height);
        this.zombieFactory = zombieFactory;
    }
}
