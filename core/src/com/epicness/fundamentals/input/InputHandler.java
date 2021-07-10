package com.epicness.fundamentals.input;

public abstract class InputHandler {

    public abstract void touchDown(float x, float y);

    public abstract void touchDragged(float x, float y);

    public abstract void touchUp(float x, float y);

    public abstract void mouseMoved(float x, float y);

    public abstract void keyDown(int keycode);

    public abstract void keyUp(int keycode);
}