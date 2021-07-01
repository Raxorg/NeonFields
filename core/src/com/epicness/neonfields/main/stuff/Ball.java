package com.epicness.neonfields.main.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.epicness.neonfields.main.MainConstants.BALL_GLOW_SIZE;
import static com.epicness.neonfields.main.MainConstants.BALL_SIZE;

public class Ball extends Projectile {

    public Ball(Sprite projectileSprite, Sprite projectileGlowSprite) {
        super(projectileSprite, projectileGlowSprite);
        sprite.setSize(BALL_SIZE, BALL_SIZE);
        sprite.setOriginCenter();
        glowSprite.setSize(BALL_GLOW_SIZE, BALL_GLOW_SIZE);
        glowSprite.setOriginCenter();
    }

    public float getX() {
        return sprite.getX();
    }

    public void setX(float x) {
        sprite.setX(x);
        glowSprite.setCenterX(x);
    }

    public float getY() {
        return sprite.getY();
    }

    public void setY(float y) {
        sprite.setY(y);
        glowSprite.setCenterY(y);
    }

    @Override
    public void setColor(Color color) {
        sprite.setColor(color.cpy().lerp(Color.WHITE, 0.6f));
        glowSprite.setColor(color);
    }
}