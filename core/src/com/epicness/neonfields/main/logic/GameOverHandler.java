package com.epicness.neonfields.main.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.neonfields.main.MainInitializer;
import com.epicness.neonfields.main.stuff.MainStuff;

import static com.epicness.neonfields.main.MainConstants.GAME_OVER_DELAY;

public class GameOverHandler {

    private MainStuff stuff;
    private MainLogic logic;
    private SharedLogic sharedLogic;
    // Logic
    private boolean gameEnded;
    private float gameOverDelay;

    public void checkGameEnded() {
        if (gameEnded || !logic.getStartScreenHandler().getGameStarted()) {
            return;
        }
        int deadPlayers = 0;
        if (stuff.getPersonLives().size <= 0) {
            deadPlayers++;
        }
        if (stuff.getPaddle1Lives().size <= 0) {
            deadPlayers++;
        }
        if (stuff.getPaddle2Lives().size <= 0) {
            deadPlayers++;
        }
        if (deadPlayers >= 2) {
            String winner = "BUG";
            if (stuff.getPersonLives().size > 0) {
                winner = "PERSON";
            }
            if (stuff.getPaddle1Lives().size > 0) {
                winner = "LEFT PADDLE";
            }
            if (stuff.getPaddle2Lives().size > 0) {
                winner = "RIGHT PADDLE";
            }

            // Set all players to AI (for looks)
            stuff.getPaddle1().setControlledByAI(true);
            stuff.getPaddle2().setControlledByAI(true);
            stuff.getPerson().setControlledByAI(true);

            stuff.getGameOverText().setText(winner + " WINS");
            gameEnded = true;
            stuff.getPersonLives().clear();
            stuff.getPaddle1Lives().clear();
            stuff.getPaddle2Lives().clear();
        }
    }

    public void update(float delta) {
        if(gameEnded) {
            gameOverDelay += delta;
            if(gameOverDelay > GAME_OVER_DELAY) {
                sharedLogic.getTransitionHandler().startTransition(new MainInitializer());
                sharedLogic.getTransitionHandler().allowTransition();
                sharedLogic.getTransitionHandler().update();
            }
        }
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }


    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void pancake() {
        stuff.getGameOverText().setText("PANCAKE WINS");
        stuff.getPancake().setColor(Color.WHITE);
        gameEnded = true;
        stuff.getPersonLives().clear();
        stuff.getPaddle1Lives().clear();
        stuff.getPaddle2Lives().clear();
    }
}