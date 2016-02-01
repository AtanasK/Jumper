package com.jumper.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

/**
 * Created by AtanasK on 31-Jan-16.
 * Frogy sprite class
 */
public class Frogy {
    //Animation properties
    private ArrayList<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int currentFrame;

    private float[] positions;
    private int positionsI;

    //Texture
    private Texture frogy;

    //hitbox
    private Rectangle hitbox;

    //Movement
    private Vector3 position;
    private Vector3 velocity;
    private static int MOVEMENT = 150;

    //Jump sound
    private Sound jump;

    public Frogy(float width, int y) {
        //Animation and texture
        frogy = new Texture(Gdx.files.internal("frogy.png"));
        frames = new ArrayList<TextureRegion>();
        for (int i = 0; i < 4; i++) {
            frames.add(new TextureRegion(frogy, 50 * i, 0, 50, frogy.getHeight()));
        }
        maxFrameTime = 0.5f / 2;
        currentFrame = 0;
        currentFrame = 0;

        positions = new float[3];
        positions[0] = 30;
        positions[1] = (width / 2) - (frogy.getWidth() / 4) + 25;
        positions[2] = width - 80;
        positionsI = 1;

        //hitbox
        hitbox = new Rectangle(positions[positionsI], y, 50, frogy.getHeight());

        //Sound
        jump = Gdx.audio.newSound(Gdx.files.internal("jumpSound.wav"));

        //Movement

        position = new Vector3(positions[positionsI], y, 0);
        velocity = new Vector3(0, 0, 0);
    }

    public void jumpLeft() {
        jump.play(0.4f);
        if (positionsI > 0) {
            positionsI--;
            position.x = positions[positionsI];
        }
    }

    public void jumpRight() {
        jump.play(0.4f);
        if (positionsI < 2) {
            positionsI++;
            position.x = positions[positionsI];
        }
    }

    public void update(float dt) {
        // Animation update
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
            currentFrame++;
            currentFrameTime = 0;
        }
        if (currentFrame > 3) {
            currentFrame = 0;
        }

        //Movement update
        velocity.scl(dt);
        position.add(velocity.x, MOVEMENT * dt, 0);
        velocity.scl(1 / dt);
        hitbox.setPosition(position.x, position.y);


    }

    public void render(SpriteBatch spriteBatch, float x, float y) {
        spriteBatch.draw(frames.get(currentFrame), x, y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void dispose() {
        frogy.dispose();
    }
}
