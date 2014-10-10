package com.incentro.zombie.game.factory;

import com.incentro.zombie.Framework;
import com.incentro.zombie.Game;
import com.incentro.zombie.game.Player;
import com.incentro.zombie.resources.Image;

/**
 * Created by jurgenromeijn on 10/10/14.
 */
public class PlayerFactory extends GameObjectFactory {
    private static final String playerImagePath = "/images/player.png";

    Game game;
    Image playerImage;

    public PlayerFactory(Game game) {
        this.game = game;
        loadResources();
    }

    private void loadResources() {
        playerImage = new Image(this.loadImage(playerImagePath));
    }

    public Player create() {
        Player player = new Player(playerImage.getImage(), Framework.frameWidth / 2, Framework.frameHeight / 2, playerImage.getWidth(), playerImage.getHeight());
        return player;
    }
}
