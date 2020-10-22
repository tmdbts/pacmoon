package org.academiadecodigo.tailormoons.pctest.gameelements;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.Direction;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.Position;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.PositionManager;

public class PacMan extends GameElement {

    private Direction direction = Direction.UP;
    private Direction lastDirection = direction;
    private PositionManager positionManager;
    private boolean dead;
    private Picture pacManSymbol;
    private int livesLeft = 3;
    private Position initialPosition = new Position(7, 9);


    public PacMan() {

        position = new Position(7, 9);
        setup();
    }

    public void setPositionManager(PositionManager positionManager) {
        this.positionManager = positionManager;
    }

    public void move() {

        if (positionManager.isMovePossible(position, direction, this)) {
            lastDirection = direction;
            switch (direction) {
                case LEFT:
                    position.setPosition(position.getCol() - 1, position.getRow());
                    pacManSymbol.translate(-gridCellSize, 0);
                    break;
                case RIGHT:
                    position.setPosition(position.getCol() + 1, position.getRow());
                    pacManSymbol.translate(gridCellSize, 0);
                    break;
                case UP:
                    position.setPosition(position.getCol(), position.getRow() - 1);
                    pacManSymbol.translate(0, -gridCellSize);
                    break;
                case DOWN:
                    position.setPosition(position.getCol(), position.getRow() + 1);
                    pacManSymbol.translate(0, gridCellSize);
                    break;
            }
        } else {
            direction = lastDirection;
        }
    }

    private void setup() {

        Keyboard keyboard1 = new Keyboard(new KeyboardListener(this));

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard1.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard1.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard1.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard1.addEventListener(down);

        pacManSymbol = new Picture(gridPadding + getPosition().getCol() * gridCellSize, gridPadding + getPosition().getRow() * gridCellSize, "assets/tailormoon.png");
        pacManSymbol.draw();
    }

    public Position getPosition() {
        return position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isDead() {
        return dead;
    }

    public int getLivesLeft() {
        
        System.out.println("LIVES LEFT");
        return livesLeft;
    }

    public void takeLife() {

        livesLeft--;
        if (livesLeft == 0) {
            dead = true;
            return;
        }

        pacManSymbol.delete();

        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        position.setPosition(initialPosition.getCol(), initialPosition.getRow());
        pacManSymbol = new Picture(gridPadding + getPosition().getCol() * gridCellSize, gridPadding + getPosition().getRow() * gridCellSize, "assets/tailormoon.png");
        pacManSymbol.draw();
    }

    private class KeyboardListener implements KeyboardHandler {

        private PacMan pacman;

        public KeyboardListener(PacMan pacman) {
            this.pacman = pacman;
        }

        @Override
        public void keyPressed(KeyboardEvent event) {

            switch (event.getKey()) {
                case KeyboardEvent.KEY_LEFT:
                    pacman.setDirection(Direction.LEFT);
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    pacman.setDirection(Direction.RIGHT);
                    break;
                case KeyboardEvent.KEY_UP:
                    pacman.setDirection(Direction.UP);
                    break;
                case KeyboardEvent.KEY_DOWN:
                    pacman.setDirection(Direction.DOWN);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }

    }


}
