package com.jumper.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by AtanasK on 30-Jan-16.
 * State manager containing stack with states
 */
public class GameState {
    private Stack<State> states;

    public GameState() {
        states = new Stack<State>();
    }

    public void startState(State state) {
//        getAndRemove();
        states.push(state);
    }

    public State getState() {
        return states.peek();
    }

    public State getAndRemove() {
        return states.pop();
    }

    public void update(float dt) {
        getState().update(dt);
    }

    public void render(SpriteBatch spriteBatch) {
        getState().render(spriteBatch);
    }

}
