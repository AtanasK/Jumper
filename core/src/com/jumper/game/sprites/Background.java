package com.jumper.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by AtanasK on 31-Jan-16.
 * background sprite class
 */
public class Background {
    private Texture playState;
    private Vector2 playStatePos;
    private Vector2 playStatePosSecond;

    public Background(float y) {
        playState = new Texture(Gdx.files.internal("Background.png"));
        playStatePos = new Vector2(0, 0);
        playStatePosSecond = new Vector2(0, playState.getHeight());
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(playState, playStatePos.x, playStatePos.y);
        spriteBatch.draw(playState, playStatePosSecond.x, playStatePosSecond.y);
    }

    public void update(float camY, float camVieWid) {
        if (playStatePos.y + playState.getHeight() < camY - (camVieWid / 2)) {
            playStatePos.add(0, playState.getHeight() * 2);
        }
        if (playStatePosSecond.y + playState.getHeight() < camY - (camVieWid / 2)) {
            playStatePosSecond.add(0, playState.getHeight() * 2);
        }
    }

    public void dispose() {
        playState.dispose();
    }

}
