package com.pvvchip.game.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pvvchip.game.base.SpritesPool;
import com.pvvchip.game.sprite.Explosion;

public class ExplosionPool extends SpritesPool<Explosion> {

    private Sound sound;
    private TextureRegion region;

    public ExplosionPool(TextureAtlas atlas, Sound sound) {
        this.region = atlas.findRegion("explosion");
        this.sound = sound;
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(region, 9, 9, 74, sound);
    }
}
