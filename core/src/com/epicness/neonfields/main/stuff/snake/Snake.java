package com.epicness.neonfields.main.stuff.snake;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.stuff.NeonSprite;

public class Snake {

    private final DelayedRemovalArray<NeonSprite> parts;

    public Snake() {
        parts = new DelayedRemovalArray<>();
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < parts.size; i++) {
            parts.get(i).draw(spriteBatch);
        }
    }

    public DelayedRemovalArray<NeonSprite> getParts() {
        return parts;
    }
}