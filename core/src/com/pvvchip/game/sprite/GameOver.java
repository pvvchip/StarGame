package com.pvvchip.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.pvvchip.game.base.Sprite;

public class GameOver extends Sprite {
    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(0.05f);
    }
}
