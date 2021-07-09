package com.epicness.neonfields.main.stuff.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.epicness.fundamentals.stuff.NinePatchButton;
import com.epicness.fundamentals.stuff.TextButton;
import com.epicness.neonfields.main.MainAssets;

import static com.epicness.fundamentals.ElementID.PLAY_BUTTON;

public class ButtonHolder {

    private final Array<TextButton> textButtons;

    public ButtonHolder(MainAssets assets) {
        textButtons = new Array<>();

        // EXAMPLE OF TEXT BUTTON
        Texture patch = new Texture(Gdx.files.internal("images/main/squareNinepatch.png"));
        NinePatchButton test = new NinePatchButton(PLAY_BUTTON, patch);
        test.setX(200f);
        test.setY(200f);
        test.setSize(200f, 140f);
        test.setFont(assets.getPixelFont4());
        test.setText("Start Game");
        test.setHorizontalAlignment(Align.center);
        test.setCenterVertical(true);
        textButtons.add(test);
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < textButtons.size; i++) {
            textButtons.get(i).draw(spriteBatch);
        }
    }

    public Array<TextButton> getButtons() {
        return textButtons;
    }
}