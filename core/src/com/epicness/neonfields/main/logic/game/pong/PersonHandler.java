package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.pong.Person;
import com.epicness.neonfields.main.stuff.pong.Platform;

import static com.epicness.neonfields.main.MainConstants.PERSON_MAX_X;
import static com.epicness.neonfields.main.MainConstants.PERSON_MIN_X;
import static com.epicness.neonfields.main.MainConstants.PERSON_SPEED;
import static com.epicness.neonfields.main.MainConstants.PERSON_STARTING_X;
import static com.epicness.neonfields.main.MainConstants.PERSON_STARTING_Y;
import static com.epicness.neonfields.main.MainConstants.PERSON_WIDTH;
import static com.epicness.neonfields.main.MainEnums.PersonState.IDLE;
import static com.epicness.neonfields.main.MainEnums.PersonState.JUMPING;
import static com.epicness.neonfields.main.MainEnums.PersonState.RUNNING;

public class PersonHandler {

    private MainStuff stuff;


    public void update(float delta) {
        Person person = stuff.getPongGame().getPerson();
        if (person.getState() == IDLE) {
            return;
        }
        updateXPosition(person, delta);
        updateYPosition(person, delta);
        updateRunAnimation(person, delta);
    }

    private void updateXPosition(Person person, float delta) {
        person.translateX(person.getXSpeed() * delta);
        if (person.getX() <= PERSON_MIN_X) {
            person.setX(PERSON_MIN_X);
            handleBorderCollision(person);
        }
        if (person.getX() > PERSON_MAX_X) {
            person.setX(PERSON_MAX_X);
            handleBorderCollision(person);
        }
    }

    private void handleBorderCollision(Person person) {
        switch (stuff.getGameMode()) {
            case STANDARD:
                person.setXSpeed(-person.getXSpeed());
                break;
            case QUAD_BATTLE:
                person.setState(IDLE);
                break;
        }
    }

    private void updateYPosition(Person person, float delta) {
        float oldY = person.getY();
        float y = person.getY() + person.getYSpeed() * delta;
        person.setY(y);
        float ySpeed = person.getYSpeed() - 1100f * delta;
        person.setYSpeed(ySpeed);
        if (ySpeed < 0f) {
            checkLanding(person, oldY);
        }
    }

    private void checkLanding(Person person, float oldY) {
        if (person.getY() <= 0f) {
            person.setY(0f);
            person.setYSpeed(0f);
            person.setState(RUNNING);
            return;
        }
        DelayedRemovalArray<Platform> platforms = stuff.getPongGame().getPlatforms();
        Vector2 personPosition = new Vector2(person.getX(), person.getY());
        Vector2 personRightPosition = personPosition.cpy().add(PERSON_WIDTH, 0);
        for (int i = 0; i < platforms.size; i++) {
            Platform platform = platforms.get(i);
            Rectangle platformBounds = platform.getBounds();
            if (platformBounds.contains(personPosition) || platformBounds.contains(personRightPosition)) {
                if (platform.getTop() > oldY) {
                    continue;
                }
                person.setY(platform.getTop());
                person.setYSpeed(0f);
                person.setState(RUNNING);
            }
        }
    }

    private void updateRunAnimation(Person person, float delta) {
        if (person.getState() == IDLE) {
            return;
        }
        person.setTime(person.getTime() + delta);
        if (person.getTime() >= 0.1f) {
            person.toggleRunSprite();
            person.setTime(person.getTime() - 0.1f);
        }
    }

    public void spacePress() {
        if (stuff.getPongGame().getPersonLives().size <= 0) {
            return;
        }
        Person person = stuff.getPongGame().getPerson();
        switch (stuff.getGameMode()) {
            case STANDARD:
                standardSpacePress(person);
                break;
            case QUAD_BATTLE:
                quadBattleSpacePress(person);
                break;
        }
    }

    private void standardSpacePress(Person person) {
        switch (person.getState()) {
            case IDLE:
                person.setXSpeed(PERSON_SPEED);
                person.setState(RUNNING);
                person.toggleRunSprite();
                break;
            case RUNNING:
                person.setYSpeed(500f);
                person.setState(JUMPING);
                break;
        }
    }

    private void quadBattleSpacePress(Person person) {
        switch (person.getState()) {
            case IDLE:
                person.setXSpeed(PERSON_SPEED);
                person.setState(RUNNING);
                break;
            case RUNNING:
                person.setXSpeed(-person.getXSpeed());
                break;
        }
    }

    public void respawn() {
        Person person = stuff.getPongGame().getPerson();
        person.setPosition(PERSON_STARTING_X, PERSON_STARTING_Y);
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}