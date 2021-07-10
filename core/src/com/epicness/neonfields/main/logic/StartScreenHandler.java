package com.epicness.neonfields.main.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.utils.TextUtils;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.stuff.Life;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.Paddle;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.neonfields.main.MainConstants.LIFE_GLOW_MARGIN;
import static com.epicness.neonfields.main.MainConstants.LIFE_GLOW_VISIBLE_SIZE;
import static com.epicness.neonfields.main.MainConstants.LIFE_Y;
import static com.epicness.neonfields.main.MainConstants.STARTING_PADDLE_LIVES;
import static com.epicness.neonfields.main.MainConstants.STARTING_PERSON_LIVES;
import static com.epicness.neonfields.main.MainEnums.PaddleState.IDLE;
import static com.epicness.neonfields.main.MainEnums.PaddleState.MOVING_DOWN;
import static com.epicness.neonfields.main.MainEnums.PaddleState.MOVING_UP;

public class StartScreenHandler {

    // Structure
    private MainAssets assets;
    private MainLogic logic;
    private MainStuff stuff;
    // Logic
    private boolean gameStarted;

    public void startGame() {
        if (gameStarted) {
            return;
        }
        logic.getMenuHandler().hideMenus();
        InitializePaddleLives();
        InitializePersonLives();
        resetPaddleStates();
        logic.getColorAssigner().assignColors();
        gameStarted = true;
    }

    private void resetPaddleStates() {
        // Left paddle
        Paddle paddle = stuff.getPaddle1();
        if (Gdx.input.isKeyPressed(W)) {
            paddle.setState(MOVING_UP);
            if (Gdx.input.isKeyPressed(S)) {
                paddle.setState(IDLE);
            }
        } else if (Gdx.input.isKeyPressed(S)) {
            paddle.setState(MOVING_DOWN);
        }
        paddle.setControlledByAI(false);
        // Right paddle
        paddle = stuff.getPaddle2();
        if (Gdx.input.isKeyPressed(UP)) {
            paddle.setState(MOVING_UP);
            if (Gdx.input.isKeyPressed(DOWN)) {
                paddle.setState(IDLE);
            }
        } else if (Gdx.input.isKeyPressed(DOWN)) {
            paddle.setState(MOVING_DOWN);
        }
        paddle.setControlledByAI(false);
    }

    public void InitializePaddleLives() {
        DelayedRemovalArray<Life> paddleLives = stuff.getPaddle1Lives();
        paddleLives.begin();
        paddleLives.clear();
        for (int i = 0; i < STARTING_PADDLE_LIVES; i++) {
            Life life = new Life(assets.getHeart(), assets.getHeartGlow());
            life.setPosition(LIFE_GLOW_MARGIN + LIFE_GLOW_VISIBLE_SIZE * i, LIFE_Y);
            paddleLives.add(life);
        }
        paddleLives.end();
        paddleLives = stuff.getPaddle2Lives();
        paddleLives.begin();
        for (int i = 0; i < STARTING_PADDLE_LIVES; i++) {
            Life life = new Life(assets.getHeart(), assets.getHeartGlow());
            life.setPosition(CAMERA_WIDTH + LIFE_GLOW_MARGIN - LIFE_GLOW_VISIBLE_SIZE * 3f + LIFE_GLOW_VISIBLE_SIZE * i, LIFE_Y);
            paddleLives.add(life);
        }
        paddleLives.end();
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