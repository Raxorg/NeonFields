package com.epicness.neonfields.main.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.neonfields.main.MainInitializer;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.pong.PongGame;

import static com.epicness.neonfields.main.MainConstants.GAME_OVER_TRANSITION_FADE_DURATION;
import static com.epicness.neonfields.main.MainConstants.GAME_OVER_TRANSITION_MIN_DURATION;

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
        PongGame pongGame = stuff.getPongGame();
        int deadPlayers = 0;
        if (pongGame.getPersonLives().size <= 0) {
            deadPlayers++;
        }
        if (pongGame.getPaddle1Lives().size <= 0) {
            deadPlayers++;
        }
        if (pongGame.getPaddle2Lives().size <= 0) {
            deadPlayers++;
        }
        if (deadPlayers >= 2) {
            String winner = "BUG";
            if (pongGame.getPersonLives().size > 0) {
                winner = "PERSON";
            }
            if (pongGame.getPaddle1Lives().size > 0) {
                winner = "LEFT PADDLE";
            }
            if (pongGame.getPaddle2Lives().size > 0) {
                winner = "RIGHT PADDLE";
            }

            // Set all players to AI (for looks)
            pongGame.getPaddle1().setControlledByAI(true);
            pongGame.getPaddle2().setControlledByAI(true);
            pongGame.getPerson().setControlledByAI(true);

            pongGame.getGameOverText().setText(winner + " WINS");
            gameEnded = true;
            pongGame.getPersonLives().clear();
            pongGame.getPaddle1Lives().clear();
            pongGame.getPaddle2Lives().clear();
        }
    }

    public void update(float delta) {
        if (gameEnded) {
            gameOverDelay += delta;
            if (gameOverDelay > GAME_OVER_TRANSITION_MIN_DURATION) {
                sharedLogic.getTransitionHandler().startTransition(
                        new MainInitializer(),
                        GAME_OVER_TRANSITION_FADE_DURATION,
                        GAME_OVER_TRANSITION_MIN_DURATION);
                sharedLogic.getTransitionHandler().update(delta);
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
        PongGame pongGame = stuff.getPongGame();
        pongGame.getGameOverText().setText("PANCAKE WINS");
        pongGame.getPancake().setColor(Color.WHITE);
        gameEnded = true;
        pongGame.getPersonLives().clear();
        pongGame.getPaddle1Lives().clear();
        pongGame.getPaddle2Lives().clear();
    }
}