package com.jumper.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by AtanasK on 31-Jan-16.
 * Obstacles sprite class, with rng
 */
public class Obstacles {
    private Random random;

    private static int DISTANCE = 140;
    private float v;

    private ArrayList<Obstacle> obstacles;

    public Obstacles(float viewWidth, float y) {
        this.v = viewWidth;
        //y positions

        random = new Random();

        obstacles = new ArrayList<Obstacle>();

        for (int i = 0; i < 5; i++) {
            int oneOrTwo = random.nextInt(100);
            if (oneOrTwo <= 50) {
                int r = random.nextInt(3);
                obstacles.add(new Obstacle(viewWidth, y + DISTANCE * i, r));
            } else {
                int edno = random.nextInt(3);
                if (edno == 0) {
                    int drugo = random.nextInt(2) + 1;
                    obstacles.add(new Obstacle(viewWidth, y + DISTANCE * i, edno));
                    obstacles.add(new Obstacle(viewWidth, y + DISTANCE * i, drugo));
                } else if (edno == 1) {
                    int drugo = random.nextInt(2);
                    if (drugo == 1)
                        drugo = 2;
                    obstacles.add(new Obstacle(viewWidth, y + DISTANCE * i, edno));
                    obstacles.add(new Obstacle(viewWidth, y + DISTANCE * i, drugo));
                } else {
                    int drugo = random.nextInt(2);
                    obstacles.add(new Obstacle(viewWidth, y + DISTANCE * i, edno));
                    obstacles.add(new Obstacle(viewWidth, y + DISTANCE * i, drugo));
                }
            }// TODO ova da se preraboti so red
        }
    }

    private void tossRandom(float y) {
        int oneOrTwo = random.nextInt(100);
        int i = obstacles.size() - 1;

        Obstacle o = new Obstacle(v, y * i, random.nextInt(3));


    }

    public boolean update(float y, float height, Rectangle frogy) {
        Random r = new Random();
        for (Iterator<Obstacle> iterator = obstacles.iterator(); iterator.hasNext();) {
            Obstacle o = iterator.next();
            if (o.hitbox.overlaps(frogy)) {
                return true;
            }
            if (o.positionY < y - 186 - height + 150 + DISTANCE) {
                o.positionY = (obstacles.size() - 1) * DISTANCE + y - 600;
                o.positionX = Obstacle.positions[r.nextInt(3)];
                o.hitbox.setPosition(o.positionX, o.positionY);
            }
        }
        return false;
    }

    public boolean draw(SpriteBatch spriteBatch, float y, float height, Rectangle frogy) {
        if (update(y, height, frogy))
            return true;

        for (Obstacle o : obstacles)
            spriteBatch.draw(o.getTexture(), o.positionX, o.positionY);
        return false;
    }

    public void dispose() {
        for (Obstacle o : obstacles)
            o.dispose();
    }

}
