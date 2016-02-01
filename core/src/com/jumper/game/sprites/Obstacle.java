package com.jumper.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by AtanasK on 31-Jan-16.
 * Obstacle class
 */
public class Obstacle {
    private class ObstacleSingle {
        protected float positionX;
        public void setPositionX(float x) {
            positionX = x;
        }
    }

    //texture
    private static Texture obstacle;
    // static positions
    protected static float[] positions = new float[3];
    // y position
    protected float positionY;
    protected float positionX; // TODO remove this;



    public Rectangle hitbox;


    Obstacle(float viewWidth, float y, int pos) {

        // define the texture
        obstacle = new Texture(Gdx.files.internal("obstacle.png"));

        //Static possible x positions
        positions[0] = 5;
        positions[1] = viewWidth / 2 - obstacle.getWidth() / 2;
        positions[2] = viewWidth - obstacle.getWidth() - 5;

        positionY = y;
        positionX = positions[pos];

        hitbox = new Rectangle(positionX, positionY, obstacle.getWidth(), obstacle.getHeight());

    }

    public void draw(SpriteBatch spriteBatch, float y) {
        spriteBatch.draw(obstacle, positionX, positionY);
    }

    public Texture getTexture() {
        return obstacle;
    }

    public void dispose() {
        obstacle.dispose();
    }
}
