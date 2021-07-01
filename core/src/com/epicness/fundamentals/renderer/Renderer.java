package com.epicness.fundamentals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Renderer {

    protected final SpriteBatch spriteBatch;

    public Renderer() {
        spriteBatch = new SpriteBatch();
    }

    public abstract void render();
}