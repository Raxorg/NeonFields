package com.epicness.fundamentals.logic;

import com.epicness.fundamentals.SharedResources;

public class SharedLogic {

    private final AssetLoader assetLoader;
    private final TransitionHandler transitionHandler;

    public SharedLogic() {
        assetLoader = new AssetLoader();
        transitionHandler = new TransitionHandler();
    }

    public void setSharedResources(SharedResources sharedResources) {
        transitionHandler.setSharedResources(sharedResources);
    }

    // Helpers
    public AssetLoader getAssetLoader() {
        return assetLoader;
    }

    public TransitionHandler getTransitionHandler() {
        return transitionHandler;
    }
}