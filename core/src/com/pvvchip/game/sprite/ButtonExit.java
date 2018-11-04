package com.pvvchip.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.pvvchip.game.base.ActionListener;
import com.pvvchip.game.base.ScaledTouchUpButton;
import com.pvvchip.game.math.Rect;

public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("btExit"), actionListener);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setRight(worldBounds.getRight());
    }
}
