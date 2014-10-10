package com.incentro.zombie.game.factory;

import com.incentro.zombie.Framework;
import com.incentro.zombie.Game;
import com.incentro.zombie.game.IComputerCharBehaviour;
import com.incentro.zombie.game.Zombie;
import com.incentro.zombie.game.ZombieFollowPlayerBehaviour;
import com.incentro.zombie.game.ZombieRandomBehaviour;
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
        loadResources();
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

        Integer positionX = random.nextInt(Framework.frameWidth - zombieImage.getWidth());
        Integer positionY = random.nextInt(Framework.frameHeight - zombieImage.getHeight());

        int amountOfBehaviours = 2;
        int chosenBehaviour = new Random().nextInt(amountOfBehaviours);
        IComputerCharBehaviour beh;
        if(chosenBehaviour == 0)
        {
        	beh = new ZombieFollowPlayerBehaviour();
        }
        else
        {
        	beh = new ZombieRandomBehaviour();
        }
        
        Zombie zombie = new Zombie(zombieImage.getImage(), positionX, positionY, zombieImage.getWidth(), zombieImage.getHeight(), beh);
        game.addZombie(zombie);
        
        return zombie;
    }
}
