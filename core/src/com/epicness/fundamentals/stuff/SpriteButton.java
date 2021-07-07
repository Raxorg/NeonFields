package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.ElementID;

public class SpriteButton extends TextButton {

    private final Sprite sprite;

    public SpriteButton(ElementID elementID, Sprite buttonSprite) {
        super(elementID);
        sprite = new Sprite(buttonSprite);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
        super.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return sprite.getBoundingRectangle().contains(x, y);
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        sprite.setX(x);
    }

    @Override
    public void setY(float y) {
        sprite.setY(y);
        text.setY(y + sprite.getHeight() / 2f);
    }

    public void setSize(float width, float height) {
        sprite.setSize(width, height);
        text.setTextTargetWidth(width);
        text.setY(sprite.getY() + sprite.getHeight() / 2f);
    }
}