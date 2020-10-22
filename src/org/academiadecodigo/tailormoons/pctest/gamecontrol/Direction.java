package org.academiadecodigo.tailormoons.pctest.gamecontrol;

public enum Direction {
    RIGHT,
    LEFT,
    UP,
    DOWN;

    public Direction opposite() {

        switch (this) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case RIGHT:
                return LEFT;
            case LEFT:
                return RIGHT;
        }

        return null;
    }
}
