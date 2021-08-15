package com.epicness.neonfields.main.logic.game;

import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.logic.GameOverHandler;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.logic.game.pong.BallHandler;
import com.epicness.neonfields.main.logic.game.pong.BallTimerHandler;
import com.epicness.neonfields.main.logic.game.pong.ColorAssigner;
import com.epicness.neonfields.main.logic.game.pong.DamageHandler;
import com.epicness.neonfields.main.logic.game.pong.ExplosionHandler;
import com.epicness.neonfields.main.logic.game.pong.GameSpeedHandler;
import com.epicness.neonfields.main.logic.game.pong.GridColorHandler;
import com.epicness.neonfields.main.logic.game.pong.PaddleHandler;
import com.epicness.neonfields.main.logic.game.pong.PersonHandler;
import com.epicness.neonfields.main.logic.game.pong.PlatformHandler;
import com.epicness.neonfields.main.logic.game.pong.PongInputHandler;
import com.epicness.neonfields.main.logic.game.pong.ProjectileHandler;
import com.epicness.neonfields.main.logic.game.pong.ShapeGenerator;
import com.epicness.neonfields.main.stuff.MainStuff;

public class PongGameHandler {

    private final BallHandler ballHandler;
    private final BallTimerHandler ballTimerHandler;
    private final ColorAssigner colorAssigner;
    private final DamageHandler damageHandler;
    private final ExplosionHandler explosionHandler;
    private final GameOverHandler gameOverHandler;
    private final GameSpeedHandler gameSpeedHandler;
    private final GridColorHandler gridColorHandler;
    private final PaddleHandler paddleHandler;
    private final PersonHandler personHandler;
    private final PlatformHandler platformHandler;
    private final PongInputHandler pongInputHandler;
    private final ProjectileHandler projectileHandler;
    private final ShapeGenerator shapeGenerator;

    public PongGameHandler() {
        ballHandler = new BallHandler();
        ballTimerHandler = new BallTimerHandler();
        colorAssigner = new ColorAssigner();
        damageHandler = new DamageHandler();
        explosionHandler = new ExplosionHandler();
        gameSpeedHandler = new GameSpeedHandler();
        gridColorHandler = new GridColorHandler();
        paddleHandler = new PaddleHandler();
        personHandler = new PersonHandler();
        platformHandler = new PlatformHandler();
        pongInputHandler = new PongInputHandler();
        projectileHandler = new ProjectileHandler();
        shapeGenerator = new ShapeGenerator();
        gameOverHandler = new GameOverHandler();
    }

    public void initialLogic() {
        ballHandler.spawnBall();
        platformHandler.spawnInitialPlatforms();
    }

    public void update(float delta) {
        ballHandler.update(delta);
        ballTimerHandler.update(delta);
        gameOverHandler.update(delta);
        gameSpeedHandler.update(delta);
        gridColorHandler.update(delta);
        paddleHandler.update(delta);
        personHandler.update(delta);
        platformHandler.update();
        projectileHandler.update(delta);
        shapeGenerator.update(delta);
    }

    public void setAssets(MainAssets assets) {
        ballHandler.setAssets(assets);
        projectileHandler.setAssets(assets);
        shapeGenerator.setAssets(assets);
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        gameOverHandler.setSharedLogic(sharedLogic);
    }

    public void setLogic(MainLogic logic) {
        ballHandler.setLogic(logic);
        ballTimerHandler.setLogic(logic);
        damageHandler.setLogic(logic);
        gameSpeedHandler.setLogic(logic);
        explosionHandler.setLogic(logic);
        pongInputHandler.setLogic(logic);
        projectileHandler.setLogic(logic);
        gameOverHandler.setLogic(logic);
    }

    public void setStuff(MainStuff stuff) {
        ballHandler.setStuff(stuff);
        ballTimerHandler.setStuff(stuff);
        colorAssigner.setStuff(stuff);
        damageHandler.setStuff(stuff);
        gameOverHandler.setStuff(stuff);
        gridColorHandler.setStuff(stuff);
        paddleHandler.setStuff(stuff);
        personHandler.setStuff(stuff);
        platformHandler.setStuff(stuff);
        projectileHandler.setStuff(stuff);
        shapeGenerator.setStuff(stuff);
    }

    public BallHandler getBallHandler() {
        return ballHandler;
    }

    public BallTimerHandler getBallTimerHandler() {
        return ballTimerHandler;
    }

    public ColorAssigner getColorAssigner() {
        return colorAssigner;
    }

    public DamageHandler getDamageHandler() {
        return damageHandler;
    }

    public ExplosionHandler getExplosionHandler() {
        return explosionHandler;
    }

    public GameOverHandler getGameOverHandler() {
        return gameOverHandler;
    }

    public GameSpeedHandler getGameSpeedHandler() {
        return gameSpeedHandler;
    }

    public PaddleHandler getPaddleHandler() {
        return paddleHandler;
    }

    public PersonHandler getPersonHandler() {
        return personHandler;
    }

    public PongInputHandler getPongInputHandler() {
        return pongInputHandler;
    }

    public ProjectileHandler getProjectileHandler() {
        return projectileHandler;
    }
}