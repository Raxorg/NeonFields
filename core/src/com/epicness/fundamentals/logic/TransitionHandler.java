package com.epicness.fundamentals.logic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.fundamentals.stuff.SharedStuff;

public class TransitionHandler {

    // Structure
    private SharedResources sharedResources;
    private Initializer initializer;
    private SharedLogic logic;
    private SharedStuff stuff;
    // Logic
    private boolean transitionAllowed, allowedOnce, fadingOut;
    private float time, fadeDuration, transitionMinDuration;

    public void startTransition(Initializer initializer, float fadeDuration, float transitionMinDuration) {
        this.initializer = initializer;
        logic.getAssetLoader().startLoadingAssets(initializer.getAssets());
        transitionAllowed = false;
        allowedOnce = false;
        time = 0f;
        this.fadeDuration = fadeDuration;
        this.transitionMinDuration = transitionMinDuration;
    }

    public void update(float delta) {
        time += delta;
        updateFader();
        checkAssetsState();
        checkDuration();
    }

    private void updateFader() {
        Sprite fader = stuff.getFader();
        float progress = Math.min(1f, time / fadeDuration);
        if (fadingOut) {
            fader.setColor(Color.CLEAR.cpy().lerp(Color.BLACK, progress));
            if (progress == 1f) {
                showNewScreen();
                stuff.getFader().setColor(Color.CLEAR);
            }
        } else {
            fader.setColor(Color.BLACK.cpy().lerp(Color.CLEAR, progress));
        }
    }

    private void checkAssetsState() {
        if (logic.getAssetLoader().areAssetsReady() && transitionAllowed) {
            fadingOut = true;
            transitionAllowed = false;
            time = 0f;
        }
    }

    private void checkDuration() {
        if (time >= transitionMinDuration) {
            allowTransition();
        }
    }

    private void allowTransition() {
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
        stuff = sharedResources.getStuff();
    }
}