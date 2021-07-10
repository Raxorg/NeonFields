package com.epicness.neonfields.main;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.stuff.MainStuff;

public class MainInitializer extends Initializer {

    public MainInitializer() {
        super(new MainAssets());
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        MainAssets assets = (MainAssets) this.assets;
        SharedInput input = sharedResources.getInput();
        MainLogic logic = new MainLogic();
        MainRenderer renderer = new MainRenderer();
        SharedScreen screen = sharedResources.getScreen();
        MainStuff stuff = new MainStuff();

        logic.setAssets(assets);
        logic.setInput(input);
        logic.setStuff(stuff);
        renderer.setScreen(screen);
        renderer.setStuff(stuff);
        stuff.setSharedAssets(sharedResources.getAssets());
        stuff.setAssets(assets);

        stuff.initializeStuff();
        logic.initialLogic();
        input.setEnabled(true);

        screen.setLogic(logic);
        screen.setRenderer(renderer);
    }
}