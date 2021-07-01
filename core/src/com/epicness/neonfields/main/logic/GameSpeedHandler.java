package com.epicness.neonfields.main.logic;

import com.badlogic.gdx.math.MathUtils;

import static com.epicness.neonfields.main.MainConstants.BALL_STARTING_SPEED;

public class GameSpeedHandler {

    // Structure
    private MainLogic logic;
    // Logic
    private float time;

    public void update(float delta) {
        time += delta;
        float speed = MathUtils.map(0f, 30f, BALL_STARTING_SPEED, BALL_STARTING_SPEED * 2f, time);
        logic.getBallHandler().setBallSpeed(speed);
    }


    public void resetSpeed() {
        logic.getBallHandler().setBallSpeed(BALL_STARTING_SPEED);
        time = 0f;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }
}