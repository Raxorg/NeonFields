package com.epicness.neonfields.main.logic.menus;

import com.epicness.neonfields.main.MainEnums.MenuID;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.ui.Menu;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class MenuHandler {

    // Structure
    private MainStuff stuff;
    // Logic
    private Menu currentMenu;

    public void showMenu(MenuID menuID) {
        hideMenus();
        switch (menuID) {
            case MAIN_MENU:
                stuff.getMainMenu().setPosition(0f, 0f);
                currentMenu = stuff.getMainMenu();
                break;
            case CREDITS:
                break;
        }
    }

    public void hideMenus() {
        stuff.getMainMenu().setPosition(-CAMERA_WIDTH, -CAMERA_HEIGHT);
        currentMenu = null;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    // Structure
    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}