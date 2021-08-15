package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.utils.Random;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.pong.shapes.Circle;
import com.epicness.neonfields.main.stuff.pong.shapes.Romb;
import com.epicness.neonfields.main.stuff.pong.shapes.Shape;
import com.epicness.neonfields.main.stuff.pong.shapes.Square;
import com.epicness.neonfields.main.stuff.pong.shapes.Triangle;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.neonfields.main.MainConstants.SHAPE_GENERATION_INTERVAL;
import static com.epicness.neonfields.main.MainConstants.SHAPE_SIZE;
import static com.epicness.neonfields.main.MainConstants.SHAPE_ZONE_MARGIN;

public class ShapeGenerator {

    // Structure
    private MainAssets assets;
    private MainStuff stuff;
    // Logic
    private float time;

    public void update(float delta) {
        time += delta;
        if (time >= SHAPE_GENERATION_INTERVAL) {
            time -= SHAPE_GENERATION_INTERVAL;
            generate();
        }
    }

    private void generate() {
        Shape shape = makeRandomShape();
        float randomX = MathUtils.random(SHAPE_ZONE_MARGIN, CAMERA_WIDTH - SHAPE_SIZE - SHAPE_ZONE_MARGIN);
        float randomY = MathUtils.random(SHAPE_ZONE_MARGIN, CAMERA_HEIGHT - SHAPE_SIZE - SHAPE_ZONE_MARGIN);
        shape.setPosition(randomX, randomY);
        shape.setColor(Random.randomColor());
        stuff.getPongGame().getShapes().add(shape);
    }

    private Shape makeRandomShape() {
        int random = MathUtils.random(3);
        switch (random) {
            case 0:
                return new Circle(assets.getCircle(), assets.getCircleGlow());
            case 1:
                return new Triangle(assets.getTriangle(), assets.getTriangleGlow());
            case 2:
                return new Square(assets.getSquare(), assets.getSquareGlow());
            case 3:
            default:
                return new Romb(assets.getRomb(), assets.getRombGlow());
        }
    }

    // Structure
    public void setAssets(MainAssets assets) {
        this.assets = assets;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}