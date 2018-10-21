package com.pvvchip.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarGame extends ApplicationAdapter implements InputProcessor {
    SpriteBatch batch;
    Texture img;

    private Vector2 pos, posEnd;
    private Vector2 v, v2;
    private int yMax, xMax;

    @Override
    public void create() {
        Gdx.input.setInputProcessor(this);
        yMax = Gdx.graphics.getHeight();
        xMax = Gdx.graphics.getWidth();


        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        pos = new Vector2(0, 0);
        posEnd = new Vector2(0, 0);
        v = new Vector2(0, 0);
        v2 = new Vector2(0, 0);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0.5f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        newPos();
    }

    private void newPos() {
        if (pos.dst(posEnd) > 1) {
            pos.add(v);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
//        System.out.println("Key: " + keycode);
        switch (keycode) {
            case 19:
                posEnd.y += 10;
                break;
            case 20:
                posEnd.y -= 10;
                break;
            case 21:
                posEnd.x -= 10;
                break;
            case 22:
                posEnd.x += 10;
                break;
        }
        v = posEnd.cpy().sub(pos).nor();
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        posEnd.x = screenX;
        posEnd.y = yMax - screenY;
        v = posEnd.cpy().sub(pos).nor();
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
