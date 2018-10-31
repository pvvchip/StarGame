package com.pvvchip.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.pvvchip.game.base.Sprite;

public class Play extends Sprite {
    public Play(TextureAtlas atlas) {
        super(atlas.findRegion("btPlay"));
        setHeightProportion(0.1f);
        pos.set(-0.3f, -0.4f);
    }
}
