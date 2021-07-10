package com.epicness.neonfields.main.stuff.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.NinePatchButton;
import com.epicness.neonfields.main.MainAssets;

import static com.epicness.neonfields.main.MainConstants.SQUARE_NINEPATCH;
import static com.epicness.neonfields.main.MainConstants.SQUARE_NINEPATCH_GLOW;
import static com.epicness.neonfields.main.MainConstants.START_BUTTON_HEIGHT;
import static com.epicness.neonfields.main.MainConstants.START_BUTTON_WIDTH;
import static com.epicness.neonfields.main.MainConstants.START_BUTTON_X;
import static com.epicness.neonfields.main.MainConstants.START_BUTTON_Y;

public class MainMenu extends Menu {

    private NinePatchButton startButton;

    public MainMenu(SharedAssets sharedAssets, MainAssets assets) {
        super(sharedAssets.getPixel());

        initializeStartButton(assets);
    }

    private void initializeStartButton(MainAssets assets) {
        Texture patch = assets.getTexture(SQUARE_NINEPATCH);
        Texture glowPatch = assets.getTexture(SQUARE_NINEPATCH_GLOW);
        startButton = new NinePatchButton(patch, glowPatch);
        startButton.setX(START_BUTTON_X);
        startButton.setY(START_BUTTON_Y);
        startButton.setSize(START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
        startButton.setFont(assets.getPixelFont4());
        startButton.setText("Start Game");
        startButton.setHorizontalAlignment(Align.center);
        startButton.setCenterVertical(true);
        textButtons.add(startButton);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        startButton.setPosition(x + START_BUTTON_X, y + START_BUTTON_Y);
    }

    public NinePatchButton getStartButton() {
        return startButton;
    }
}