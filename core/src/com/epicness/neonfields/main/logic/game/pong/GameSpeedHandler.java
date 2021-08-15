package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.neonfields.main.logic.MainLogic;

import static com.epicness.neonfields.main.MainConstants.BALL_STARTING_SPEED;

public class GameSpeedHandler {

    // Structure
    private MainLogic logic;
    // Logic
    private float time;

    public void update(float delta) {
        time += delta;
        float speed = MathUtils.map(0f, 30f, BALL_STARTING_SPEED, BALL_STARTING_SPEED * 2f, time);
        logic.getPongGameHandler().getBallHandler().setBallSpeed(speed);
    }


    public void resetSpeed() {
        logic.getPongGameHandler().getBallHandler().setBallSpeed(BALL_STARTING_SPEED);
        time = 0f;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }
}