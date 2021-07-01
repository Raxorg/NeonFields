package com.epicness.neonfields.splash;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.Stuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class SplashStuff extends Stuff {

    // Structure
    private SplashAssets assets;
    // Stuff
    private Sprite splash, splashGlow;

    @Override
    public void initializeStuff() {
        splash = new Sprite(assets.getSplash());
        splash.setOriginCenter();
        splash.setOriginBasedPosition(CAMERA_WIDTH / 2f, CAMERA_HEIGHT/2f);
        splashGlow = new Sprite(assets.getSplashGlow());
        splashGlow.setOriginCenter();
        splashGlow.setOriginBasedPosition(CAMERA_WIDTH / 2f, CAMERA_HEIGHT/2f);
    }

    // Stuff
    public Sprite getSplash() {
        return splash;
    }

    public Sprite getSplashGlow() {
        return splashGlow;
    }

    // Structure
    public void setAssets(SplashAssets assets) {
        this.assets = assets;
    }
}