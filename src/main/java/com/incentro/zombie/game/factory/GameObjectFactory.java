package com.incentro.zombie.game.factory;

import com.incentro.zombie.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by jurgenromeijn on 10/10/14.
 */
public abstract class GameObjectFactory {

    abstract GameObject create();

    protected BufferedImage loadImage(String path) {
        BufferedImage image = null;
        try {
            URL imageURL = this.getClass().getResource(path);
            image = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
