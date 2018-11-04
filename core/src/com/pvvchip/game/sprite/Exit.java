package com.pvvchip.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pvvchip.game.base.Sprite;

public class Exit extends Sprite {
    public Exit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
        setHeightProportion(0.1f);
        pos.set(0.3f, -0.4f);
    }
}
