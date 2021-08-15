package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.utils.Array;
import com.epicness.fundamentals.input.InputHandler;
import com.epicness.fundamentals.stuff.Button;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.logic.game.PongGameHandler;

import static com.badlogic.gdx.Input.Keys.C;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.P;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.W;

public class PongInputHandler extends InputHandler {

    private MainLogic logic;

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
        PongGameHandler pongGameHandler = logic.getPongGameHandler();
        switch (keycode) {
            case W:
                pongGameHandler.getPaddleHandler().paddleUpPress(true);
                break;
            case S:
                pongGameHandler.getPaddleHandler().paddleDownPress(true);
                break;
            case UP:
                pongGameHandler.getPaddleHandler().paddleUpPress(false);
                break;
            case DOWN:
                pongGameHandler.getPaddleHandler().paddleDownPress(false);
                break;
            case SPACE:
                pongGameHandler.getPersonHandler().spacePress();
                break;
            case C:
                pongGameHandler.getColorAssigner().assignColors();
                break;
            case P:
                pongGameHandler.getGameOverHandler().pancake();
                break;
        }
    }

    @Override
    public void keyUp(int keycode) {
        PongGameHandler pongGameHandler = logic.getPongGameHandler();
        switch (keycode) {
            case W:
                pongGameHandler.getPaddleHandler().paddleUpRelease(true);
                break;
            case S:
                pongGameHandler.getPaddleHandler().paddleDownRelease(true);
                break;
            case UP:
                pongGameHandler.getPaddleHandler().paddleUpRelease(false);
                break;
            case DOWN:
                pongGameHandler.getPaddleHandler().paddleDownRelease(false);
                break;
        }
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }
}