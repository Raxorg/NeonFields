package com.epicness.neonfields.main.logic.game;

import com.epicness.fundamentals.stuff.Text;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.stuff.MainStuff;

import static com.epicness.neonfields.main.MainConstants.BALL_SPAWN_INTERVAL;

public class BallTimerHandler {

    // Structure
    private MainStuff stuff;
    private MainLogic logic;
    // Logic
    private float time;

    public BallTimerHandler() {
        time = BALL_SPAWN_INTERVAL;
    }

    public void update(float delta) {
        time -= delta;
        Text ballTimer = stuff.getBallTimer();
        if (time <= 0f) {
            logic.getBallHandler().spawnBall();
            time = BALL_SPAWN_INTERVAL;
        }
        ballTimer.setText((int) time + 1 + "");
    }

    public void resetTimer() {
        time = BALL_SPAWN_INTERVAL;
    }

    // Structure
    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }
}