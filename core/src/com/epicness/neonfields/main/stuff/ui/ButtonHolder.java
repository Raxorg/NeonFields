package com.epicness.neonfields.main.stuff.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.epicness.neonfields.main.MainAssets;

import static com.epicness.neonfields.main.MainEnums.ElementID.PLAY_BUTTON;

public class ButtonHolder {

    private final Array<TextButtonID> buttons;

    public ButtonHolder(MainAssets assets) {
        buttons = new Array<>();

        // EXAMPLE OF TEXT BUTTON
        TextButtonID test = new TextButtonID(assets.getPixel(), PLAY_BUTTON);
        test.setX(200f);
        test.setY(200f);
        test.setSize(100f, 50f);
        test.setFont(assets.getPixelFont4());
        test.setText("ASD");
        test.setHorizontalAlignment(Align.center);
        test.setCenterVertical(true);
        buttons.add(test);
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < buttons.size; i++) {
            buttons.get(i).draw(spriteBatch);
        }
    }

    public Array<TextButtonID> getButtons() {
        return buttons;
    }
}