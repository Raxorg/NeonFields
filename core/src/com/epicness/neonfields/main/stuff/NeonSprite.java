package com.epicness.neonfields.main.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class NeonSprite {

    protected final Sprite sprite, glowSprite;

    public NeonSprite(Sprite sprite, Sprite glowSprite) {
        this.sprite = new Sprite(sprite);
        this.glowSprite = new Sprite(glowSprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        glowSprite.draw(spriteBatch);
        sprite.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        glowSprite.setCenter(x + sprite.getWidth() / 2f, y + sprite.getHeight() / 2f);
    }

    public Color getColor() {
        return glowSprite.getColor();
    }

    public void setColor(Color color) {
        sprite.setColor(color.cpy().lerp(Color.WHITE, 0.6f));
        glowSprite.setColor(color);
    }
}