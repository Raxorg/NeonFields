package com.epicness.fundamentals.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SharedAssets extends Assets {

    // Sprites
    private Sprite pixel;

    @Override
    public void queueAssetLoading() {
        assetManager.load("images/pixel.png", Texture.class);
    }

    @Override
    public boolean loadAssets() {
        return assetManager.update();
    }

    public void finishLoading() {
        assetManager.finishLoading();
    }

    @Override
    public void initializeAssets() {
        pixel = new Sprite(assetManager.get("images/pixel.png", Texture.class));
    }

    // Sprites
    public Sprite getPixel() {
        return pixel;
    }
}