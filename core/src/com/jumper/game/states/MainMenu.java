package com.jumper.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jumper.game.JumperGame;

/**
 * Created by AtanasK on 01-Feb-16.
 * main menu class
 */
public class MainMenu extends State {
    private Texture background;
    private Texture jumperText;
    private Texture playButton;
    private Texture frogyStart;
    private Sound intro;
    private Music music;

    public MainMenu(GameState gameState) {
        super(gameState);
        camera.setToOrtho(false, JumperGame.WIDTH, JumperGame.HEIGHT);

        background = new Texture(Gdx.files.internal("Background.png"));
        jumperText = new Texture(Gdx.files.internal("jumperStart.png"));
        playButton = new Texture(Gdx.files.internal("playButton.png"));
        frogyStart = new Texture(Gdx.files.internal("frogyStart.png"));

        intro = Gdx.audio.newSound(Gdx.files.internal("intro.mp3"));
        intro.play();

        music = Gdx.audio.newMusic(Gdx.files.internal("mainSound.mp3"));
        music.setVolume(0.4f);
        music.setLooping(true);
        music.play();
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void handleInput() {
        System.out.println("updejta-" + Gdx.input.getY() + ":" + Gdx.graphics.getHeight());
        if (Gdx.input.justTouched()) {
            if (Gdx.input.getY() > Gdx.graphics.getHeight() - (50 + playButton.getHeight())) {
                gameState.getAndRemove();
                gameState.startState(new PlayState(gameState));
            }
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        spriteBatch.draw(jumperText, camera.viewportWidth / 2 - jumperText.getWidth() / 2, camera.viewportHeight - jumperText.getHeight() - 50);
        spriteBatch.draw(frogyStart, camera.viewportWidth / 2 - frogyStart.getWidth() / 2, camera.viewportHeight / 2 - frogyStart.getHeight() / 2);
        spriteBatch.draw(playButton, camera.viewportWidth / 2 - playButton.getWidth() / 2, 40);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        jumperText.dispose();
        frogyStart.dispose();
        playButton.dispose();
        intro.dispose();
        music.dispose();
    }
}
