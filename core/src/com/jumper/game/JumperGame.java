package com.jumper.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jumper.game.states.EndGameState;
import com.jumper.game.states.GameState;
import com.jumper.game.states.PlayState;
import com.jumper.game.states.SplashScreen;

public class JumperGame extends ApplicationAdapter {
    public static final int WIDTH = 540;
    public static final int HEIGHT = 860;

	private SpriteBatch batch;
	private GameState gameState;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        gameState = new GameState();
        gameState.startState(new SplashScreen(gameState));
        Gdx.gl.glClearColor(0, 3, 0, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (gameState.getState().gameEnd) {
//            gameState.startState(EndGameState.getEndGameState(gameState));
            gameState.getAndRemove();
            gameState.startState(new SplashScreen(gameState));
        }

        gameState.update(Gdx.graphics.getDeltaTime());
        gameState.render(batch);
	}


    @Override
    public void dispose() {
        super.dispose();

        gameState.getState().dispose();
    }
}
