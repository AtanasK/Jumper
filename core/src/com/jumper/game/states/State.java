package com.jumper.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by AtanasK on 30-Jan-16.
 */
public abstract class State {
    private GameState gsm;
    private OrthographicCamera camera;
    private Vector3 mouse;


    public State(GameState gsm) {
        this.gsm = gsm;

        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput();

    public abstract void update(float dt);

    public abstract void render(SpriteBatch sb);

    public abstract void dispose();

}
