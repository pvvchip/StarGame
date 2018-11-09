package com.pvvchip.game.sprite;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.pvvchip.game.base.Sprite;
import com.pvvchip.game.math.Rect;
import com.pvvchip.game.pool.BulletPool;

public class MainShip extends Sprite {

    private Vector2 v0 = new Vector2(0.5f, 0);
    private Vector2 v = new Vector2();

    private boolean pressedLeft;
    private boolean pressedRight;

    private BulletPool bulletPool;

    private TextureAtlas atlas;

    private Rect worldBounds;

    private Sound soundShoot;

    public MainShip(TextureAtlas atlas, BulletPool bulletPool) {
        super(atlas.findRegion("main_ship"), 1, 2, 2);
        this.atlas = atlas;
        setHeightProportion(0.15f);
        this.bulletPool = bulletPool;
        soundShoot = Gdx.audio.newSound(Gdx.files.internal("gun.mp3"));
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (pos.x < worldBounds.getLeft()) pos.x = worldBounds.getLeft();
        if (pos.x > worldBounds.getRight()) pos.x = worldBounds.getRight();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setBottom(worldBounds.getBottom() + 0.05f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if (touch.x > 0) {
            pressedRight = true;
            moveRight();
        } else {
            pressedLeft = true;
            moveLeft();
        }
        return false;
        //return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if (touch.x > 0) {
            pressedRight = false;
            if (pressedLeft) {
                moveLeft();
            } else {
                stop();
            }
        } else {
            pressedLeft = false;
            if (pressedRight) {
                moveRight();
            } else {
                stop();
            }
        }
        if (isMe(touch)) {
            shoot();
        }
        return false;
        //return super.touchUp(touch, pointer);
    }


    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = true;
                moveLeft();
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressedRight = true;
                moveRight();
                break;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = false;
                if (pressedRight) {
                    moveRight();
                } else {
                    stop();
                }
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressedRight = false;
                if (pressedLeft) {
                    moveLeft();
                } else {
                    stop();
                }
                break;
            case Input.Keys.UP:
                shoot();
                break;
        }
        return false;
    }

    private void moveRight() {
        v.set(v0);
    }

    private void moveLeft() {
        v.set(v0).rotate(180);
    }

    private void stop() {
        v.setZero();
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, atlas.findRegion("bulletMainShip"), pos, new Vector2(0, 0.5f), 0.01f, worldBounds, 1);
        soundShoot.play();
    }

    public void disoose() {
        soundShoot.dispose();
    }
}
