package com.epicness.neonfields.main.stuff.shapes;

import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.epicness.neonfields.main.MainConstants.ROMB_PROJECTILE_ANGLES;
import static com.epicness.neonfields.main.MainConstants.ROMB_PROJECTILE_SPAWN_COEFFICIENTS;

public class Romb extends Shape {

    public Romb(Sprite sprite, Sprite glowSprite) {
        super(sprite, glowSprite, ROMB_PROJECTILE_ANGLES, ROMB_PROJECTILE_SPAWN_COEFFICIENTS);
    }
}