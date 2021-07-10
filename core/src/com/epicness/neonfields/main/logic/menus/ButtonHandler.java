package com.epicness.neonfields.main.logic.menus;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.logic.ActivationBehavior;
import com.epicness.fundamentals.logic.HoverBehavior;
import com.epicness.fundamentals.stuff.Button;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.stuff.MainStuff;

public class ButtonHandler {

    // Structure
    private MainLogic logic;
    private MainStuff stuff;

    public void setupBehaviors() {
        // Hover behaviors
        for (int i = 0; i < stuff.getMainMenu().getButtons().size; i++) {
            final Button button = stuff.getMainMenu().getButtons().get(i);
            HoverBehavior hoverBehavior = new HoverBehavior() {
                @Override
                public void onHover() {
                    button.setColor(Color.GREEN);
                }

                @Override
                public void onDehover() {
                    button.setColor(Color.RED);
                }
            };
            button.setHoverBehavior(hoverBehavior);
        }
        ActivationBehavior activationBehavior = new ActivationBehavior() {
            @Override
            public void activate() {
                logic.getStartScreenHandler().startGame();
            }
        };
        stuff.getMainMenu().getStartButton().setActivationBehavior(activationBehavior);
    }

    // Input related
    public void buttonHovered(Button button) {
        button.getHoverBehavior().onHover();
    }

    public void buttonDehovered(Button button) {
        button.getHoverBehavior().onDehover();
    }

    public void buttonActivated(Button button) {
        button.getActivationBehavior().activate();
    }

    // Structure
    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}