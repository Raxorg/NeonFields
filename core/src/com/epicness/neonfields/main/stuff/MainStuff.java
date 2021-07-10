package com.epicness.neonfields.main.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.MainEnums.GameMode;
import com.epicness.neonfields.main.stuff.shapes.Shape;
import com.epicness.neonfields.main.stuff.ui.MainMenu;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.neonfields.main.MainConstants.PADDLE_1_X;
import static com.epicness.neonfields.main.MainConstants.PADDLE_2_X;
import static com.epicness.neonfields.main.MainConstants.PADDLE_STARTING_Y;
import static com.epicness.neonfields.main.MainConstants.PERSON_STARTING_X;
import static com.epicness.neonfields.main.MainConstants.PERSON_STARTING_Y;
import static com.epicness.neonfields.main.MainConstants.SHAPE_ZONE_MARGIN;
import static com.epicness.neonfields.main.MainEnums.GameMode.STANDARD;


public class MainStuff extends Stuff {

    // Structure
    private SharedAssets sharedAssets;
    private MainAssets assets;
    // Stuff
    private GameMode gameMode;
    private Grid grid;
    private Sprite[] borders;
    private Paddle paddle1, paddle2;
    private DelayedRemovalArray<Shape> shapes;
    private DelayedRemovalArray<Projectile> projectiles;
    private DelayedRemovalArray<Ball> balls;
    private Person person;
    private DelayedRemovalArray<Platform> platforms;
    private Sprite darkener;
    private Text ballTimer;
    private DelayedRemovalArray<Life> paddle1Lives, paddle2Lives, personLives;
    private Text gameOverText;
    private Sprite pancake;
    private MainMenu mainMenu;

    public void initializeStuff() {
        gameMode = STANDARD;

        grid = new Grid(assets.getSquare());

        initializeBorders();
        initializePaddles();

        shapes = new DelayedRemovalArray<>();
        projectiles = new DelayedRemovalArray<>();

        balls = new DelayedRemovalArray<>();

        person = new Person(assets.getPersonIdle(), assets.getPersonRun1(), assets.getPersonRun2(), assets.getPersonGlow());
        person.setPosition(PERSON_STARTING_X, PERSON_STARTING_Y);

        platforms = new DelayedRemovalArray<>();

        darkener = new Sprite(sharedAssets.getPixel());
        darkener.setPosition(0f, CAMERA_HEIGHT - SHAPE_ZONE_MARGIN);
        darkener.setSize(CAMERA_WIDTH, SHAPE_ZONE_MARGIN);
        darkener.setColor(Color.BLACK.cpy().lerp(Color.CLEAR, 0.25f));

        ballTimer = new Text();
        ballTimer.setFont(assets.getPixelFont4());
        ballTimer.setHorizontalAlignment(Align.center);
        ballTimer.setCenterVertical(true);
        ballTimer.setTextTargetWidth(CAMERA_WIDTH);
        ballTimer.setY(CAMERA_HEIGHT - SHAPE_ZONE_MARGIN / 2f);

        initializePaddleLives();
        initializePersonLives();

        gameOverText = new Text();
        gameOverText.setFont(assets.getPixelFont20());
        gameOverText.setHorizontalAlignment(Align.center);
        gameOverText.setCenterVertical(true);
        gameOverText.setTextTargetWidth(CAMERA_WIDTH);
        gameOverText.setY(CAMERA_HEIGHT / 2f);

        pancake = new Sprite(assets.getPancake());
        pancake.setScale(0.75f);
        pancake.setOriginCenter();
        pancake.setOriginBasedPosition(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 5f);
        pancake.setColor(Color.CLEAR);

        mainMenu = new MainMenu(sharedAssets, assets);
    }

    private void initializeBorders() {
        borders = new Sprite[3];
        borders[0] = new Sprite(sharedAssets.getPixel());
        borders[0].setPosition(SHAPE_ZONE_MARGIN, 0f);
        borders[0].setSize(1f, CAMERA_HEIGHT - SHAPE_ZONE_MARGIN);
        borders[1] = new Sprite(sharedAssets.getPixel());
        borders[1].setPosition(CAMERA_WIDTH - SHAPE_ZONE_MARGIN, 0f);
        borders[1].setSize(1f, CAMERA_HEIGHT - SHAPE_ZONE_MARGIN);
        borders[2] = new Sprite(sharedAssets.getPixel());
        borders[2].setPosition(0f, CAMERA_HEIGHT - SHAPE_ZONE_MARGIN - 1f);
        borders[2].setSize(CAMERA_WIDTH, 1f);
    }

    private void initializePaddles() {
        paddle1 = new Paddle(assets.getPaddle(), assets.getPaddleGlow());
        paddle1.setPosition(PADDLE_1_X, PADDLE_STARTING_Y);

        paddle2 = new Paddle(assets.getPaddle(), assets.getPaddleGlow());
        paddle2.setPosition(PADDLE_2_X, PADDLE_STARTING_Y);
    }

    private void initializePaddleLives() {
        paddle1Lives = new DelayedRemovalArray<>();
        paddle2Lives = new DelayedRemovalArray<>();

    }

    private void initializePersonLives() {
        personLives = new DelayedRemovalArray<>();
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    // Stuff
    public Grid getGrid() {
        return grid;
    }

    public Sprite[] getBorders() {
        return borders;
    }

    public Paddle getPaddle1() {
        return paddle1;
    }

    public Paddle getPaddle2() {
        return paddle2;
    }

    public DelayedRemovalArray<Shape> getShapes() {
        return shapes;
    }

    public DelayedRemovalArray<Projectile> getProjectiles() {
        return projectiles;
    }

    public DelayedRemovalArray<Ball> getBalls() {
        return balls;
    }

    public Person getPerson() {
        return person;
    }

    public DelayedRemovalArray<Platform> getPlatforms() {
        return platforms;
    }

    public Sprite getDarkener() {
        return darkener;
    }

    public Text getBallTimer() {
        return ballTimer;
    }

    public DelayedRemovalArray<Life> getPaddle1Lives() {
        return paddle1Lives;
    }

    public DelayedRemovalArray<Life> getPaddle2Lives() {
        return paddle2Lives;
    }

    public DelayedRemovalArray<Life> getPersonLives() {
        return personLives;
    }

    public Text getGameOverText() {
        return gameOverText;
    }

    public Sprite getPancake() {
        return pancake;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    // Structure
    public void setSharedAssets(SharedAssets sharedAssets) {
        this.sharedAssets = sharedAssets;
    }

    public void setAssets(MainAssets assets) {
        this.assets = assets;
    }
}