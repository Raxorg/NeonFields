package com.epicness.neonfields.splash;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class SplashAssets extends Assets {

    private Sprite splash, splashGlow;

    @Override
    public void queueAssetLoading() {
        assetManager.load("images/splash/splash.png", Texture.class);
        assetManager.load("images/splash/splashGlow.png", Texture.class);
    }

    @Override
    public boolean loadAssets() {
        assetManager.finishLoading();
        return true;
    }

    @Override
    public void initializeAssets() {
        splash = new Sprite(assetManager.get("images/splash/splash.png", Texture.class));
        splashGlow = new Sprite(assetManager.get("images/splash/splashGlow.png", Texture.class));
    }

    public Sprite getSplash() {
        return splash;
    }

    public Sprite getSplashGlow() {
        return splashGlow;
    }
}