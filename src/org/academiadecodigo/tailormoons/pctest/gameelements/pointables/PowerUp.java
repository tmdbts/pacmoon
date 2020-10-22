package org.academiadecodigo.tailormoons.pctest.gameelements.pointables;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.Position;

public class PowerUp extends Pointable {

    private PowerUpType powerUpType;
    private Picture powerUpShape;

    public PowerUp(PowerUpType powerUpType, int col, int row) {

        this.powerUpType = powerUpType;
        this.position = new Position(col, row);
        extraPoints = 10;
    }

    @Override
    public void drawShape() {

        switch (powerUpType) {
            case JS:
                powerUpShape = new Picture(gridPadding + getPosition().getCol() * gridCellSize, gridPadding + getPosition().getRow() * gridCellSize, "assets/js.png");
                break;
            case SQL:
                powerUpShape = new Picture(gridPadding + getPosition().getCol() * gridCellSize, gridPadding + getPosition().getRow() * gridCellSize, "assets/sql.jpg");
                break;
            case HTML:
                powerUpShape = new Picture(gridPadding + getPosition().getCol() * gridCellSize, gridPadding + getPosition().getRow() * gridCellSize, "assets/html.png");
                break;
            case JAVA:
                powerUpShape = new Picture(gridPadding + getPosition().getCol() * gridCellSize, gridPadding + getPosition().getRow() * gridCellSize, "assets/java.jpg");
                break;
        }
        powerUpShape.draw();
    }

    @Override
    public void hideShape() {
        powerUpShape.delete();
    }
}
