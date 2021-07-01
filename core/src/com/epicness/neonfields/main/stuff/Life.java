package com.epicness.neonfields.main.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.epicness.neonfields.main.MainConstants.LIFE_GLOW_SIZE;
import static com.epicness.neonfields.main.MainConstants.LIFE_SIZE;

public class Life extends NeonSprite {

    public Life(Sprite lifeSprite, Sprite lifeGlowSprite) {
        super(lifeSprite, lifeGlowSprite);
        sprite.setSize(LIFE_SIZE, LIFE_SIZE);
        glowSprite.setSize(LIFE_GLOW_SIZE, LIFE_GLOW_SIZE);
        glowSprite.setOriginCenter();
    }
}