package com.epicness.neonfields.main.logic.game;

import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.stuff.MainStuff;

public class MinigameHandler {

    private MainStuff stuff;
    private MainLogic logic;

    public void initialLogic() {
        if (stuff.getCurrentMiniGame() == stuff.getPongGame()) {
            logic.getPongGameHandler().initialLogic();
        }
    }

    public void update(float delta) {
        if (stuff.getCurrentMiniGame() == stuff.getPongGame()) {
            logic.getPongGameHandler().update(delta);
        }
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }
}