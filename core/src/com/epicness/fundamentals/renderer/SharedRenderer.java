package com.epicness.fundamentals.renderer;

import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.stuff.SharedStuff;

public class SharedRenderer extends Renderer {

    private SharedScreen screen;
    private SharedStuff stuff;

    @Override
    public void render() {
        spriteBatch.setProjectionMatrix(screen.getStaticCamera().combined);
        spriteBatch.begin();
        stuff.getFader().draw(spriteBatch);
        spriteBatch.end();
    }

    public void setScreen(SharedScreen screen) {
        this.screen = screen;
    }

    public void setStuff(SharedStuff stuff) {
        this.stuff = stuff;
    }
}