package com.incentro.zombie.game;

import java.awt.image.BufferedImage;

public class Zombie extends Entity
{
    public Zombie(BufferedImage image, Integer x, Integer y, Integer width, Integer height) {
        super(image, x, y, width, height, 2);
    }
}
