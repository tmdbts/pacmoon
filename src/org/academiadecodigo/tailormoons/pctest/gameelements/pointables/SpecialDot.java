package org.academiadecodigo.tailormoons.pctest.gameelements.pointables;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.Position;

public class SpecialDot extends Pointable {

    private Ellipse specialDotSymbol;

    public SpecialDot(int col, int row) {

        this.position = new Position(col, row);
        points = 2;
    }

    @Override
    public void drawShape() {

        specialDotSymbol = new Ellipse(gridPadding + getPosition().getCol() * gridCellSize + gridCellSize / 4, gridPadding + getPosition().getRow() * gridCellSize + gridCellSize / 4, gridCellSize / 2, gridCellSize / 2);
        specialDotSymbol.setColor(Color.CYAN);
        specialDotSymbol.fill();
    }

    @Override
    public void hideShape() {
        specialDotSymbol.delete();
    }

    public void makeFragile() {
        Ghost.makeFragile();
    }

}
