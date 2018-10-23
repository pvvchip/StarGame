package com.pvvchip.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.Input.Keys.I;

public class StarGame extends ApplicationAdapter implements InputProcessor {
    SpriteBatch batch;
    Texture img;

    private Vector2 pos, posEnd;
    private Vector2 v;
    private int yMax;

    @Override
    public void create() {
        Gdx.input.setInputProcessor(this);
        yMax = Gdx.graphics.getHeight();

        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        pos = new Vector2(0, 0);
        posEnd = new Vector2(0, 0);
        v = new Vector2(0, 0);
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
        switch (keycode) {
            case Input.Keys.UP:
                posEnd.y += 10;
                break;
            case Input.Keys.DOWN:
                posEnd.y -= 10;
                break;
            case Input.Keys.LEFT:
                posEnd.x -= 10;
                break;
            case Input.Keys.RIGHT:
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
