package com.epicness.neonfields.main.stuff;

import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.MainEnums.GameMode;
import com.epicness.neonfields.main.stuff.pong.PongGame;
import com.epicness.neonfields.main.stuff.snake.SnakeGame;
import com.epicness.neonfields.main.stuff.ui.MainMenu;

import static com.epicness.neonfields.main.MainEnums.GameMode.STANDARD;


public class MainStuff extends Stuff {

    // Structure
    private SharedAssets sharedAssets;
    private MainAssets assets;
    // Stuff
    private GameMode gameMode;
    private PongGame pongGame;
    private SnakeGame snakeGame;
    private MiniGame currentMiniGame;
    private MainMenu mainMenu;

    public void initializeStuff() {
        gameMode = STANDARD;

        pongGame = new PongGame(assets, sharedAssets);
        snakeGame = new SnakeGame();
        currentMiniGame = pongGame;

        mainMenu = new MainMenu(sharedAssets, assets);
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    // Stuff
    public MiniGame getCurrentMiniGame() {
        return currentMiniGame;
    }

    public PongGame getPongGame() {
        return pongGame;
    }

    public SnakeGame getSnakeGame() {
        return snakeGame;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    // Structure
    public void setSharedAssets(SharedAssets sharedAssets) {
        this.sharedAssets = sharedAssets;
    }

    public void setAssets(MainAssets assets) {
        this.assets = assets;
    }
}