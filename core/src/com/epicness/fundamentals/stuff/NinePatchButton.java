package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.epicness.fundamentals.ElementID;

public class NinePatchButton extends TextButton {

    private final Rectangle boundingBox;
    private final NinePatch ninePatch;
    private final NinePatch glowPatch;

    public NinePatchButton(ElementID elementID, Texture buttonNinePatch, Texture glowNinePatch) {
        super(elementID);
        boundingBox = new Rectangle();
        ninePatch = new NinePatch(buttonNinePatch, 32, 32, 32, 32);
        ninePatch.scale(1, 1);
        glowPatch = new NinePatch(glowNinePatch, 32, 32, 32, 32);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        glowPatch.draw(spriteBatch, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        ninePatch.draw(spriteBatch, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        super.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return boundingBox.contains(x, y);
    }

    @Override
    public void setX(float x) {
        boundingBox.setX(x);
        super.setX(x);
    }

    @Override
    public void setY(float y) {
        boundingBox.setY(y);
        text.setY(y + boundingBox.getHeight() / 2f);
    }

    public void setSize(float width, float height) {
        boundingBox.setSize(width, height);
        text.setTextTargetWidth(width);
        text.setY(boundingBox.getY() + boundingBox.getHeight() / 2f);
    }
}