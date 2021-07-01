package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Sprited {

    protected Sprite sprite;

    public Sprited(Sprite sprite) {
        this.sprite = new Sprite(sprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }
}