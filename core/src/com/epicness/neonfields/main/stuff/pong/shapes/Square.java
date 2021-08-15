package com.epicness.neonfields.main.stuff.pong.shapes;

import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.epicness.neonfields.main.MainConstants.SQUARE_PROJECTILE_ANGLES;
import static com.epicness.neonfields.main.MainConstants.SQUARE_PROJECTILE_SPAWN_COEFFICIENTS;

public class Square extends Shape {

    public Square(Sprite shapeSprite, Sprite shapeGlowSprite) {
        super(shapeSprite, shapeGlowSprite, SQUARE_PROJECTILE_ANGLES, SQUARE_PROJECTILE_SPAWN_COEFFICIENTS);
    }
}