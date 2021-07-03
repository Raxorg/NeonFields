package com.epicness.neonfields.main.logic;

import com.badlogic.gdx.utils.Array;
import com.epicness.fundamentals.input.InputHandler;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.ui.TextButtonID;

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
    private MainStuff stuff;

    public void setupInput() {
        input.setInputHandler(this);
        input.setEnabled(true);
    }

    @Override
    public void touchDown(float x, float y) {
        Array<TextButtonID> buttons = stuff.getButtonHolder().getButtons();
        for (int i = 0; i < buttons.size; i++) {
            TextButtonID button = buttons.get(i);
            if (button.contains(x, y)) {
                logic.getButtonHandler().buttonPressed(button.getElementID());
            }
        }
    }

    @Override
    public void touchDragged(float x, float y) {

    }

    @Override
    public void touchUp(float x, float y) {

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
                break;
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