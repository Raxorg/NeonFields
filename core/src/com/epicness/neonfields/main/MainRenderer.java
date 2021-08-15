package com.epicness.neonfields.main;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.fundamentals.renderer.SharedRenderer;
import com.epicness.neonfields.main.stuff.MainStuff;

public class MainRenderer extends Renderer {

    private SharedRenderer sharedRenderer;
    private SharedScreen screen;
    private MainStuff stuff;

    @Override
    public void render() {
        // Clear previous frame
        ScreenUtils.clear(0, 0, 0, 1);
        // Use the camera
        spriteBatch.setProjectionMatrix(screen.getDynamicCamera().combined);
        // Render the stuff
        spriteBatch.begin();
        stuff.getCurrentMiniGame().draw(spriteBatch);
        stuff.getMainMenu().draw(spriteBatch);
        spriteBatch.end();
        sharedRenderer.render();
    }

    // Structure
    public void setSharedRenderer(SharedRenderer sharedRenderer) {
        this.sharedRenderer = sharedRenderer;
    }

    public void setScreen(SharedScreen screen) {
        this.screen = screen;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}