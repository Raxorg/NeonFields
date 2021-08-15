package com.epicness.neonfields.main.logic;

import com.epicness.fundamentals.input.InputHandler;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.neonfields.main.stuff.MainStuff;

public class MainInputHandler extends InputHandler {

    private SharedInput input;
    private MainLogic logic;
    private MainStuff stuff;

    public void setupInput() {
        input.setInputHandler(this);
        input.setEnabled(true);
    }

    @Override
    public void touchDown(float x, float y) {
        if (stuff.getCurrentMiniGame() == stuff.getPongGame()) {
            logic.getPongGameHandler().getPongInputHandler().touchDown(x, y);
        }
    }

    @Override
    public void touchDragged(float x, float y) {
        if (stuff.getCurrentMiniGame() == stuff.getPongGame()) {
            logic.getPongGameHandler().getPongInputHandler().touchDragged(x, y);
        }
    }

    @Override
    public void touchUp(float x, float y) {
        if (stuff.getCurrentMiniGame() == stuff.getPongGame()) {
            logic.getPongGameHandler().getPongInputHandler().touchUp(x, y);
        }
    }

    @Override
    public void mouseMoved(float x, float y) {
        if (stuff.getCurrentMiniGame() == stuff.getPongGame()) {
            logic.getPongGameHandler().getPongInputHandler().mouseMoved(x, y);
        }
    }

    @Override
    public void keyDown(int keycode) {
        if (stuff.getCurrentMiniGame() == stuff.getPongGame()) {
            logic.getPongGameHandler().getPongInputHandler().keyDown(keycode);
        }
    }

    @Override
    public void keyUp(int keycode) {
        if (stuff.getCurrentMiniGame() == stuff.getPongGame()) {
            logic.getPongGameHandler().getPongInputHandler().keyUp(keycode);
        }
    }

    // Structure
    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}