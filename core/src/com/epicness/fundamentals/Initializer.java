package com.epicness.fundamentals;

import com.epicness.fundamentals.assets.Assets;

public abstract class Initializer {

    protected final Assets assets;

    public Initializer(Assets assets) {
        this.assets = assets;
    }

    public abstract void initialize(SharedResources sharedResources);

    public Assets getAssets() {
        return assets;
    }
}