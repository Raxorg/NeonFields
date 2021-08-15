package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.MainEnums.PlayerID;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.pong.Life;

public class DamageHandler {

    private MainLogic logic;
    private MainStuff stuff;

    public void removeLife(PlayerID playerID) {
        DelayedRemovalArray<Life> lives;
        int index;
        switch (playerID) {
            case PADDLE1:
                lives = stuff.getPongGame().getPaddle1Lives();
                index = stuff.getPongGame().getPaddle1Lives().size - 1;
                break;
            case PADDLE2:
                lives = stuff.getPongGame().getPaddle2Lives();
                index = 0;
                break;
            default:
            case PERSON:
                lives = stuff.getPongGame().getPersonLives();
                index = stuff.getPongGame().getPersonLives().size % 2 == 0 ? 0 : stuff.getPongGame().getPersonLives().size - 1;
                // todo give shield
                break;
        }
        if (lives.size > 0) {
            lives.removeIndex(index);
        }
        if (lives.size == 0) {
            logic.getPongGameHandler().getGameOverHandler().checkGameEnded();
            switch (playerID) {
                case PADDLE1:
                    stuff.getPongGame().getPaddle1().setControlledByAI(true);
                    break;
                case PADDLE2:
                    stuff.getPongGame().getPaddle2().setControlledByAI(true);
                case PERSON:
                    stuff.getPongGame().getPerson().setControlledByAI(true);
            }
        } else {
            switch (playerID) {
                case PADDLE1:
                    break;
                case PADDLE2:
                    break;
                case PERSON:
                    logic.getPongGameHandler().getPersonHandler().respawn();
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