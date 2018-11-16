package com.pvvchip.game.pool;

import com.badlogic.gdx.audio.Sound;
import com.pvvchip.game.base.SpritesPool;
import com.pvvchip.game.math.Rect;
import com.pvvchip.game.sprite.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Rect worldBounds;
    private Sound shootSound;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, Sound shootSound) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.shootSound = shootSound;
        this.explosionPool = explosionPool;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, explosionPool, worldBounds, shootSound);
    }
}
