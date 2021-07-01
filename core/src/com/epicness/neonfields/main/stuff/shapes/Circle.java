package com.epicness.neonfields.main.stuff.shapes;

import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.epicness.neonfields.main.MainConstants.CIRCLE_PROJECTILE_ANGLES;
import static com.epicness.neonfields.main.MainConstants.CIRCLE_PROJECTILE_SPAWN_COEFFICIENTS;

public class Circle extends Shape {

    public Circle(Sprite sprite, Sprite glowSprite) {
        super(sprite, glowSprite, CIRCLE_PROJECTILE_ANGLES, CIRCLE_PROJECTILE_SPAWN_COEFFICIENTS);
    }
}