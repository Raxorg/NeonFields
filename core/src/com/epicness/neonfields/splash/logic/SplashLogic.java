package com.epicness.neonfields.splash.logic;

import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.neonfields.splash.SplashStuff;

public class SplashLogic extends Logic {

    private final SplashHandler splashHandler;

    public SplashLogic() {
        splashHandler = new SplashHandler();
    }

    public void initialLogic() {
        splashHandler.initialize();
    }

    @Override
    public void update(float delta) {
        splashHandler.update(delta);
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        splashHandler.setSharedLogic(sharedLogic);
    }

    public void setStuff(SplashStuff splashStuff) {
        splashHandler.setStuff(splashStuff);
    }
}