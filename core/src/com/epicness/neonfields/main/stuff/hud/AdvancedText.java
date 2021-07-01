package com.epicness.neonfields.main.stuff.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.utils.TextUtils;

public class AdvancedText extends Text {

    private int horizontalAlignment;
    private boolean centerVertical;
    private String truncate;

    @Override
    public void draw(SpriteBatch spriteBatch) {
        getFont().setColor(color);
        getFont().draw(
                spriteBatch,
                text,
                bounds.x,
                centerVertical ? bounds.y + bounds.height / 2f : bounds.y,
                0,
                text.length(),
                bounds.width,
                horizontalAlignment,
                true,
                truncate);
    }

    @Override
    protected void calculateSize() {
        bounds.height = TextUtils.getTextHeight(getFont(), text, bounds.width, horizontalAlignment, true, truncate);
    }

    public void setPosition(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setX(float x) {
        bounds.x = x;
    }

    public void setY(float y) {
        bounds.y = y;
    }

    public void setTextTargetWidth(float textWidth) {
        bounds.width = textWidth;
    }

    public void setHorizontalAlignment(int horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public void setCenterVertical(boolean centerVertical) {
        this.centerVertical = centerVertical;
    }

    public void setTruncate(String truncate) {
        this.truncate = truncate;
    }
}