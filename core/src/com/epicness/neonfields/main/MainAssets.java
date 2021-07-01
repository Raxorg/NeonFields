package com.epicness.neonfields.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

public class MainAssets extends Assets {

    // Sprites
    private Sprite pixel;
    private Sprite paddle, paddleGlow;
    private Sprite circle, circleGlow, triangle, triangleGlow, square, squareGlow, romb, rombGlow;
    private Sprite dot, dotGlow;
    private Sprite personIdle, personRun1, personRun2, personGlow;
    private Sprite heart, heartGlow;
    private Sprite pancake;
    // Fonts
    private BitmapFont pixelFont4, pixelFont20;

    @Override
    public void queueAssetLoading() {
        // Sprites
        assetManager.load("images/pixel.png", Texture.class);

        assetManager.load("images/main/paddle.png", Texture.class);
        assetManager.load("images/main/paddleGlow.png", Texture.class);

        assetManager.load("images/main/figuresWithGlow2.png", Texture.class);

        assetManager.load("images/main/dot.png", Texture.class);
        assetManager.load("images/main/dotGlow.png", Texture.class);

        assetManager.load("images/main/personIdle.png", Texture.class);
        assetManager.load("images/main/personRun1.png", Texture.class);
        assetManager.load("images/main/personRun2.png", Texture.class);
        assetManager.load("images/main/personGlow.png", Texture.class);

        assetManager.load("images/main/heart.png", Texture.class);
        assetManager.load("images/main/heartGlow.png", Texture.class);

        assetManager.load("images/main/thoughtfulPancake.png", Texture.class);
        // Fonts
        assetManager.load("fonts/pixelFont4.fnt", BitmapFont.class);
        assetManager.load("fonts/pixelFont20.fnt", BitmapFont.class);
    }

    @Override
    public boolean loadAssets() {
        return assetManager.update();
    }

    @Override
    public void initializeAssets() {
        // Sprites
        pixel = new Sprite(assetManager.get("images/pixel.png", Texture.class));

        paddle = new Sprite(assetManager.get("images/main/paddle.png", Texture.class));
        paddleGlow = new Sprite(assetManager.get("images/main/paddleGlow.png", Texture.class));

        Texture shapes = assetManager.get("images/main/figuresWithGlow2.png", Texture.class);
        shapes.setFilter(Linear, Linear);
        circle = new Sprite(shapes, 0, 0, 100, 100);
        circleGlow = new Sprite(shapes, 101, 0, 300, 300);
        triangle = new Sprite(shapes, 401, 0, 100, 100);
        triangleGlow = new Sprite(shapes, 502, 0, 300, 300);
        square = new Sprite(shapes, 0, 300, 100, 100);
        squareGlow = new Sprite(shapes, 101, 300, 300, 300);
        romb = new Sprite(shapes, 401, 300, 100, 100);
        rombGlow = new Sprite(shapes, 502, 300, 300, 300);

        dot = new Sprite(assetManager.get("images/main/dot.png", Texture.class));
        dotGlow = new Sprite(assetManager.get("images/main/dotGlow.png", Texture.class));

        personIdle = new Sprite(assetManager.get("images/main/personIdle.png", Texture.class));
        personRun1 = new Sprite(assetManager.get("images/main/personRun1.png", Texture.class));
        personRun2 = new Sprite(assetManager.get("images/main/personRun2.png", Texture.class));
        personGlow = new Sprite(assetManager.get("images/main/personGlow.png", Texture.class));

        heart = new Sprite(assetManager.get("images/main/heart.png", Texture.class));
        heartGlow = new Sprite(assetManager.get("images/main/heartGlow.png", Texture.class));

        pancake = new Sprite(assetManager.get("images/main/thoughtfulPancake.png", Texture.class));
        // Fonts
        pixelFont4 = assetManager.get("fonts/pixelFont4.fnt", BitmapFont.class);
        pixelFont4.getData().setScale(4f);
        pixelFont20 = assetManager.get("fonts/pixelFont20.fnt", BitmapFont.class);
        pixelFont20.getData().setScale(20f);
    }

    // Sprites
    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getPaddle() {
        return paddle;
    }

    public Sprite getPaddleGlow() {
        return paddleGlow;
    }

    public Sprite getCircle() {
        return circle;
    }

    public Sprite getCircleGlow() {
        return circleGlow;
    }

    public Sprite getTriangle() {
        return triangle;
    }

    public Sprite getTriangleGlow() {
        return triangleGlow;
    }

    public Sprite getSquare() {
        return square;
    }

    public Sprite getSquareGlow() {
        return squareGlow;
    }

    public Sprite getRomb() {
        return romb;
    }

    public Sprite getRombGlow() {
        return rombGlow;
    }

    public Sprite getDot() {
        return dot;
    }

    public Sprite getDotGlow() {
        return dotGlow;
    }

    public Sprite getPersonIdle() {
        return personIdle;
    }

    public Sprite getPersonRun1() {
        return personRun1;
    }

    public Sprite getPersonRun2() {
        return personRun2;
    }

    public Sprite getPersonGlow() {
        return personGlow;
    }

    public Sprite getHeart() {
        return heart;
    }

    public Sprite getHeartGlow() {
        return heartGlow;
    }

    public Sprite getPancake() {
        return pancake;
    }

    // Fonts
    public BitmapFont getPixelFont4() {
        return pixelFont4;
    }

    public BitmapFont getPixelFont20() {
        return pixelFont20;
    }
}