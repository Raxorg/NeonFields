package com.epicness.fundamentals.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public abstract class Assets {

    protected final AssetManager assetManager;

    public Assets() {
        assetManager = new AssetManager();
    }

    public abstract void queueAssetLoading();

    public abstract boolean loadAssets();

    public abstract void initializeAssets();

    public Texture getTexture(String assetPath) {
        return assetManager.get(assetPath);
    }

    public BitmapFont getFont(String assetPath) {
        return assetManager.get(assetPath);
    }
}