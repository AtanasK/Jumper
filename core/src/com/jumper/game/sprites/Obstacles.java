package com.jumper.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.jumper.game.states.PlayState;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by AtanasK on 31-Jan-16.
 * Obstacles sprite class, with rng
 */
public class Obstacles {
    private PlayState playState;
    private Random random;

    private static int DISTANCE = 140;
    private float v;

    private ArrayList<Obstacle> obstacles;

    public Obstacles(PlayState playState) {
        this.playState = playState;

        obstacles = new ArrayList<Obstacle>();
    }


}
