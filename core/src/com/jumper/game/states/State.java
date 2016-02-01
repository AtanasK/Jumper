package com.jumper.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by AtanasK on 30-Jan-16.
 *
 * State abstract class, defining the game states
 */
public abstract class State {
    protected GameState gameState;
    protected OrthographicCamera camera;
    public boolean gameEnd;

    public State(GameState gameState) {
        this.gameState = gameState;
        camera = new OrthographicCamera();
        gameEnd = false;
    }

    public abstract void update(float dt);
    public abstract void handleInput();
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();
}
