package com.epicness.neonfields.main.logic.game;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.MainEnums.PlayerID;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.stuff.Life;
import com.epicness.neonfields.main.stuff.MainStuff;

public class DamageHandler {

    private MainLogic logic;
    private MainStuff stuff;

    public void removeLife(PlayerID playerID) {
        DelayedRemovalArray<Life> lives;
        int index;
        switch (playerID) {
            case PADDLE1:
                lives = stuff.getPaddle1Lives();
                index = stuff.getPaddle1Lives().size - 1;
                break;
            case PADDLE2:
                lives = stuff.getPaddle2Lives();
                index = 0;
                break;
            default:
            case PERSON:
                lives = stuff.getPersonLives();
                index = stuff.getPersonLives().size % 2 == 0 ? 0 : stuff.getPersonLives().size - 1;
                // todo give shield
                break;
        }
        if (lives.size > 0) {
            lives.removeIndex(index);
        }
        if (lives.size == 0) {
            logic.getGameOverHandler().checkGameEnded();
            switch (playerID) {
                case PADDLE1:
                    stuff.getPaddle1().setControlledByAI(true);
                    break;
                case PADDLE2:
                    stuff.getPaddle2().setControlledByAI(true);
                case PERSON:
                    stuff.getPerson().setControlledByAI(true);
            }
        } else {
            switch (playerID) {
                case PADDLE1:
                    break;
                case PADDLE2:
                    break;
                case PERSON:
                    logic.getPersonHandler().respawn();
                    break;
            }
        }
    }

    // Structure
    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}