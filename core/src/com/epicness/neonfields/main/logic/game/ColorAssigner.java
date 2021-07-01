package com.epicness.neonfields.main.logic.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.utils.Random;
import com.epicness.neonfields.main.stuff.Life;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.Paddle;
import com.epicness.neonfields.main.stuff.Person;

public class ColorAssigner {

    private MainStuff stuff;

    public void assignColors() {
        DelayedRemovalArray<Life> paddle1Lives = stuff.getPaddle1Lives();
        Paddle paddle1 = stuff.getPaddle1();
        DelayedRemovalArray<Life> paddle2Lives = stuff.getPaddle2Lives();
        Paddle paddle2 = stuff.getPaddle2();
        DelayedRemovalArray<Life> personLives = stuff.getPersonLives();
        Person person = stuff.getPerson();
        Array<Color> colors = Random.randomColors(3);
        for (int i = 0; i < paddle1Lives.size; i++) {
            paddle1Lives.get(i).setColor(colors.peek());
        }
        paddle1.setColor(colors.pop());
        for (int i = 0; i < paddle2Lives.size; i++) {
            paddle2Lives.get(i).setColor(colors.peek());
        }
        paddle2.setColor(colors.pop());
        for (int i = 0; i < personLives.size; i++) {
            personLives.get(i).setColor(colors.peek());
        }
        person.setColor(colors.pop());
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}