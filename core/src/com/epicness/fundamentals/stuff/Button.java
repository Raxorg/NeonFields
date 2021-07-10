package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.logic.ActivationBehavior;
import com.epicness.fundamentals.logic.DragBehavior;
import com.epicness.fundamentals.logic.HoverBehavior;

public abstract class Button {

    private HoverBehavior hoverBehavior;
    private DragBehavior dragBehavior;
    private ActivationBehavior activationBehavior;

    public abstract void draw(SpriteBatch spriteBatch);

    public abstract boolean contains(float x, float y);

    public abstract void setX(float x);

    public abstract void setY(float y);

    public abstract void setColor(Color color);

    public HoverBehavior getHoverBehavior() {
        return hoverBehavior;
    }

    public void setHoverBehavior(HoverBehavior hoverBehavior) {
        this.hoverBehavior = hoverBehavior;
    }

    public DragBehavior getDragBehavior() {
        return dragBehavior;
    }

    public void setDragBehavior(DragBehavior dragBehavior) {
        this.dragBehavior = dragBehavior;
    }

    public ActivationBehavior getActivationBehavior() {
        return activationBehavior;
    }

    public void setActivationBehavior(ActivationBehavior activationBehavior) {
        this.activationBehavior = activationBehavior;
    }
}