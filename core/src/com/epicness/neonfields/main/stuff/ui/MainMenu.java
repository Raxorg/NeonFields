package com.epicness.neonfields.main.stuff.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.NinePatchButton;
import com.epicness.neonfields.main.MainAssets;

import static com.epicness.neonfields.main.MainConstants.*;

public class MainMenu extends Menu {

    private NinePatchButton startButton, quitButton;

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
        buttons.add(startButton);

        quitButton = new NinePatchButton(patch, glowPatch);
        quitButton.setX(QUIT_BUTTON_X);
        quitButton.setY(QUIT_BUTTON_Y);
        quitButton.setSize(QUIT_BUTTON_WIDTH, QUIT_BUTTON_HEIGHT);
        quitButton.setFont(assets.getPixelFont4());
        quitButton.setText("Quit Game");
        quitButton.setHorizontalAlignment(Align.center);
        quitButton.setCenterVertical(true);
        buttons.add(quitButton);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        startButton.setPosition(x + START_BUTTON_X, y + START_BUTTON_Y);
        quitButton.setPosition(x + QUIT_BUTTON_X, y + QUIT_BUTTON_Y);
    }

    public NinePatchButton getStartButton() {
        return startButton;
    }

    public NinePatchButton getQuitButton() { return quitButton; }
}