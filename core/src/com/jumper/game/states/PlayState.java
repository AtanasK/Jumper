package com.jumper.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jumper.game.JumperGame;
import com.jumper.game.sprites.Background;
import com.jumper.game.sprites.Frogy;
import com.jumper.game.sprites.Obstacles;


/**
 * Created by AtanasK on 31-Jan-16.
 * Play state, the state of started game
 */
public class PlayState extends State {
    private Background background;
    private Music playMusic;
    private Frogy frogy;
    private Obstacles obstacles;


    public boolean gameEnd;

    public PlayState(GameState gameState) {
        super(gameState);
        camera.setToOrtho(false, JumperGame.WIDTH / 2, JumperGame.HEIGHT / 2);

        gameEnd = false;

        background = new Background(camera.position.y);
        frogy = new Frogy(camera.viewportWidth, 50);
        obstacles = new Obstacles(camera.viewportWidth, camera.viewportHeight);

        playMusic = Gdx.audio.newMusic(Gdx.files.internal("mainSound.mp3"));
        playMusic.setLooping(true);
        playMusic.setVolume(0.3f);
        playMusic.play();
    }


    @Override
    public void update(float dt) {
        handleInput();
        frogy.update(dt);
        camera.position.y = frogy.getPosition().y + 100;
        background.update(camera.position.y, camera.viewportHeight);
        camera.update();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            if (Gdx.input.getX() < camera.viewportWidth/2) {
                frogy.jumpLeft();
            } else {
                frogy.jumpRight();
            }
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        background.render(spriteBatch);
        frogy.render(spriteBatch, frogy.getPosition().x, frogy.getPosition().y);
        if (obstacles.draw(spriteBatch, frogy.getPosition().y, camera.viewportHeight, frogy.getHitbox())) {
            gameEnd = true;
        }

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        frogy.dispose();
    }
}
