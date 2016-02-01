package com.jumper.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by AtanasK on 01-Feb-16.
 * Endgame state
 */
public class EndGameState extends State {
    private static EndGameState instance;
    private GameState gameState;

    private Texture background;

    private EndGameState(GameState gameState) {
        super(gameState);

        background = new Texture(Gdx.files.internal("Background.png"));

    }


    @Override
    public void update(float dt) {

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void dispose() {

    }

    public static EndGameState getEndGameState(GameState gameState) {
        if (instance == null) {
            instance = new EndGameState(gameState);
            return instance;
        }
        return instance;
    }
}
