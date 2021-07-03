package com.epicness.neonfields.main.logic.menus;

import com.epicness.neonfields.main.MainEnums.ElementID;
import com.epicness.neonfields.main.stuff.MainStuff;

public class ButtonHandler {

    private MainStuff stuff;

    public void buttonPressed(ElementID elementID) {
        switch (elementID) {
            case PLAY_BUTTON:
                System.out.println("WORKS");
                break;
            case CREDITS_BUTTON:
                System.out.println("WORKS2");
                break;
        }
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}