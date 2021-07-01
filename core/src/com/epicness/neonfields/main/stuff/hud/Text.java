package com.epicness.neonfields.main.stuff.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.epicness.fundamentals.utils.TextUtils;

public class Text {

    Rectangle bounds;
    private BitmapFont font;
    String text;
    protected Color color;

    Text() {
        bounds = new Rectangle();
        font = new BitmapFont();
        text = "";
        color = Color.WHITE;
    }

    public void draw(SpriteBatch batch) {
        font.setColor(color);
        font.draw(batch, text, bounds.x, bounds.y);
    }

    protected void calculateSize() {
        bounds.width = TextUtils.getTextWidth(font, text);
        bounds.height = TextUtils.getTextHeight(font, text);
    }

    // Getters & Setters
    public Rectangle getBounds() {
        return bounds;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
        calculateSize();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        calculateSize();
    }

    public void setColor(Color color) {
        this.color = color;
    }
}