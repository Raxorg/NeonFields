package com.epicness.neonfields.splash.logic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.utils.Random;
import com.epicness.neonfields.main.MainInitializer;
import com.epicness.neonfields.splash.SplashStuff;

import static com.epicness.neonfields.splash.SplashConstants.SPLASH_COLOR_INTERVAL;
import static com.epicness.neonfields.splash.SplashConstants.SPLASH_DELAY;

public class SplashHandler {

    private SharedLogic sharedLogic;
    private SplashStuff stuff;
    // Logic
    private Color previousColor, nextColor;
    private float colorProgress, time;

    public void initialize() {
        previousColor = Random.randomColor();
        nextColor = Random.exclusiveRandomColor(previousColor);
        sharedLogic.getTransitionHandler().startTransition(new MainInitializer());
    }

    public void update(float delta) {
        updateColor(delta);
        sharedLogic.getAssetLoader().update();
        sharedLogic.getTransitionHandler().update();
        time += delta;
        if (time >= SPLASH_DELAY) {
            sharedLogic.getTransitionHandler().allowTransition();
        }
    }

    private void updateColor(float delta) {
        colorProgress = Math.min(colorProgress + delta / SPLASH_COLOR_INTERVAL, 1f);
        Sprite splash = stuff.getSplash();
        Sprite splashGlow = stuff.getSplashGlow();

        Color currentColor = previousColor.cpy().lerp(nextColor, colorProgress);
        splash.setColor(currentColor);
        splashGlow.setColor(currentColor);

        if (colorProgress == 1f) {
            previousColor = nextColor.cpy();
            nextColor = Random.exclusiveRandomColor(previousColor);
            colorProgress = 0f;
        }
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(SplashStuff stuff) {
        this.stuff = stuff;
    }
}