package com.epicness.neonfields.main.stuff.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.epicness.fundamentals.stuff.Button;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public abstract class Menu {

    protected final Sprite background;
    protected final Array<Button> textButtons;

    public Menu(Sprite backgroundSprite) {
        background = new Sprite(backgroundSprite);
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        background.setColor(Color.BLACK.cpy().lerp(Color.CLEAR, 0.4f));

        textButtons = new Array<>();
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        for (int i = 0; i < textButtons.size; i++) {
            textButtons.get(i).draw(spriteBatch);
        }
    }

    public void setPosition(float x, float y) {
        background.setPosition(x, y);
    }

    public Array<Button> getButtons() {
        return textButtons;
    }
}