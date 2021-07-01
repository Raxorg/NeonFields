package com.epicness.fundamentals.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Assets {

    protected final AssetManager assetManager;

    public Assets() {
        assetManager = new AssetManager();
    }

    public abstract void queueAssetLoading();

    public abstract boolean loadAssets();

    public abstract void initializeAssets();

    //DEMO FUNCTION
    public Texture getSprite(String texture) {
        return assetManager.get(texture);
    }
}
