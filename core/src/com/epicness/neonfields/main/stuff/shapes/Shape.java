package com.epicness.neonfields.main.stuff.shapes;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.epicness.neonfields.main.stuff.NeonSprite;

import static com.epicness.neonfields.main.MainConstants.SHAPE_GLOW_SIZE;
import static com.epicness.neonfields.main.MainConstants.SHAPE_SIZE;

public abstract class Shape extends NeonSprite {

    private final float[] explosionAngles;
    private final Vector2[] projectileSpawnCoefficients;

    public Shape(Sprite shapeSprite, Sprite shapeGlowSprite, float[] explosionAngles, Vector2[] projectileSpawnCoefficients) {
        super(shapeSprite, shapeGlowSprite);
        sprite.setSize(SHAPE_SIZE, SHAPE_SIZE);
        glowSprite.setSize(SHAPE_GLOW_SIZE, SHAPE_GLOW_SIZE);
        glowSprite.setOriginCenter();
        glowSprite.setOriginBasedPosition(SHAPE_SIZE / 2f, SHAPE_SIZE / 2f);
        this.explosionAngles = explosionAngles;
        this.projectileSpawnCoefficients = projectileSpawnCoefficients;
    }

    public Rectangle getBounds() {
        return sprite.getBoundingRectangle();
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public float[] getExplosionAngles() {
        return explosionAngles;
    }

    public Vector2[] getProjectileSpawnCoefficients() {
        return projectileSpawnCoefficients;
    }
}