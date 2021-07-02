package com.epicness.neonfields.main.stuff.hud;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextButton {

    private final Sprite sprite;
    private final AdvancedText advancedText;

    public TextButton(Sprite buttonSprite) {
        sprite = new Sprite(buttonSprite);
        advancedText = new AdvancedText();
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
        advancedText.draw(spriteBatch);
    }

    public void setX(float x) {
        sprite.setX(x);
        advancedText.setX(x);
    }

    public void setY(float y) {
        sprite.setY(y);
        advancedText.setY(y + sprite.getHeight() / 2f);
    }

    public void setSize(float width, float height) {
        sprite.setSize(width, height);
        advancedText.setTextTargetWidth(width);
        advancedText.setY(sprite.getY() + sprite.getHeight() / 2f);
    }

    public void setFont(BitmapFont font) {
        advancedText.setFont(font);
    }

    public void setText(String text) {
        advancedText.setText(text);
    }

    public void setHorizontalAlignment(int horizontalAlignment) {
        advancedText.setHorizontalAlignment(horizontalAlignment);
    }

    public void setCenterVertical(boolean centerVertical) {
        advancedText.setCenterVertical(centerVertical);
    }

    public void OnCLick() {

    }
}