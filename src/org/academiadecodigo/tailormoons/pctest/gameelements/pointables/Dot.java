package org.academiadecodigo.tailormoons.pctest.gameelements.pointables;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.Position;

public class Dot extends Pointable {

    private Ellipse dotSymbol;

    public Dot(int col, int row) {

        this.position = new Position(col, row);
        points = 1;
    }

    @Override
    public void drawShape() {
        
        dotSymbol = new Ellipse(gridPadding + getPosition().getCol() * gridCellSize + gridCellSize / 3, gridPadding + getPosition().getRow() * gridCellSize + gridCellSize / 3, gridCellSize / 3, gridCellSize / 3);
        dotSymbol.setColor(Color.LIGHT_GRAY);
        dotSymbol.fill();
    }

    @Override
    public void hideShape() {
        dotSymbol.delete();
    }

}
