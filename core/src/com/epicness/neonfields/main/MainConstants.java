package com.epicness.neonfields.main;

import com.badlogic.gdx.math.Vector2;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class MainConstants {

    // Buttons
    public static final float START_BUTTON_WIDTH = 210f;
    public static final float START_BUTTON_HEIGHT = 150f;
    public static final float START_BUTTON_X = CAMERA_WIDTH / 2f - START_BUTTON_WIDTH / 2f;
    public static final float START_BUTTON_Y = CAMERA_HEIGHT / 2f - START_BUTTON_HEIGHT / 2f;
    public static final float QUIT_BUTTON_WIDTH = 210f;
    public static final float QUIT_BUTTON_HEIGHT = 150f;
    public static final float QUIT_BUTTON_X = START_BUTTON_X;
    public static final float QUIT_BUTTON_Y = START_BUTTON_Y - 150f;
    // Grid
    public static final float CELL_SIZE = CAMERA_HEIGHT / 30f;
    public static final int GRID_COLUMNS = (int) (CAMERA_WIDTH / CELL_SIZE);
    public static final int GRID_ROWS = (int) (CAMERA_HEIGHT / CELL_SIZE);
    public static final float GRID_COLOR_FADE_TIME = 2f;

    // Shape zone
    public static final float SHAPE_ZONE_MARGIN = 100f;

    // Players
    public static final int STARTING_PADDLE_LIVES = 1;
    public static final int STARTING_PERSON_LIVES = 1;

    // Paddles
    public static final float PADDLE_WIDTH = 25f;
    public static final float PADDLE_HEIGHT = 100f;
    public static final float PADDLE_1_X = SHAPE_ZONE_MARGIN / 2f - PADDLE_WIDTH / 2f;
    public static final float PADDLE_2_X = CAMERA_WIDTH - SHAPE_ZONE_MARGIN / 2f - PADDLE_WIDTH / 2f;
    public static final float PADDLE_STARTING_Y = (CAMERA_HEIGHT - SHAPE_ZONE_MARGIN) / 2f - PADDLE_HEIGHT / 2f;
    public static final float PADDLE_GLOW_WIDTH = PADDLE_WIDTH * 3f;
    public static final float PADDLE_GLOW_HEIGHT = PADDLE_HEIGHT * 2f;
    public static final float PADDLE_SPEED = 600f;
    public static final float PADDLE_AI_SPEED = 15f;
    public static final float MAX_PADDLE_Y = CAMERA_HEIGHT - SHAPE_ZONE_MARGIN - PADDLE_HEIGHT;
    public static final float MIN_PADDLE_Y = 0f;
    public static final int PADDLE_EXPLOSION_PROJECTILES = 32;

    // Person
    public static final float PERSON_WIDTH = 25f;
    public static final float PERSON_HEIGHT = 50f;
    public static final float PERSON_BOUNDS_MARGIN = PERSON_WIDTH / 5f;
    public static final float PERSON_BOUNDS_WIDTH = PERSON_WIDTH - PERSON_BOUNDS_MARGIN * 2f;
    public static final float PERSON_BOUNDS_HEIGHT = PERSON_HEIGHT - PERSON_BOUNDS_MARGIN * 2f;
    public static final float PERSON_STARTING_X = CAMERA_WIDTH / 2f - PERSON_WIDTH / 2f;
    public static final float PERSON_STARTING_Y = 0;
    public static final float PERSON_GLOW_WIDTH = PERSON_WIDTH * 3f;
    public static final float PERSON_GLOW_HEIGHT = PERSON_HEIGHT * 2f;
    public static final float PERSON_SPEED = 300f;
    public static final float PERSON_MIN_X = SHAPE_ZONE_MARGIN;
    public static final float PERSON_MAX_X = CAMERA_WIDTH - SHAPE_ZONE_MARGIN - PERSON_WIDTH;
    public static final int PERSON_EXPLOSION_PROJECTILES = 32;

    //------------------------//
    //         Shapes         //
    //------------------------//
    public static final float SHAPE_SIZE = 25f;
    public static final float SHAPE_GLOW_SIZE = SHAPE_SIZE * 3f;
    public static final float SHAPE_GENERATION_INTERVAL = 1f;
    // Circle
    public static final Vector2[] CIRCLE_PROJECTILE_SPAWN_COEFFICIENTS = {
            new Vector2(1f, 0.5f),
            new Vector2(0.75f, 0.75f),
            new Vector2(0.5f, 1f),
            new Vector2(0.25f, 0.75f),
            new Vector2(0f, 0.5f),
            new Vector2(0.25f, 0.25f),
            new Vector2(0.5f, 0f),
            new Vector2(0.75f, 0.25f)
    };
    public static final float[] CIRCLE_PROJECTILE_ANGLES = {0f, 45f, 90f, 135f, 180f, 225f, 270f, 315f};
    // Triangle
    public static final Vector2[] TRIANGLE_PROJECTILE_SPAWN_COEFFICIENTS = {
            new Vector2(1f, 0f),
            new Vector2(0.5f, 1f),
            new Vector2(0f, 0f)
    };
    public static final float[] TRIANGLE_PROJECTILE_ANGLES = {330f, 90f, 210f};
    // Square
    public static final Vector2[] SQUARE_PROJECTILE_SPAWN_COEFFICIENTS = {
            new Vector2(1f, 1f),
            new Vector2(0f, 1f),
            new Vector2(0f, 0f),
            new Vector2(1f, 0f)
    };
    public static final float[] SQUARE_PROJECTILE_ANGLES = {45f, 135f, 225f, 315f};
    // Romb
    public static final Vector2[] ROMB_PROJECTILE_SPAWN_COEFFICIENTS = {
            new Vector2(1f, 0.5f),
            new Vector2(0.5f, 1f),
            new Vector2(0f, 0.5f),
            new Vector2(0.5f, 0f)
    };
    public static final float[] ROMB_PROJECTILE_ANGLES = {0f, 90f, 180f, 270f};

    // Ball
    public static final float BALL_SIZE = CELL_SIZE / 2f;
    public static final float BALL_GLOW_SIZE = BALL_SIZE * 5f;
    public static final float BALL_STARTING_SPEED = 200f;
    public static final float MAX_BALL_Y = CAMERA_HEIGHT - SHAPE_ZONE_MARGIN - BALL_SIZE;
    public static final float MIN_BALL_Y = 0f;
    public static final int BALL_EXPLOSION_PROJECTILES = 32;

    // Projectiles
    public static final float PROJECTILE_SIZE = SHAPE_SIZE / 3f;
    public static final float PROJECTILE_GLOW_SIZE = PROJECTILE_SIZE * 5f;
    public static final float PROJECTILE_SPEED = BALL_STARTING_SPEED / 2f;

    // Ball timer
    public static final float BALL_SPAWN_INTERVAL = 5f;

    // Lives
    public static final float LIFE_GLOW_SIZE = SHAPE_ZONE_MARGIN;
    public static final float LIFE_SIZE = LIFE_GLOW_SIZE / 3f;
    public static final float LIFE_GLOW_VISIBLE_SIZE = LIFE_GLOW_SIZE * 0.85f;
    public static final float LIFE_Y = CAMERA_HEIGHT - SHAPE_ZONE_MARGIN / 2f - LIFE_SIZE / 2f;
    public static final float LIFE_GLOW_MARGIN = LIFE_GLOW_VISIBLE_SIZE / 2f - LIFE_SIZE / 2f;

    // Assets
    public static final String SQUARE_NINEPATCH = "images/main/squareNinepatch.png";
    public static final String SQUARE_NINEPATCH_GLOW = "images/main/squareNinepatchGlow.png";

    // Game Over
    public static final float GAME_OVER_DELAY = 3f;

    private MainConstants() {
    }
}