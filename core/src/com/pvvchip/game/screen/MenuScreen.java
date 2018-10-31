package com.pvvchip.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pvvchip.game.base.Base2DScreen;
import com.pvvchip.game.math.Rect;
import com.pvvchip.game.sprite.Background;
import com.pvvchip.game.sprite.Exit;
import com.pvvchip.game.sprite.Play;

public class MenuScreen extends Base2DScreen {

    private static final int STAR_COUNT = 256;

    private Texture bgTexture;
    private Background background;

    private TextureAtlas textureAtlas;
    private Star[] stars;
    private Play play;
    private Exit exit;


    @Override
    public void show() {
        super.show();
        bgTexture = new Texture("bg.png");
        background = new Background(new TextureRegion(bgTexture));
        play = new Play(new TextureAtlas("menuAtlas.tpack"));
        exit = new Exit(new TextureAtlas("menuAtlas.tpack"));
        textureAtlas = new TextureAtlas("menuAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(textureAtlas);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();

    }

    public void update(float delta) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(delta);
        }
    }

    public void draw() {
        Gdx.gl.glClearColor(0.128f, 0.53f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        play.draw(batch);
        exit.draw(batch);
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw(batch);
        }
        batch.end();
    }

    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        play.resize(worldBounds);
        for (int i = 0; i < stars.length; i++) {
            stars[i].resize(worldBounds);
        }
    }

    @Override
    public void dispose() {
        bgTexture.dispose();
        textureAtlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }
}
