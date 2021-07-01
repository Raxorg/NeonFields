package com.epicness.fundamentals;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.renderer.SharedRenderer;
import com.epicness.fundamentals.stuff.SharedStuff;

public class SharedResources {

    private final SharedAssets assets;
    private final SharedLogic logic;
    private final SharedInput sharedInput;
    private final SharedRenderer renderer;
    private final SharedScreen screen;
    private final SharedStuff stuff;

    public SharedResources(Game game) {
        assets = new SharedAssets();
        sharedInput = new SharedInput();
        logic = new SharedLogic();
        renderer = new SharedRenderer();
        screen = new SharedScreen();
        stuff = new SharedStuff();

        sharedInput.setCamera(screen.getDynamicCamera());
        logic.setSharedResources(this);
        renderer.setScreen(screen);
        renderer.setStuff(stuff);
        stuff.setAssets(assets);

        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initializeAssets();
        stuff.initializeStuff();

        game.setScreen(screen);
    }

    public SharedAssets getAssets() {
        return assets;
    }

    public SharedLogic getLogic() {
        return logic;
    }

    public SharedInput getInput() {
        return sharedInput;
    }

    public SharedRenderer getRenderer() {
        return renderer;
    }

    public SharedScreen getScreen() {
        return screen;
    }

    public SharedStuff getStuff() {
        return stuff;
    }
}