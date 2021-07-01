package com.epicness.neonfields.main.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.utils.TextUtils;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.stuff.Life;
import com.epicness.neonfields.main.stuff.MainStuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.neonfields.main.MainConstants.LIFE_GLOW_MARGIN;
import static com.epicness.neonfields.main.MainConstants.LIFE_GLOW_VISIBLE_SIZE;
import static com.epicness.neonfields.main.MainConstants.LIFE_Y;
import static com.epicness.neonfields.main.MainConstants.STARTING_PADDLE_LIVES;
import static com.epicness.neonfields.main.MainConstants.STARTING_PERSON_LIVES;
import static com.epicness.neonfields.main.MainEnums.PaddleState.IDLE;

public class StartScreenHandler {

    // Structure
    private MainAssets assets;
    private MainLogic logic;
    private MainStuff stuff;
    // Logic
    private boolean gameStarted;

    public void enterPressed() {
        stuff.getStartScreenText().setColor(Color.CLEAR);
        InitializePaddleLives();
        InitializePersonLives();
        stuff.getPaddle1().setState(IDLE);
        stuff.getPaddle2().setState(IDLE);
        stuff.getPaddle1().setControlledByAI(false);
        stuff.getPaddle2().setControlledByAI(false);
        logic.getColorAssigner().assignColors();
        gameStarted = true;
    }

    public void InitializePaddleLives() {
        for (int i = 0; i < STARTING_PADDLE_LIVES; i++) {
            Life life = new Life(assets.getHeart(), assets.getHeartGlow());
            life.setPosition(LIFE_GLOW_MARGIN + LIFE_GLOW_VISIBLE_SIZE * i, LIFE_Y);
            stuff.getPaddle1Lives().add(life);
        }
        for (int i = 0; i < STARTING_PADDLE_LIVES; i++) {
            Life life = new Life(assets.getHeart(), assets.getHeartGlow());
            life.setPosition(CAMERA_WIDTH + LIFE_GLOW_MARGIN - LIFE_GLOW_VISIBLE_SIZE * 3f + LIFE_GLOW_VISIBLE_SIZE * i, LIFE_Y);
            stuff.getPaddle2Lives().add(life);
        }
    }

    public void InitializePersonLives() {
        float offset = TextUtils.getTextWidth(assets.getPixelFont4(), "10");
        for (int i = 0; i < STARTING_PERSON_LIVES; i++) {
            Life life = new Life(assets.getHeart(), assets.getHeartGlow());
            float x = CAMERA_WIDTH / 2f + LIFE_GLOW_VISIBLE_SIZE * i - LIFE_GLOW_VISIBLE_SIZE + LIFE_GLOW_MARGIN - offset / 2f;
            if (i >= 1) {
                x += offset;
            }
            life.setPosition(x, LIFE_Y);
            stuff.getPersonLives().add(life);
        }
    }

    // Structure
    public void setAssets(MainAssets assets) {
        this.assets = assets;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }

    public boolean getGameStarted() {
        return gameStarted;
    }
}