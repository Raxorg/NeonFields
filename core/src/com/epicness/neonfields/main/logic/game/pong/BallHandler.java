package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.utils.AngleUtils;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.logic.game.PongGameHandler;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.pong.Ball;
import com.epicness.neonfields.main.stuff.pong.Paddle;
import com.epicness.neonfields.main.stuff.pong.Person;
import com.epicness.neonfields.main.stuff.pong.shapes.Shape;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.neonfields.main.MainConstants.BALL_SIZE;
import static com.epicness.neonfields.main.MainConstants.BALL_STARTING_SPEED;
import static com.epicness.neonfields.main.MainConstants.MAX_BALL_Y;
import static com.epicness.neonfields.main.MainConstants.MIN_BALL_Y;
import static com.epicness.neonfields.main.MainConstants.PADDLE_WIDTH;
import static com.epicness.neonfields.main.MainEnums.PaddleState.MOVING_DOWN;
import static com.epicness.neonfields.main.MainEnums.PaddleState.MOVING_UP;
import static com.epicness.neonfields.main.MainEnums.PlayerID.PADDLE1;
import static com.epicness.neonfields.main.MainEnums.PlayerID.PADDLE2;
import static com.epicness.neonfields.main.MainEnums.PlayerID.PERSON;

public class BallHandler {

    // Structure
    private MainAssets assets;
    private MainLogic logic;
    private MainStuff stuff;
    // Logic
    private float ballSpeed;

    public BallHandler() {
        ballSpeed = BALL_STARTING_SPEED;
    }

    public void spawnBall() {
        Ball ball = new Ball(assets.getDot(), assets.getDotGlow());
        ball.setPosition(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f);
        float angle = MathUtils.random(360f);
        if (Math.abs(angle - 180) > 65 && Math.abs(angle - 180) < 115) {
            angle = 45 * angle / Math.abs(angle);
        }
        ball.setMovementAngle(angle);
        stuff.getPongGame().getBalls().add(ball);
    }

    public void update(float delta) {
        DelayedRemovalArray<Ball> balls = stuff.getPongGame().getBalls();
        Person person = stuff.getPongGame().getPerson();
        balls.begin();
        for (int i = 0; i < balls.size; i++) {
            Ball ball = balls.get(i);
            moveBall(ball, delta);
            checkBallPosition(ball, balls);
            checkShapeCollision(ball);
            checkPaddleCollision(ball);
            checkPersonCollision(ball, person, balls);
        }
        balls.end();
    }

    private void moveBall(Ball ball, float delta) {
        Vector2 movementVector = new Vector2(1f, 1f).setAngleDeg(ball.getMovementAngle());
        movementVector.x = movementVector.x * ballSpeed;
        movementVector.y = movementVector.y * ballSpeed;
        ball.setPosition(ball.getCenterX() + movementVector.x * delta, ball.getCenterY() + movementVector.y * delta);
    }

    private void checkBallPosition(Ball ball, DelayedRemovalArray<Ball> balls) {
        PongGameHandler pongGameHandler = logic.getPongGameHandler();
        if (ball.getX() < 0f) {
            pongGameHandler.getExplosionHandler().explodeBall(ball, balls);
            pongGameHandler.getDamageHandler().removeLife(PADDLE1);
        } else if (ball.getX() + BALL_SIZE > CAMERA_WIDTH) {
            pongGameHandler.getExplosionHandler().explodeBall(ball, balls);
            pongGameHandler.getDamageHandler().removeLife(PADDLE2);
        }
        if (ball.getY() < MIN_BALL_Y) {
            ball.setY(MIN_BALL_Y);
            ball.setMovementAngle(360 - ball.getMovementAngle());
        } else if (ball.getY() > MAX_BALL_Y) {
            ball.setY(MAX_BALL_Y);
            ball.setMovementAngle(360 - ball.getMovementAngle());
        }
    }

    private void checkShapeCollision(Ball ball) {
        DelayedRemovalArray<Shape> shapes = stuff.getPongGame().getShapes();
        shapes.begin();
        for (int i = 0; i < shapes.size; i++) {
            Shape shape = shapes.get(i);
            if (ball.getBounds().overlaps(shape.getBounds())) {
                logic.getPongGameHandler().getExplosionHandler().explodeShape(shape, shapes);
                ball.setColor(shape.getColor());
                break;
            }
        }
        shapes.end();
    }

    private void checkPaddleCollision(Ball ball) {
        Paddle paddle = stuff.getPongGame().getPaddle1();
        if (ball.getBounds().overlaps(paddle.getBounds())) {
            ball.setX(paddle.getBounds().x + PADDLE_WIDTH);
            float angle = AngleUtils.normalize(180f - ball.getMovementAngle());
            if (paddle.getState() == MOVING_UP) {
                if (angle >= 270f) {
                    angle += 25f;
                } else if (angle <= 90f) {
                    angle = Math.min(angle + 25f, 65f);
                }
            } else if (paddle.getState() == MOVING_DOWN) {
                if (angle <= 90f) {
                    angle -= 25;
                } else if (angle >= 270) {
                    angle = Math.max(angle - 25, 295);
                }
            }
            ball.setMovementAngle(angle);
            ball.setColor(paddle.getColor());
            logic.getPongGameHandler().getBallTimerHandler().resetTimer();
        }
        paddle = stuff.getPongGame().getPaddle2();
        if (ball.getBounds().overlaps(paddle.getBounds())) {
            ball.setX(paddle.getBounds().x - BALL_SIZE);
            float angle = AngleUtils.normalize(180 - ball.getMovementAngle());
            if (paddle.getState() == MOVING_UP) {
                if (angle >= 180f) {
                    angle -= 25f;
                } else if (angle < 180f) {
                    angle = Math.max(angle - 25f, 115f);
                }
            } else if (paddle.getState() == MOVING_DOWN) {
                if (angle <= 180f) {
                    angle += 25;
                } else if (angle > 180) {
                    angle = Math.min(angle + 25, 245);
                }
            }
            ball.setMovementAngle(angle);
            ball.setColor(paddle.getColor());
            logic.getPongGameHandler().getBallTimerHandler().resetTimer();
        }
    }

    private void checkPersonCollision(Ball ball, Person person, DelayedRemovalArray<Ball> balls) {
        PongGameHandler pongGameHandler = logic.getPongGameHandler();
        if (ball.getBounds().overlaps(person.getBounds())) {
            pongGameHandler.getExplosionHandler().explodePerson(person);
            pongGameHandler.getDamageHandler().removeLife(PERSON);
            pongGameHandler.getExplosionHandler().explodeBall(ball, balls);
        }
    }

    public void setBallSpeed(float ballSpeed) {
        this.ballSpeed = ballSpeed;
    }

    // Structure
    public void setAssets(MainAssets assets) {
        this.assets = assets;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}