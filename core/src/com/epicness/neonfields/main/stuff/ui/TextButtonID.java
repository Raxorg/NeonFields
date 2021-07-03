package com.epicness.neonfields.main.stuff.ui;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.TextButton;
import com.epicness.neonfields.main.MainEnums.ElementID;

public class TextButtonID extends TextButton {

    private final ElementID elementID;

    public TextButtonID(Sprite buttonSprite, ElementID elementID) {
        super(buttonSprite);
        this.elementID = elementID;
    }

    public ElementID getElementID() {
        return elementID;
    }
}