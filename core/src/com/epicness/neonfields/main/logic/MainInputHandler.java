package com.epicness.neonfields.main.logic;

import com.badlogic.gdx.utils.Array;
import com.epicness.fundamentals.input.InputHandler;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.stuff.Button;

import static com.badlogic.gdx.Input.Keys.C;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.P;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.W;

public class MainInputHandler extends InputHandler {

    private SharedInput input;
    private MainLogic logic;

    public void setupInput() {
        input.setInputHandler(this);
        input.setEnabled(true);
    }

    @Override
    public void touchDown(float x, float y) {
        Array<Button> buttons = logic.getMenuHandler().getCurrentMenu().getButtons();
        for (int i = 0; i < buttons.size; i++) {
            Button button = buttons.get(i);
            if (button.contains(x, y)) {
                logic.getButtonHandler().buttonDragged(button);
            }
        }
    }

    @Override
    public void touchDragged(float x, float y) {
        Array<Button> buttons = logic.getMenuHandler().getCurrentMenu().getButtons();
        for (int i = 0; i < buttons.size; i++) {
            Button button = buttons.get(i);
            logic.getButtonHandler().buttonDedragged(button);
            if (button.contains(x, y)) {
                logic.getButtonHandler().buttonDragged(button);
            }
        }
    }

    @Override
    public void touchUp(float x, float y) {
        Array<Button> buttons = logic.getMenuHandler().getCurrentMenu().getButtons();
        for (int i = 0; i < buttons.size; i++) {
            Button button = buttons.get(i);
            logic.getButtonHandler().buttonDehovered(button);
            logic.getButtonHandler().buttonDedragged(button);
            if (button.contains(x, y)) {
                logic.getButtonHandler().buttonActivated(button);
            }
        }
    }

    @Override
    public void mouseMoved(float x, float y) {
        Array<Button> buttons = logic.getMenuHandler().getCurrentMenu().getButtons();
        for (int i = 0; i < buttons.size; i++) {
            Button button = buttons.get(i);
            logic.getButtonHandler().buttonDehovered(button);
            if (button.contains(x, y)) {
                logic.getButtonHandler().buttonHovered(button);
            }
        }
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
}