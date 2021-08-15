package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.pong.Ball;
import com.epicness.neonfields.main.stuff.pong.Life;
import com.epicness.neonfields.main.stuff.pong.Paddle;
import com.epicness.neonfields.main.stuff.pong.PongGame;

import static com.epicness.neonfields.main.MainConstants.MAX_PADDLE_Y;
import static com.epicness.neonfields.main.MainConstants.MIN_PADDLE_Y;
import static com.epicness.neonfields.main.MainConstants.PADDLE_AI_SPEED;
import static com.epicness.neonfields.main.MainConstants.PADDLE_SPEED;
import static com.epicness.neonfields.main.MainEnums.PaddleState.IDLE;
import static com.epicness.neonfields.main.MainEnums.PaddleState.MOVING_DOWN;
import static com.epicness.neonfields.main.MainEnums.PaddleState.MOVING_UP;

public class PaddleHandler {

    private MainStuff stuff;

    public void paddleUpPress(boolean paddle1) {
        PongGame pongGame = stuff.getPongGame();
        Paddle paddle = paddle1 ? pongGame.getPaddle1() : pongGame.getPaddle2();
        DelayedRemovalArray<Life> lives = paddle1 ? pongGame.getPaddle1Lives() : pongGame.getPaddle2Lives();
        if (lives.size <= 0) {
            return;
        }
        switch (paddle.getState()) {
            case IDLE:
                paddle.setState(MOVING_UP);
                break;
            case MOVING_DOWN:
                paddle.setState(IDLE);
                break;
        }
    }

    public void paddleDownPress(boolean paddle1) {
        PongGame pongGame = stuff.getPongGame();
        Paddle paddle = paddle1 ? pongGame.getPaddle1() : pongGame.getPaddle2();
        DelayedRemovalArray<Life> lives = paddle1 ? pongGame.getPaddle1Lives() : pongGame.getPaddle2Lives();
        if (lives.size <= 0) {
            return;
        }
        switch (paddle.getState()) {
            case MOVING_UP:
                paddle.setState(IDLE);
                break;
            case IDLE:
                paddle.setState(MOVING_DOWN);
                break;
        }
    }

    public void paddleUpRelease(boolean paddle1) {
        PongGame pongGame = stuff.getPongGame();
        Paddle paddle = paddle1 ? pongGame.getPaddle1() : pongGame.getPaddle2();
        DelayedRemovalArray<Life> lives = paddle1 ? pongGame.getPaddle1Lives() : pongGame.getPaddle2Lives();
        if (lives.size <= 0) {
            return;
        }
        switch (paddle.getState()) {
            case MOVING_UP:
                paddle.setState(IDLE);
                break;
            case IDLE:
                paddle.setState(MOVING_DOWN);
                break;
        }
    }

    public void paddleDownRelease(boolean paddle1) {
        PongGame pongGame = stuff.getPongGame();
        Paddle paddle = paddle1 ? pongGame.getPaddle1() : pongGame.getPaddle2();
        DelayedRemovalArray<Life> lives = paddle1 ? pongGame.getPaddle1Lives() : pongGame.getPaddle2Lives();
        if (lives.size <= 0) {
            return;
        }
        switch (paddle.getState()) {
            case IDLE:
                paddle.setState(MOVING_UP);
                break;
            case MOVING_DOWN:
                paddle.setState(IDLE);
                break;
        }
    }

    public void update(float delta) {
        PongGame pongGame = stuff.getPongGame();
        Paddle paddle = pongGame.getPaddle1();
        if (paddle.isControlledByAI()) {
            solvePaddleAI(paddle, delta);
        } else {
            movePaddle(paddle, delta);
        }
        checkPaddleBounds(paddle);

        paddle = pongGame.getPaddle2();
        if (paddle.isControlledByAI()) {
            solvePaddleAI(paddle, delta);
        } else {
            movePaddle(paddle, delta);
        }
        checkPaddleBounds(paddle);
    }

    private void movePaddle(Paddle paddle, float delta) {
        switch (paddle.getState()) {
            case MOVING_UP:
                paddle.translateY(PADDLE_SPEED * delta);
                break;
            case MOVING_DOWN:
                paddle.translateY(-PADDLE_SPEED * delta);
                break;
        }
    }

    private void checkPaddleBounds(Paddle paddle) {
        float paddleY = paddle.getY();
        if (paddleY < MIN_PADDLE_Y) {
            paddle.setY(MIN_PADDLE_Y);
        }
        if (paddleY > MAX_PADDLE_Y) {
            paddle.setY(MAX_PADDLE_Y);
        }
    }

    private void solvePaddleAI(Paddle paddle, float delta) {
        PongGame pongGame = stuff.getPongGame();
        DelayedRemovalArray<Ball> balls = pongGame.getBalls();
        if (balls.size == 0f) {
            return;
        }
        Ball closestBall = calculateClosestBall(paddle, balls);
        // Based on the ball position relative to the paddle, move the paddle in either direction to deflect
        float ballCenterY = closestBall.getCenterY();
        float yDistance = ballCenterY - paddle.getCenterY();

        // Translate the paddle
        if (yDistance > 0) {
            //paddle.setState(MOVING_UP);
            paddle.translateY(yDistance * PADDLE_AI_SPEED * delta);
        } else if (yDistance < 0) {
            //paddle.setState(MOVING_DOWN);
            paddle.translateY(yDistance * PADDLE_AI_SPEED * delta);
        } else {
            paddle.setState(IDLE);
        }
    }

    private Ball calculateClosestBall(Paddle paddle, DelayedRemovalArray<Ball> balls) {
        float x = paddle.getX();
        Ball closest = balls.get(0);        // initial ball ref
        float d = Float.MAX_VALUE;          // initial max distance
        float centerX;                      // reusable center vector2
        for (Ball ball : balls) {
            centerX = ball.getCenterX();    // calculate the center position
            float dist = Math.abs(centerX - x);
            if (dist < d) {                 // if this ball is closer, this is the new closest ball
                closest = ball;
                d = dist;
            }
        }
        return closest;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}