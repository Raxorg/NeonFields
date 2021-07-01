package com.epicness.neonfields;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.SharedResources;
import com.epicness.neonfields.splash.SplashInitializer;

public class NeonGame extends Game {

    @Override
    public void create() {
        new SplashInitializer().initialize(new SharedResources(this));
    }
}