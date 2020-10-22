package org.academiadecodigo.tailormoons.pctest.gameelements.pointables;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.Direction;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.Position;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.PositionManager;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Ghost extends Pointable {

    private static boolean fragile;
    private final double CHANGE_DIRECTION_ODD = 0.10;
    private boolean notInitialMove;
    private int randomMoveSelector = (int) (Math.random() * 2);
    private String normal;
    private String vulnerable;
    private boolean changeDirectionNeeded;

    private Direction direction = Direction.UP;
    private Direction lastDirection = direction;
    private PositionManager positionManager;
    private Position initialChasePosition1 = new Position(3, 4);
    private Position initialChasePosition2 = new Position(11, 4);
    private Position ghostHouse = new Position(7, 6);
    private Picture ghostSymbol;
    private Direction changeDirection;
    private ArrayList<Direction> lastDirections = new ArrayList<>();

    public Ghost(String normal, String vulnerable) {

        position = new Position(7, 7);
        this.normal = normal;
        this.vulnerable = vulnerable;
        ghostSymbol = new Picture(gridPadding + position.getCol() * gridCellSize, gridPadding + position.getRow() * gridCellSize, this.normal); // added
        ghostSymbol.draw();
        extraPoints = 100;
    }

    public void setPositionManager(PositionManager positionManager) {
        this.positionManager = positionManager;
    }

    public void move() {

        if (!isEaten() && !isFragile()) {

            ghostSymbol.load(this.normal);
            ghostSymbol.draw();

            if (randomMoveSelector == 0) {
                randomMove();
            } else {
                if (!notInitialMove) {
                    initialMove();
                } else {
                    chooseDirection(positionManager.getPacman().getPosition());
                }
            }
        } else if (!isEaten() && isFragile()) {
            ghostSymbol.delete();
            ghostSymbol.load(this.vulnerable);
            ghostSymbol.draw();

            if (randomMoveSelector == 0) {
                randomMove();
            } else {
                Position oppositePacMan = new Position(Math.abs(positionManager.getPacman().getPosition().getCol() - 14), Math.abs(positionManager.getPacman().getPosition().getRow() - 14));
                chooseDirection(oppositePacMan);
            }
        } else if (isEaten()) {
            ghostSymbol.delete();
            this.eaten = false;
            randomMoveSelector = (int) (Math.random() * 2);
            notInitialMove = false;
            position.setPosition(7, 7);
            ghostSymbol = new Picture(gridPadding + position.getCol() * gridCellSize, gridPadding + position.getRow() * gridCellSize, normal); // added
            ghostSymbol.draw();
        }
    }

    private void randomMove() {

        if (Math.random() < CHANGE_DIRECTION_ODD) {
            if (positionManager.isMovePossible(position, direction, this)) {
                newPosition();
                return;
            }
        }

        Direction newDirection = direction.opposite();

        while (newDirection == direction.opposite()) {
            newDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        }

        direction = newDirection;

        if (positionManager.isMovePossible(position, direction, this)) {
            newPosition();
        }
    }

    private void chooseDirection(Position targetPosition) {

        Option up = new Option(targetPosition, Direction.UP);
        up.newPossiblePosition(position.getCol(), position.getRow() - 1);
        up.sethCost(Math.abs(targetPosition.getCol() - up.possiblePosition.getCol()) + Math.abs(targetPosition.getRow() - up.possiblePosition.getRow()));

        Option down = new Option(targetPosition, Direction.DOWN);
        down.newPossiblePosition(position.getCol(), position.getRow() + 1);
        down.sethCost(Math.abs(targetPosition.getCol() - down.possiblePosition.getCol()) + Math.abs(targetPosition.getRow() - down.possiblePosition.getRow()));

        Option right = new Option(targetPosition, Direction.RIGHT);
        right.newPossiblePosition(position.getCol() + 1, position.getRow());
        right.sethCost(Math.abs(targetPosition.getCol() - right.possiblePosition.getCol()) + Math.abs(targetPosition.getRow() - right.possiblePosition.getRow()));

        Option left = new Option(targetPosition, Direction.LEFT);
        left.newPossiblePosition(position.getCol() - 1, position.getRow());
        left.sethCost(Math.abs(targetPosition.getCol() - left.possiblePosition.getCol()) + Math.abs(targetPosition.getRow() - left.possiblePosition.getRow()));

        PriorityQueue<Option> options = new PriorityQueue<>();
        options.add(up);
        options.add(down);
        options.add(right);
        options.add(left);

        while (!options.isEmpty()) {
            Option chosen = options.remove();

            if (positionManager.isMovePossible(position, chosen.direction, this)) {
                direction = chosen.direction;
                lastDirections.add(direction);
                break;
            }
        }
        newPosition();
    }


    private void newPosition() {

        lastDirection = direction;
        switch (direction) {
            case LEFT:
                position.setPosition(position.getCol() - 1, position.getRow());
                ghostSymbol.translate(-gridCellSize, 0);
                break;
            case RIGHT:
                position.setPosition(position.getCol() + 1, position.getRow());
                ghostSymbol.translate(gridCellSize, 0);
                break;
            case UP:
                position.setPosition(position.getCol(), position.getRow() - 1);
                ghostSymbol.translate(0, -gridCellSize);
                break;
            case DOWN:
                position.setPosition(position.getCol(), position.getRow() + 1);
                ghostSymbol.translate(0, gridCellSize);
                break;
        }
    }

    private void initialMove() {

        if (position.getRow() > 4) {
            direction = Direction.UP;
            newPosition();
            return;
        } else {
            int random = (int) (Math.random() * 2);
            if (random == 0) {
                chooseDirection(initialChasePosition1);
                if (position.equals(initialChasePosition1)) {
                    notInitialMove = true;
                    return;
                }
            } else {
                chooseDirection(initialChasePosition2);
                if (position.equals(initialChasePosition2)) {
                    notInitialMove = true;
                    return;
                }
            }
        }
    }

    public static boolean isFragile() {
        return fragile;
    }

    public static void makeFragile() {

        Ghost.fragile = true;
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
                Ghost.fragile = false;
            } catch (InterruptedException ex) {
            }
        });
        t.start();
    }


    @Override
    public void hideShape() {
    }

    @Override
    public void drawShape() {
    }

    private class Option implements Comparable<Option> {

        private Position position;
        private Position possiblePosition;
        private Direction direction;
        private int hCost;

        public Option(Position targetPosition, Direction direction) {

            position = targetPosition;
            this.direction = direction;
        }

        public void sethCost(int hCost) {
            this.hCost = hCost;
        }

        public void newPossiblePosition(int col, int row) {
            possiblePosition = new Position(col, row);
        }


        @Override
        public int compareTo(Option obj) {
            return Integer.compare(hCost, obj.hCost);
        }
    }
}
