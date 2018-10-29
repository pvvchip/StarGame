package com.pvvchip.game;

import com.badlogic.gdx.Game;
import com.pvvchip.game.screen.MenuScreen;


public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}
