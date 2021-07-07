package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.epicness.fundamentals.ElementID;
import com.epicness.fundamentals.utils.TextUtils;

public class TextButton {

    private final ElementID elementID;
    private final Rectangle bounds;
    protected final Text text;

    public TextButton(ElementID elementID) {
        this.elementID = elementID;
        bounds = new Rectangle();
        text = new Text();
    }

    public void draw(SpriteBatch spriteBatch) {
        text.draw(spriteBatch);
    }

    public boolean contains(float x, float y) {
        return bounds.contains(x, y);
    }

    public void setX(float x) {
        text.setX(x);
        bounds.x = x;
    }

    public void setY(float y) {
        text.setY(y);
        bounds.y = y;
    }

    public ElementID getElementID() {
        return elementID;
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