package com.incentro.zombie.resources;

import java.awt.image.BufferedImage;

/**
 * Created by jurgenromeijn on 10/10/14.
 */
public class Image {
    BufferedImage image;
    Integer width;
    Integer height;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image  = image;
        this.width  = image.getWidth();
        this.height = image.getHeight();
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Image(BufferedImage image) {
        setImage(image);
    }
}
