package com.epicness.neonfields.splash;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.neonfields.splash.logic.SplashLogic;

public class SplashInitializer extends Initializer {

    public SplashInitializer() {
        super(new SplashAssets());
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        SplashAssets assets = (SplashAssets) this.assets;
        SharedScreen screen = sharedResources.getScreen();
        SplashLogic logic = new SplashLogic();
        SplashRenderer renderer = new SplashRenderer();
        SplashStuff stuff = new SplashStuff();

        logic.setSharedLogic(sharedResources.getLogic());
        logic.setStuff(stuff);
        renderer.setSharedRenderer(sharedResources.getRenderer());
        renderer.setScreen(screen);
        renderer.setStuff(stuff);
        screen.setLogic(logic);
        screen.setRenderer(renderer);
        stuff.setAssets(assets);

        assets.queueAssetLoading();
        assets.loadAssets();
        assets.initializeAssets();
        logic.initialLogic();

        stuff.initializeStuff();
    }
}