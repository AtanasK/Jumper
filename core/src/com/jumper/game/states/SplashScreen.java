package com.jumper.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jumper.game.JumperGame;

/**
 * Created by AtanasK on 01-Feb-16.
 * Splashscreen
 */
public class SplashScreen extends State {
    private Texture background;
    private Texture jumperText;
    private Texture playButton;
    private Texture frogyStart;

    private static float MAXTIME = 5f;
    private float currentTime;

    public SplashScreen(GameState gameState) {
        super(gameState);
        camera.setToOrtho(false, JumperGame.WIDTH / 2, JumperGame.HEIGHT / 2);

        background = new Texture(Gdx.files.internal("splashScreen.png"));
        currentTime = 0;
    }

    @Override
    public void update(float dt) {
        currentTime += dt;
        if (currentTime > MAXTIME) {
            gameState.getAndRemove();
            gameState.startState(new MainMenu(gameState));
        }
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        // backgorund
        spriteBatch.draw(background, camera.viewportWidth / 2 - background.getWidth() / 2, camera.viewportHeight / 2 - background.getHeight() / 2);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
