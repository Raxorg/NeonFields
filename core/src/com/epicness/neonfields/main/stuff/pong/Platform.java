package com.epicness.neonfields.main.stuff.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public class Platform {

    private final Cell[] cells;
    private float time;

    public Platform(Cell[] cells) {
        this.cells = cells;
    }

    public void setColor(Color color) {
        for (Cell cell : cells) {
            cell.setOriginalColor(color);
        }
    }

    public Rectangle getBounds() {
        float x = cells[0].getX();
        float y = cells[0].getY();
        float w = cells[0].getWidth() * cells.length;
        float h = cells[0].getHeight();
        return new Rectangle(x, y, w, h);
    }

    public float getTop() {
        return cells[0].getY() + cells[0].getHeight();
    }

    public Cell[] getCells() {
        return cells;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}