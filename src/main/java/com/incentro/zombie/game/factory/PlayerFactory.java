package com.incentro.zombie.game.factory;

import com.incentro.zombie.Game;
import com.incentro.zombie.game.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by jurgenromeijn on 10/10/14.
 */
public class PlayerFactory {
    Game game;
    BufferedImage playerImage;
    Integer playerImageWidth;
    Integer playerImageHeight;

    public PlayerFactory(Game game) {
        this.game = game;
        loadResources();
    }

    private void loadResources() {
        try {
            URL playerImageURL = this.getClass().getResource("/images/player.png");
            System.out.println(playerImageURL);
            playerImage        = ImageIO.read(playerImageURL);
            playerImageWidth   = playerImage.getWidth();
            playerImageHeight  = playerImage.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player createPlayer() {
        Player player = new Player(playerImage, 100, 100, playerImageWidth, playerImageHeight);
        return player;
    }
}
