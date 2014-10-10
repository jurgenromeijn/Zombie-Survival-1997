package com.incentro.zombie.weapon;

import java.awt.image.BufferedImage;

import com.incentro.zombie.game.GameObject;

public class Pistol extends GameObject implements IWeaponBehaviour
{
    public Pistol(BufferedImage image, Integer x, Integer y, Integer width, Integer height) {
        super(image, x, y, width, height);
    }
}
