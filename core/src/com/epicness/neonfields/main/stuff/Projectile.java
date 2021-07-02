package com.epicness.neonfields.main.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.epicness.fundamentals.utils.AngleUtils;

import static com.epicness.neonfields.main.MainConstants.PROJECTILE_GLOW_SIZE;
import static com.epicness.neonfields.main.MainConstants.PROJECTILE_SIZE;

public class Projectile extends NeonSprite {

    private float movementAngle;

    public Projectile(Sprite projectileSprite, Sprite projectileGlowSprite) {
        super(projectileSprite, projectileGlowSprite);
        sprite.setSize(PROJECTILE_SIZE, PROJECTILE_SIZE);
        sprite.setOriginCenter();
        glowSprite.setSize(PROJECTILE_GLOW_SIZE, PROJECTILE_GLOW_SIZE);
        glowSprite.setOriginCenter();
    }

    public float getCenterX() {
        return sprite.getX() + sprite.getWidth() / 2f;
    }

    public float getCenterY() {
        return sprite.getY() + sprite.getHeight() / 2f;
    }

    public Rectangle getBounds() {
        return sprite.getBoundingRectangle();
    }

    public void setPosition(float x, float y) {
        sprite.setOriginBasedPosition(x, y);
        glowSprite.setOriginBasedPosition(x, y);
    }

    public float getMovementAngle() {
        return movementAngle;
    }

    public void setMovementAngle(float movementAngle) {
        this.movementAngle = AngleUtils.normalize(movementAngle);
    }

    public void setColor(Color color) {
        sprite.setColor(color.cpy().lerp(Color.CLEAR, 0.5f));
        glowSprite.setColor(color.cpy().lerp(Color.CLEAR, 0.5f));
    }
}