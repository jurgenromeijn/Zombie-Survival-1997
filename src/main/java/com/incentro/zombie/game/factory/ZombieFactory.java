package com.incentro.zombie.game.factory;

import com.incentro.zombie.Game;
import com.incentro.zombie.game.Zombie;
import com.incentro.zombie.resources.Image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jurgenromeijn on 10/10/14.
 */
public class ZombieFactory extends GameObjectFactory {
    private static final String zombieImage1Path = "/images/zombie/zombie1.png";
    private static final String zombieImage2Path = "/images/zombie/zombie2.png";
    private static final String zombieImage3Path = "/images/zombie/zombie3.png";
    private static final String zombieImage4Path = "/images/zombie/zombie4.png";

    Game game;
    List<Image> zombieImages;
    Random random;

    public ZombieFactory(Game game) {
        this.game   = game;
        this.random = new Random();
    }

    private void loadResources() {
        String[] zombieImagePaths = {zombieImage1Path, zombieImage2Path, zombieImage3Path, zombieImage4Path};
        Integer zombieImagePathsLength = zombieImagePaths.length;
        zombieImages = new ArrayList<Image>(zombieImagePathsLength);
        for (Integer i = 0; i < zombieImagePathsLength; i++) {
            BufferedImage image = loadImage(zombieImagePaths[i]);
            if (image != null) zombieImages.add(new Image(image));
        }
    }

    public Zombie create() {
        Integer zombieIndex = random.nextInt(zombieImages.size());
        Image zombieImage = zombieImages.get(zombieIndex);
        Zombie zombie = new Zombie(zombieImage.getImage(), 0, 0, zombieImage.getWidth(), zombieImage.getHeight());
        game.getZombies().add(zombie);
        return zombie;
    }
}
