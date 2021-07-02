package com.epicness.neonfields.main.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.input.InputHandler;
import com.epicness.fundamentals.input.SharedInput;

import static com.badlogic.gdx.Input.Keys.C;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.ENTER;
import static com.badlogic.gdx.Input.Keys.P;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.W;

public class MainInputHandler extends InputHandler {

    private SharedInput input;
    private MainLogic logic;
    private boolean mouseDown;
    private Vector2 mousePosition;

    public void setupInput() {
        input.setInputHandler(this);
        input.setEnabled(true);
    }

    @Override
    public void touchDown(float x, float y) {
        mouseDown = true;
        mousePosition = new Vector2(x, y);
    }

    @Override
    public void touchDragged(float x, float y) {

    }

    @Override
    public void touchUp(float x, float y) {
        mouseDown = false;
    }

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case W:
                logic.getPaddleHandler().paddleUpPress(true);
                break;
            case S:
                logic.getPaddleHandler().paddleDownPress(true);
                break;
            case UP:
                logic.getPaddleHandler().paddleUpPress(false);
                break;
            case DOWN:
                logic.getPaddleHandler().paddleDownPress(false);
                break;
            case SPACE:
                logic.getPersonHandler().spacePress();
                break;
            case C:
                logic.getColorAssigner().assignColors();
                break;
            case P:
                logic.getGameOverHandler().pancake();
                break;
            case ENTER:
                logic.getStartScreenHandler().enterPressed();
        }
    }

    @Override
    public void keyUp(int keycode) {
        switch (keycode) {
            case W:
                logic.getPaddleHandler().paddleUpRelease(true);
                break;
            case S:
                logic.getPaddleHandler().paddleDownRelease(true);
                break;
            case UP:
                logic.getPaddleHandler().paddleUpRelease(false);
                break;
            case DOWN:
                logic.getPaddleHandler().paddleDownRelease(false);
                break;
        }
    }

    public Vector2 getMousePosition() {
        return mousePosition;
    }

    public boolean getLeftMouseDown() {
        return mouseDown;
    }

    // Structure
    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }
}