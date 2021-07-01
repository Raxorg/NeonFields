package com.epicness.fundamentals.logic;

import com.epicness.fundamentals.assets.Assets;

public class AssetLoader {

    // Logic
    private Assets assets;
    private boolean assetsReady;

    protected void startLoadingAssets(Assets assetsToLoad) {
        assets = assetsToLoad;
        assets.queueAssetLoading();
        assetsReady = false;
    }

    public void update() {
        if (assetsReady) {
            return;
        }
        if (assets.loadAssets()) {
            assets.initializeAssets();
            assetsReady = true;
        }
    }

    public Assets getAssets() {
        return assets;
    }

    public boolean areAssetsReady() {
        return assetsReady;
    }
}