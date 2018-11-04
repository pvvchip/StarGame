package com.pvvchip.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pvvchip.game.base.Sprite;
import com.pvvchip.game.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
