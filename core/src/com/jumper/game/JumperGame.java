package com.jumper.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jumper.game.states.GameState;

public class JumperGame extends ApplicationAdapter {
	private static final int WIDTH = 320;
	private static final int HEIGHT = 420;

	private GameState gameState;
	private SpriteBatch spriteBatch;

	private Music music;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		gameState = new GameState();

        music = Gdx.audio.newMusic(Gdx.files.internal("background.wav"));
        music.setLooping(true);
        music.setVolume(0.3f);
        music.play();

        Gdx.gl.glClearColor(0, 0, 0, 1);

    }

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		spriteBatch.begin();

		spriteBatch.end();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
