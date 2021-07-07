package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Vector;

public class TextButton {

    private Rectangle boundingBox;
    private final Text text;
    private NinePatch ninePatch;

    public TextButton() {
        text = new Text();
        boundingBox = new Rectangle();
        Texture patch = new Texture(Gdx.files.internal("images/buttonPatch.png"));
        ninePatch = new NinePatch(patch, 1, 1, 1, 1);
        ninePatch.scale(8, 8);
    }

    public void draw(SpriteBatch spriteBatch) {
        //sprite.draw(spriteBatch);
        ninePatch.draw(spriteBatch, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        text.draw(spriteBatch);
    }

    public boolean contains(float x, float y) {
        return boundingBox.contains(x, y);
    }

    public void setX(float x) {
        boundingBox.setX(x);
        text.setX(x);
    }

    public void setY(float y) {
        boundingBox.setY(y);
        text.setY(y + boundingBox.getHeight() / 2f);
    }

    public void setSize(float width, float height) {
        boundingBox.setSize(width + 20, height + 20);
        text.setTextTargetWidth(width);
        text.setY(boundingBox.getY() + boundingBox.getHeight() / 2f);
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