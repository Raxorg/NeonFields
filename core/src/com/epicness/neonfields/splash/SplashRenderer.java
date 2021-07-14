package com.epicness.neonfields.splash;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.fundamentals.renderer.SharedRenderer;

public class SplashRenderer extends Renderer {

    private SharedRenderer sharedRenderer;
    private SharedScreen screen;
    private SplashStuff stuff;

    @Override
    public void render() {
        // Clear previous frame
        ScreenUtils.clear(0, 0, 0, 1);
        // Use the camera
        spriteBatch.setProjectionMatrix(screen.getDynamicCamera().combined);
        // Render the stuff
        spriteBatch.begin();
        stuff.getSplashGlow().draw(spriteBatch);
        stuff.getSplash().draw(spriteBatch);
        spriteBatch.end();
        sharedRenderer.render();
    }

    public void setSharedRenderer(SharedRenderer sharedRenderer) {
        this.sharedRenderer = sharedRenderer;
    }

    public void setScreen(SharedScreen screen) {
        this.screen = screen;
    }

    public void setStuff(SplashStuff stuff) {
        this.stuff = stuff;
    }
}