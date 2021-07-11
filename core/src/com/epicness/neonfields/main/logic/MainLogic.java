package com.epicness.neonfields.main.logic;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.logic.game.BallHandler;
import com.epicness.neonfields.main.logic.game.BallTimerHandler;
import com.epicness.neonfields.main.logic.game.ColorAssigner;
import com.epicness.neonfields.main.logic.game.DamageHandler;
import com.epicness.neonfields.main.logic.game.ExplosionHandler;
import com.epicness.neonfields.main.logic.game.GameSpeedHandler;
import com.epicness.neonfields.main.logic.game.GridColorHandler;
import com.epicness.neonfields.main.logic.game.PaddleHandler;
import com.epicness.neonfields.main.logic.game.PersonHandler;
import com.epicness.neonfields.main.logic.game.PlatformHandler;
import com.epicness.neonfields.main.logic.game.ProjectileHandler;
import com.epicness.neonfields.main.logic.game.ShapeGenerator;
import com.epicness.neonfields.main.logic.menus.ButtonHandler;
import com.epicness.neonfields.main.logic.menus.MenuHandler;
import com.epicness.neonfields.main.stuff.MainStuff;

import static com.epicness.neonfields.main.MainEnums.MenuID.MAIN_MENU;

public class MainLogic extends Logic {

    // Helpers
    private final BallHandler ballHandler;
    private final BallTimerHandler ballTimerHandler;
    private final ColorAssigner colorAssigner;
    private final DamageHandler damageHandler;
    private final ExplosionHandler explosionHandler;
    private final GameOverHandler gameOverHandler;
    private final GameSpeedHandler gameSpeedHandler;
    private final MainInputHandler mainInputHandler;
    private final GridColorHandler gridColorHandler;
    private final PaddleHandler paddleHandler;
    private final PersonHandler personHandler;
    private final PlatformHandler platformHandler;
    private final ProjectileHandler projectileHandler;
    private final ShapeGenerator shapeGenerator;
    private final StartScreenHandler startScreenHandler;
    // Menus
    private final ButtonHandler buttonHandler;
    private final MenuHandler menuHandler;

    public MainLogic() {
        // Game
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
        projectileHandler = new ProjectileHandler();
        shapeGenerator = new ShapeGenerator();
        // Menus
        buttonHandler = new ButtonHandler();
        menuHandler = new MenuHandler();

        gameOverHandler = new GameOverHandler();
        mainInputHandler = new MainInputHandler();
        startScreenHandler = new StartScreenHandler();

        ballHandler.setLogic(this);
        ballTimerHandler.setLogic(this);
        damageHandler.setLogic(this);
        gameSpeedHandler.setLogic(this);
        explosionHandler.setLogic(this);
        projectileHandler.setLogic(this);
        // Menus
        buttonHandler.setLogic(this);

        gameOverHandler.setLogic(this);
        mainInputHandler.setLogic(this);
        startScreenHandler.setLogic(this);
    }

    public void initialLogic() {
        ballHandler.spawnBall();
        platformHandler.spawnInitialPlatforms();

        buttonHandler.setupBehaviors();
        menuHandler.showMenu(MAIN_MENU);

        mainInputHandler.setupInput();
    }

    @Override
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
        startScreenHandler.setAssets(assets);
    }

    public void setInput(SharedInput input) {
        mainInputHandler.setInput(input);
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
        startScreenHandler.setStuff(stuff);
        // Menus
        buttonHandler.setStuff(stuff);
        menuHandler.setStuff(stuff);
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.gameOverHandler.setSharedLogic(sharedLogic);
    }

    // Helpers
    public BallHandler getBallHandler() {
        return ballHandler;
    }

    public BallTimerHandler getBallTimerHandler() {
        return ballTimerHandler;
    }

    public ButtonHandler getButtonHandler() {
        return buttonHandler;
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

    public ProjectileHandler getProjectileHandler() {
        return projectileHandler;
    }

    public StartScreenHandler getStartScreenHandler() {
        return startScreenHandler;
    }

    // Menus
    public MenuHandler getMenuHandler() {
        return menuHandler;
    }
}