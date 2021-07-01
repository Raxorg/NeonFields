package com.epicness.fundamentals.assets;

import com.badlogic.gdx.assets.AssetManager;

public abstract class Assets {

    protected final AssetManager assetManager;

    public Assets() {
        assetManager = new AssetManager();
    }

    public abstract void queueAssetLoading();

    public abstract boolean loadAssets();

    public abstract void initializeAssets();
}
