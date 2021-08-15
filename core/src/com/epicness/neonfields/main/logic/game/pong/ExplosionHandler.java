package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.logic.game.PongGameHandler;
import com.epicness.neonfields.main.stuff.pong.Ball;
import com.epicness.neonfields.main.stuff.pong.Paddle;
import com.epicness.neonfields.main.stuff.pong.Person;
import com.epicness.neonfields.main.stuff.pong.shapes.Shape;

import static com.epicness.neonfields.main.MainConstants.BALL_EXPLOSION_PROJECTILES;
import static com.epicness.neonfields.main.MainConstants.PADDLE_EXPLOSION_PROJECTILES;
import static com.epicness.neonfields.main.MainConstants.PADDLE_HEIGHT;
import static com.epicness.neonfields.main.MainConstants.PADDLE_WIDTH;
import static com.epicness.neonfields.main.MainConstants.PERSON_EXPLOSION_PROJECTILES;
import static com.epicness.neonfields.main.MainConstants.PERSON_HEIGHT;
import static com.epicness.neonfields.main.MainConstants.PERSON_WIDTH;
import static com.epicness.neonfields.main.MainConstants.SHAPE_SIZE;

public class ExplosionHandler {

    private MainLogic logic;

    public void explodeShape(Shape shape, DelayedRemovalArray<Shape> shapes) {
        float x, y;
        float[] explosionAngles = shape.getExplosionAngles();
        Vector2[] projectileSpawnCoefficients = shape.getProjectileSpawnCoefficients();
        PongGameHandler pongGameHandler = logic.getPongGameHandler();
        for (int i = 0; i < explosionAngles.length; i++) {
            x = shape.getX() + SHAPE_SIZE * projectileSpawnCoefficients[i].x;
            y = shape.getY() + SHAPE_SIZE * projectileSpawnCoefficients[i].y;
            pongGameHandler.getProjectileHandler().spawnProjectile(x, y, explosionAngles[i], shape.getColor());
        }
        shapes.removeValue(shape, true);
    }

    public void explodeBall(Ball ball, DelayedRemovalArray<Ball> balls) {
        PongGameHandler pongGameHandler = logic.getPongGameHandler();
        for (int i = 0; i < BALL_EXPLOSION_PROJECTILES; i++) {
            pongGameHandler.getProjectileHandler().spawnProjectile(
                    ball.getCenterX(),
                    ball.getCenterY(),
                    (360f / BALL_EXPLOSION_PROJECTILES) * i,
                    ball.getColor());
        }
        balls.removeValue(ball, true);
        pongGameHandler.getGameSpeedHandler().resetSpeed();
    }

    public void explodePaddle(Paddle paddle) {
        PongGameHandler pongGameHandler = logic.getPongGameHandler();
        for (int i = 0; i < PADDLE_EXPLOSION_PROJECTILES; i++) {
            pongGameHandler.getProjectileHandler().spawnProjectile(
                    paddle.getX() + PADDLE_WIDTH / 2f,
                    paddle.getY() + PADDLE_HEIGHT / 2f,
                    (360f / PADDLE_EXPLOSION_PROJECTILES) * i,
                    paddle.getColor());
        }
        pongGameHandler.getGameSpeedHandler().resetSpeed();
    }

    public void explodePerson(Person person) {
        PongGameHandler pongGameHandler = logic.getPongGameHandler();
        for (int i = 0; i < PERSON_EXPLOSION_PROJECTILES; i++) {
            pongGameHandler.getProjectileHandler().spawnProjectile(
                    person.getX() + PERSON_WIDTH / 2f,
                    person.getY() + PERSON_HEIGHT / 2f,
                    (360f / PERSON_EXPLOSION_PROJECTILES) * i,
                    person.getColor());
        }
        pongGameHandler.getGameSpeedHandler().resetSpeed();
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }
}