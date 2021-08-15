package com.epicness.neonfields.main.stuff.pong.shapes;

import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.epicness.neonfields.main.MainConstants.TRIANGLE_PROJECTILE_ANGLES;
import static com.epicness.neonfields.main.MainConstants.TRIANGLE_PROJECTILE_SPAWN_COEFFICIENTS;

public class Triangle extends Shape {

    private float time;

    public Triangle(Sprite sprite, Sprite glowSprite) {
        super(sprite, glowSprite, TRIANGLE_PROJECTILE_ANGLES, TRIANGLE_PROJECTILE_SPAWN_COEFFICIENTS);
    }

    public float getTime() {
        return time;
    }

    public void addTime(float timeToAdd) {
        time += timeToAdd;
    }
}