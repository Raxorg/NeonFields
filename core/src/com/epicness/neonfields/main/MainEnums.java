package com.epicness.neonfields.main;

public class MainEnums {

    public enum MenuID {
        MAIN_MENU, CREDITS
    }

    public enum PaddleState {
        MOVING_UP, IDLE, MOVING_DOWN
    }

    public enum PersonState {
        IDLE, RUNNING, JUMPING
    }

    public enum GameMode {
        STANDARD, QUAD_BATTLE
    }

    public enum PlayerID {
        PADDLE1, PADDLE2, PERSON
    }
}