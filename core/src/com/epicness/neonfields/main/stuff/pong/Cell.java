package com.epicness.neonfields.main.stuff.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cell extends Sprite {

    private Color originalColor;
    private float colorProgress;

    public Cell(Sprite cellSprite) {
        super(cellSprite);
    }

    public void setOriginalColor(Color color) {
        originalColor = color;
        colorProgress = 0f;
        super.setColor(color);
    }

    public Color getOriginalColor() {
        return originalColor;
    }

    public float getColorProgress() {
        return colorProgress;
    }

    public void setColorProgress(float colorProgress) {
        this.colorProgress = colorProgress;
    }
}