package com.epicness.neonfields.main.logic.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.stuff.Cell;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.Person;
import com.epicness.neonfields.main.stuff.Platform;

public class PlatformHandler {

    private MainStuff stuff;

    public void spawnInitialPlatforms() {
        DelayedRemovalArray<Platform> platforms = stuff.getPlatforms();
        Cell[][] cells = stuff.getGrid().getCells();

        platforms.add(makePlatform(5, cells, 3, 1));
        platforms.add(makePlatform(5, cells, 11, 3));
        platforms.add(makePlatform(5, cells, 19, 6));

        platforms.add(makePlatform(5, cells, 52, 1));
        platforms.add(makePlatform(5, cells, 44, 3));
        platforms.add(makePlatform(5, cells, 36, 6));

        platforms.add(makePlatform(8, cells, 26, 8));

        platforms.add(makePlatform(3, cells, 14, 8));
        platforms.add(makePlatform(3, cells, 43, 8));

        platforms.add(makePlatform(8, cells, 26, 18));
        platforms.add(makePlatform(6, cells, 27, 17));
        platforms.add(makePlatform(4, cells, 28, 16));
        platforms.add(makePlatform(2, cells, 29, 15));

        // G
        platforms.add(makePlatform(4, cells, 23, 0));
        platforms.add(makePlatform(1, cells, 22, 1));
        platforms.add(makePlatform(1, cells, 26, 1));
        platforms.add(makePlatform(1, cells, 22, 2));
        platforms.add(makePlatform(3, cells, 24, 2));
        platforms.add(makePlatform(1, cells, 22, 3));
        platforms.add(makePlatform(4, cells, 23, 4));
        // D
        platforms.add(makePlatform(4, cells, 28, 0));
        platforms.add(makePlatform(1, cells, 28, 1));
        platforms.add(makePlatform(1, cells, 32, 1));
        platforms.add(makePlatform(1, cells, 28, 2));
        platforms.add(makePlatform(1, cells, 32, 2));
        platforms.add(makePlatform(1, cells, 28, 3));
        platforms.add(makePlatform(1, cells, 32, 3));
        platforms.add(makePlatform(4, cells, 28, 4));
        // X
        platforms.add(makePlatform(1, cells, 34, 0));
        platforms.add(makePlatform(1, cells, 38, 0));
        platforms.add(makePlatform(1, cells, 35, 1));
        platforms.add(makePlatform(1, cells, 37, 1));
        platforms.add(makePlatform(1, cells, 36, 2));
        platforms.add(makePlatform(1, cells, 35, 3));
        platforms.add(makePlatform(1, cells, 37, 3));
        platforms.add(makePlatform(1, cells, 34, 4));
        platforms.add(makePlatform(1, cells, 38, 4));

        platforms.add(makePlatform(4, cells, 20, 11));
        platforms.add(makePlatform(4, cells, 36, 11));

        platforms.add(makePlatform(2, cells, 24, 16));
        platforms.add(makePlatform(2, cells, 34, 16));

        platforms.add(makePlatform(3, cells, 22, 14));
        platforms.add(makePlatform(3, cells, 35, 14));

        platforms.add(makePlatform(7, cells, 3, 5));
        platforms.add(makePlatform(7, cells, 50, 5));

        platforms.add(makePlatform(10, cells, 3, 10));
        platforms.add(makePlatform(10, cells, 47, 10));

        platforms.add(makePlatform(3, cells, 14, 14));
        platforms.add(makePlatform(4, cells, 9, 13));
        platforms.add(makePlatform(3, cells, 5, 14));

        platforms.add(makePlatform(3, cells, 43, 14));
        platforms.add(makePlatform(4, cells, 47, 13));
        platforms.add(makePlatform(3, cells, 52, 14));

        platforms.add(makePlatform(14, cells, 4, 16));
        platforms.add(makePlatform(14, cells, 42, 16));

        platforms.add(makePlatform(4, cells, 28, 21));
        platforms.add(makePlatform(16, cells, 6, 21));
        platforms.add(makePlatform(16, cells, 38, 21));
    }

    public void update() {
        DelayedRemovalArray<Platform> platforms = stuff.getPlatforms();
        Person person = stuff.getPerson();
        platforms.begin();
        for (int i = 0; i < platforms.size; i++) {
            Platform platform = platforms.get(i);
            platform.setColor(person.getColor());
        }
        platforms.end();
    }

    private Platform makePlatform(int length, Cell[][] cells, int startingColumn, int startingRow) {
        Cell[] platformCells = new Cell[length];
        for (int column = 0; column < length; column++) {
            platformCells[column] = cells[startingColumn + column][startingRow];
        }
        Platform platform = new Platform(platformCells);
        platform.setColor(Color.WHITE);
        return platform;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}