package com.epicness.neonfields.main.stuff.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.epicness.neonfields.main.MainConstants.CELL_SIZE;
import static com.epicness.neonfields.main.MainConstants.GRID_COLUMNS;
import static com.epicness.neonfields.main.MainConstants.GRID_ROWS;

public class Grid {

    private final Cell[][] cells;

    public Grid(Sprite cellSprite) {
        cells = new Cell[GRID_COLUMNS][];
        for (int column = 0; column < cells.length; column++) {
            cells[column] = new Cell[GRID_ROWS];
            for (int row = 0; row < cells[column].length; row++) {
                cells[column][row] = new Cell(cellSprite);
                cells[column][row].setPosition(column * CELL_SIZE, row * CELL_SIZE);
                cells[column][row].setSize(CELL_SIZE, CELL_SIZE);
                cells[column][row].setOriginalColor(Color.BLACK.cpy().lerp(Color.WHITE, 0.25f));
            }
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int column = 0; column < GRID_COLUMNS; column++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                cells[column][row].draw(spriteBatch);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}