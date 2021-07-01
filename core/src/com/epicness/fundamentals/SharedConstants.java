package com.epicness.fundamentals;

import com.badlogic.gdx.Gdx;

public class SharedConstants {

    // Camera
    public static final float RATIO = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
    public static final int CAMERA_HEIGHT = 1000;
    public static final int CAMERA_WIDTH = (int) (CAMERA_HEIGHT * RATIO);
}