package com.epicness.neonfields.main.logic;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.logic.game.MinigameHandler;
import com.epicness.neonfields.main.logic.game.PongGameHandler;
import com.epicness.neonfields.main.logic.menus.ButtonHandler;
import com.epicness.neonfields.main.logic.menus.MenuHandler;
import com.epicness.neonfields.main.stuff.MainStuff;

import static com.epicness.neonfields.main.MainEnums.MenuID.MAIN_MENU;

public class MainLogic extends Logic {

    // Helpers
    private final MinigameHandler minigameHandler;
    private final PongGameHandler pongGameHandler;

    // Menus
    private final ButtonHandler buttonHandler;
    private final MainInputHandler mainInputHandler;
    private final StartScreenHandler startScreenHandler;
    private final MenuHandler menuHandler;

    public MainLogic() {
        // Game
        minigameHandler = new MinigameHandler();
        pongGameHandler = new PongGameHandler();
        // Menus
        buttonHandler = new ButtonHandler();
        mainInputHandler = new MainInputHandler();
        startScreenHandler = new StartScreenHandler();
        menuHandler = new MenuHandler();
        // Game
        minigameHandler.setLogic(this);
        pongGameHandler.setLogic(this);
        // Menus
        buttonHandler.setLogic(this);
        mainInputHandler.setLogic(this);
        startScreenHandler.setLogic(this);
    }

    public void initialLogic() {
        minigameHandler.initialLogic();

        buttonHandler.setupBehaviors();
        menuHandler.showMenu(MAIN_MENU);

        mainInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {
        minigameHandler.update(delta);
    }

    public void setAssets(MainAssets assets) {
        pongGameHandler.setAssets(assets);
        startScreenHandler.setAssets(assets);
    }

    public void setInput(SharedInput input) {
        mainInputHandler.setInput(input);
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        pongGameHandler.setSharedLogic(sharedLogic);
    }

    public void setStuff(MainStuff stuff) {
        minigameHandler.setStuff(stuff);
        pongGameHandler.setStuff(stuff);
        // Menus
        buttonHandler.setStuff(stuff);
        mainInputHandler.setStuff(stuff);
        startScreenHandler.setStuff(stuff);
        menuHandler.setStuff(stuff);
    }

    // Helpers
    public PongGameHandler getPongGameHandler() {
        return pongGameHandler;
    }

    public ButtonHandler getButtonHandler() {
        return buttonHandler;
    }

    public StartScreenHandler getStartScreenHandler() {
        return startScreenHandler;
    }

    // Menus
    public MenuHandler getMenuHandler() {
        return menuHandler;
    }
}