package com.epicness.neonfields.main.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.epicness.neonfields.main.MainEnums.PersonState;
import com.epicness.neonfields.main.stuff.powers.Power;

import static com.epicness.neonfields.main.MainConstants.PERSON_BOUNDS_HEIGHT;
import static com.epicness.neonfields.main.MainConstants.PERSON_BOUNDS_MARGIN;
import static com.epicness.neonfields.main.MainConstants.PERSON_BOUNDS_WIDTH;
import static com.epicness.neonfields.main.MainConstants.PERSON_GLOW_HEIGHT;
import static com.epicness.neonfields.main.MainConstants.PERSON_GLOW_WIDTH;
import static com.epicness.neonfields.main.MainConstants.PERSON_HEIGHT;
import static com.epicness.neonfields.main.MainConstants.PERSON_SPEED;
import static com.epicness.neonfields.main.MainConstants.PERSON_WIDTH;
import static com.epicness.neonfields.main.MainEnums.PersonState.IDLE;
import static com.epicness.neonfields.main.MainEnums.PersonState.RUNNING;

public class Person {

    private final Sprite idle, run1, run2, glow;
    private Sprite current;
    private PersonState state;
    private float xSpeed, ySpeed;
    private Power power;
    private float time;
    private boolean controlledByAI;

    public Person(Sprite idleSprite, Sprite run1Sprite, Sprite run2Sprite, Sprite glowSprite) {
        idle = new Sprite(idleSprite);
        idle.setSize(PERSON_WIDTH, PERSON_HEIGHT);
        run1 = new Sprite(run1Sprite);
        run1.setSize(PERSON_WIDTH, PERSON_HEIGHT);
        run2 = new Sprite(run2Sprite);
        run2.setSize(PERSON_WIDTH, PERSON_HEIGHT);
        glow = new Sprite(glowSprite);
        glow.setSize(PERSON_GLOW_WIDTH, PERSON_GLOW_HEIGHT);
        glow.setOriginCenter();
        current = idle;

        state = RUNNING;
        setXSpeed(PERSON_SPEED);
        controlledByAI = true;
    }

    public void draw(SpriteBatch spriteBatch) {
        glow.draw(spriteBatch);
        current.draw(spriteBatch);
    }

    public float getX() {
        return current.getX();
    }

    public void setX(float x) {
        idle.setX(x);
        run1.setX(x);
        run2.setX(x);
        glow.setCenterX(x + PERSON_WIDTH / 2f);
    }

    public float getY() {
        return current.getY();
    }

    public void setY(float y) {
        idle.setY(y);
        run1.setY(y);
        run2.setY(y);
        glow.setCenterY(y + PERSON_HEIGHT / 2f);
    }

    public Rectangle getBounds() {
        float x = getX() + PERSON_BOUNDS_MARGIN;
        float y = getY() + PERSON_BOUNDS_MARGIN;
        return new Rectangle(x, y, PERSON_BOUNDS_WIDTH, PERSON_BOUNDS_HEIGHT);
    }

    public void setPosition(float x, float y) {
        idle.setPosition(x, y);
        run1.setPosition(x, y);
        run2.setPosition(x, y);
        glow.setCenter(x + PERSON_WIDTH / 2f, y + PERSON_HEIGHT / 2f);
    }

    public void translateX(float x) {
        idle.translateX(x);
        run1.translateX(x);
        run2.translateX(x);
        glow.translateX(x);
    }

    public Color getColor() {
        return glow.getColor();
    }

    public void setColor(Color color) {
        Color whitenedColor = color.cpy().lerp(Color.WHITE, 0.7f);
        idle.setColor(whitenedColor);
        run1.setColor(whitenedColor);
        run2.setColor(whitenedColor);
        glow.setColor(color);
    }

    public void toggleRunSprite() {
        current = current == run1 ? run2 : run1;
        run1.setFlip(xSpeed < 0, false);
        run2.setFlip(xSpeed < 0, false);
    }

    public PersonState getState() {
        return state;
    }

    public void setState(PersonState state) {
        this.state = state;
        if (state == IDLE) {
            current = idle;
        }
    }

    public boolean isControlledByAI() {
        return controlledByAI;
    }

    public void setControlledByAI(boolean controlledByAI) {
        this.controlledByAI = controlledByAI;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}