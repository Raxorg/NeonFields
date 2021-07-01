package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Text {

    private final BitmapFont font;
    private String text;
    private Color color;
    private final Vector2 position;

    public Text(BitmapFont font, String text) {
        this.font = font;
        this.text = text;
        color = Color.WHITE;
        position = new Vector2();
    }

    public void draw(SpriteBatch spriteBatch) {
        font.setColor(color);
        font.draw(spriteBatch, text, position.x, position.y);
    }

    public BitmapFont getFont() {
        return font;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(int x) {
        position.x = x;
    }

    public void setY(int y) {
        position.y = y;
    }
}