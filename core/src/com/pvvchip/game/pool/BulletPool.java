package com.pvvchip.game.pool;

import com.pvvchip.game.base.SpritesPool;
import com.pvvchip.game.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
