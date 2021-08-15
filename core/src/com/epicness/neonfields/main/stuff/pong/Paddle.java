package com.epicness.neonfields.main.stuff.pong;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.MainEnums.PaddleState;
import com.epicness.neonfields.main.stuff.NeonSprite;

import static com.epicness.neonfields.main.MainConstants.PADDLE_GLOW_HEIGHT;
import static com.epicness.neonfields.main.MainConstants.PADDLE_GLOW_WIDTH;
import static com.epicness.neonfields.main.MainConstants.PADDLE_HEIGHT;
import static com.epicness.neonfields.main.MainConstants.PADDLE_WIDTH;
import static com.epicness.neonfields.main.MainEnums.PaddleState.IDLE;

public class Paddle extends NeonSprite {

    private PaddleState state;
    private final DelayedRemovalArray<Life> lives;
    private boolean controlledByAI;

    public Paddle(Sprite paddleSprite, Sprite paddleGlowSprite) {
        super(paddleSprite, paddleGlowSprite);
        sprite.setSize(PADDLE_WIDTH, PADDLE_HEIGHT);
        sprite.setOriginCenter();
        glowSprite.setSize(PADDLE_GLOW_WIDTH, PADDLE_GLOW_HEIGHT);
        glowSprite.setOriginCenter();
        state = IDLE;
        lives = new DelayedRemovalArray<>();
        controlledByAI = true;
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public void setY(float y) {
        sprite.setY(y);
        glowSprite.setCenterY(y + PADDLE_HEIGHT / 2f);
    }

    public float getCenterY() {
        return sprite.getY() + sprite.getHeight() / 2f;
    }

    public void translateY(float y) {
        sprite.translateY(y);
        glowSprite.translateY(y);
    }

    public Rectangle getBounds() {
        return sprite.getBoundingRectangle();
    }

    public PaddleState getState() {
        return state;
    }

    public void setState(PaddleState state) {
        this.state = state;
    }

    public boolean isControlledByAI() {
        return controlledByAI;
    }

    public void setControlledByAI(boolean controlledByAI) {
        this.controlledByAI = controlledByAI;
    }

    public DelayedRemovalArray<Life> getLives() {
        return lives;
    }
}