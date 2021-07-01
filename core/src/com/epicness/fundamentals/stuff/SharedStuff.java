package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.SharedAssets;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;


public class SharedStuff extends Stuff {

    // Structure
    private SharedAssets assets;
    // Stuff
    private Sprite fader;

    @Override
    public void initializeStuff() {
        fader = new Sprite(assets.getPixel());
        fader.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        fader.setColor(Color.BLACK);
    }

    public Sprite getFader() {
        return fader;
    }

    public void setAssets(SharedAssets assets) {
        this.assets = assets;
    }
}