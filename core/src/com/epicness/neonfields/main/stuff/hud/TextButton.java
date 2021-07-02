package com.epicness.neonfields.main.stuff.hud;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Text;

public class TextButton {

    private final Sprite sprite;
    private final Text text;

    public TextButton(Sprite buttonSprite) {
        sprite = new Sprite(buttonSprite);
        text = new Text();
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
        text.draw(spriteBatch);
    }

    public boolean contains(float x, float y) {
        return sprite.getBoundingRectangle().contains(x, y);
    }

    public void setX(float x) {
        sprite.setX(x);
        text.setX(x);
    }

    public void setY(float y) {
        sprite.setY(y);
        text.setY(y + sprite.getHeight() / 2f);
    }

    public void setSize(float width, float height) {
        sprite.setSize(width, height);
        text.setTextTargetWidth(width);
        text.setY(sprite.getY() + sprite.getHeight() / 2f);
    }

    public void setFont(BitmapFont font) {
        text.setFont(font);
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public void setHorizontalAlignment(int horizontalAlignment) {
        text.setHorizontalAlignment(horizontalAlignment);
    }

    public void setCenterVertical(boolean centerVertical) {
        text.setCenterVertical(centerVertical);
    }
}