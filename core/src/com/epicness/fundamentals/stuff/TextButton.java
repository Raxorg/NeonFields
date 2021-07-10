package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.epicness.fundamentals.utils.TextUtils;

public class TextButton extends Button {

    private final Rectangle bounds;
    protected final Text text;

    public TextButton() {
        bounds = new Rectangle();
        text = new Text();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        text.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return bounds.contains(x, y);
    }

    @Override
    public void setX(float x) {
        text.setX(x);
        bounds.x = x;
    }

    @Override
    public void setY(float y) {
        text.setY(y);
        bounds.y = y;
    }

    @Override
    public void setColor(Color color) {
        text.setColor(color);
    }

    public void setPosition(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setFont(BitmapFont font) {
        text.setFont(font);
    }

    public void setText(String newText) {
        text.setText(newText);
        bounds.width = TextUtils.getTextWidth(text.getFont(), newText);
        bounds.height = TextUtils.getTextHeight(text.getFont(), newText);
    }

    public void setHorizontalAlignment(int horizontalAlignment) {
        text.setHorizontalAlignment(horizontalAlignment);
    }

    public void setCenterVertical(boolean centerVertical) {
        text.setCenterVertical(centerVertical);
    }
}