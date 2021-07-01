package com.epicness.neonfields.main;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.neonfields.main.stuff.MainStuff;

public class MainRenderer extends Renderer {

    private SharedScreen screen;
    private MainStuff stuff;

    @Override
    public void render() {
        // Clear previous frame
        ScreenUtils.clear(0, 0, 0, 1);
        // Use the camera
        spriteBatch.setProjectionMatrix(screen.getDynamicCamera().combined);
        // Render the stuff
        spriteBatch.begin();
        stuff.getGrid().draw(spriteBatch);
        for (int i = 0; i < stuff.getBorders().length; i++) {
            stuff.getBorders()[i].draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getShapes().size; i++) {
            stuff.getShapes().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getProjectiles().size; i++) {
            stuff.getProjectiles().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getBalls().size; i++) {
            stuff.getBalls().get(i).draw(spriteBatch);
        }
        stuff.getPerson().draw(spriteBatch);
        stuff.getPaddle1().draw(spriteBatch);
        stuff.getPaddle2().draw(spriteBatch);
        stuff.getDarkener().draw(spriteBatch);
        stuff.getBallTimer().draw(spriteBatch);
        for (int i = 0; i < stuff.getPaddle1Lives().size; i++) {
            stuff.getPaddle1Lives().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getPaddle2Lives().size; i++) {
            stuff.getPaddle2Lives().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getPersonLives().size; i++) {
            stuff.getPersonLives().get(i).draw(spriteBatch);
        }
        stuff.getPancake().draw(spriteBatch);
        stuff.getGameOverText().draw(spriteBatch);
        stuff.getStartScreenText().draw(spriteBatch);
        //stuff.getTest().draw(spriteBatch); EXAMPLE OF TEXT BUTTON
        spriteBatch.end();
    }

    public void setScreen(SharedScreen screen) {
        this.screen = screen;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}