package com.jumper.game.states;

import java.util.Stack;

/**
 *
 */
public class GameState {
    private Stack<State> states;

    public GameState() {
        states = new Stack<State>();
    }

    public State pop() {
        return states.pop();
    }

    public void add(State state) {
        states.add(state);
    }

    public State peek() {
        return states.peek();
    }

}
