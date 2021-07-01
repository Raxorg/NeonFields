package com.epicness.fundamentals.logic;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;

public class TransitionHandler {

    // Structure
    private SharedResources sharedResources;
    private Initializer initializer;
    private SharedLogic logic;
    // Logic
    private boolean transitionAllowed, allowedOnce;

    public void startTransition(Initializer initializer) {
        this.initializer = initializer;
        logic.getAssetLoader().startLoadingAssets(this.initializer.getAssets());
    }

    public void update() {
        if (logic.getAssetLoader().areAssetsReady() && transitionAllowed) {
            showNewScreen();
            transitionAllowed = false;
        }
    }

    public void allowTransition() {
        if (allowedOnce) {
            return;
        }
        transitionAllowed = true;
        allowedOnce = true;
    }

    public void showNewScreen() {
        initializer.initialize(sharedResources);
    }

    // Structure
    public void setSharedResources(SharedResources sharedResources) {
        this.sharedResources = sharedResources;
        logic = sharedResources.getLogic();
    }
}