package com.epicness.neonfields.splash;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;
import static com.epicness.neonfields.splash.SplashConstants.SPLASH_SCREEN_GLOW;
import static com.epicness.neonfields.splash.SplashConstants.SPLASH_SCREEN_LOGO;

public class SplashAssets extends Assets {

    private Sprite splash, splashGlow;

    @Override
    public void queueAssetLoading() {
        assetManager.load(SPLASH_SCREEN_LOGO, Texture.class);
        assetManager.load(SPLASH_SCREEN_GLOW, Texture.class);
    }

    @Override
    public boolean loadAssets() {
        assetManager.finishLoading();
        return true;
    }

    @Override
    public void initializeAssets() {
        splash = new Sprite(getSprite(SPLASH_SCREEN_LOGO));
        splashGlow = new Sprite(getSprite(SPLASH_SCREEN_GLOW));
    }

    public Sprite getSplash() {
        return splash;
    }

    public Sprite getSplashGlow() {
        return splashGlow;
    }
}