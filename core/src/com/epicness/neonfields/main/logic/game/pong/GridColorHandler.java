package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.stuff.pong.Ball;
import com.epicness.neonfields.main.stuff.pong.Cell;
import com.epicness.neonfields.main.stuff.pong.Grid;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.pong.Projectile;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.neonfields.main.MainConstants.GRID_COLOR_FADE_TIME;
import static com.epicness.neonfields.main.MainConstants.GRID_COLUMNS;
import static com.epicness.neonfields.main.MainConstants.GRID_ROWS;

public class GridColorHandler {

    private MainStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<Ball> balls = stuff.getPongGame().getBalls();
        Grid grid = stuff.getPongGame().getGrid();
        // Balls
        for (int i = 0; i < balls.size; i++) {
            colorBallCell(balls.get(i), grid);
        }
        // Projectiles
        DelayedRemovalArray<Projectile> projectiles = stuff.getPongGame().getProjectiles();
        for (int i = 0; i < projectiles.size; i++) {
            colorProjectileCell(projectiles.get(i), grid);
        }
        // Fade the color over time
        for (int column = 0; column < GRID_COLUMNS; column++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                Cell cell = grid.getCells()[column][row];
                cell.setColorProgress(Math.min(cell.getColorProgress() + delta / GRID_COLOR_FADE_TIME, 1f));
                cell.setColor(cell.getOriginalColor().cpy().lerp(Color.BLACK, cell.getColorProgress()));
            }
        }
    }

    private void colorBallCell(Ball ball, Grid grid) {
        Cell cell = calculateCell(ball.getCenterX(), ball.getCenterY(), grid);
        cell.setOriginalColor(ball.getColor().cpy());
    }

    private void colorProjectileCell(Projectile projectile, Grid grid) {
        Cell cell = calculateCell(projectile.getCenterX(), projectile.getCenterY(), grid);
        cell.setOriginalColor(projectile.getColor().cpy().lerp(Color.BLACK, 0.5f));
    }

    private Cell calculateCell(float x, float y, Grid grid) {
        int column = (int) MathUtils.map(0f, CAMERA_WIDTH, 0f, GRID_COLUMNS, x);
        column = MathUtils.clamp(column, 0, GRID_COLUMNS - 1);
        int row = (int) MathUtils.map(0f, CAMERA_HEIGHT, 0f, GRID_ROWS, y);
        row = MathUtils.clamp(row, 0, GRID_ROWS - 1);
        return grid.getCells()[column][row];
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}