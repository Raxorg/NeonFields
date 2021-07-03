package com.epicness.neonfields.main;

public class MainEnums {

    public enum PaddleState {
        MOVING_UP, IDLE, MOVING_DOWN
    }

    public enum Controller {
        PLAYER, AI
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

    public enum ElementID {
        PLAY_BUTTON, CREDITS_BUTTON
    }
}