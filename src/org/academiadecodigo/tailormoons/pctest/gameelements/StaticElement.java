package org.academiadecodigo.tailormoons.pctest.gameelements;

import org.academiadecodigo.tailormoons.pctest.gamecontrol.Position;

public class StaticElement extends GameElement {

    private StaticElementType staticElementType;

    public StaticElement(StaticElementType staticElementType, int col, int row) {

        this.staticElementType = staticElementType;
        position = new Position(col, row);
    }

    public StaticElementType getStaticElementType() {
        return staticElementType;
    }
}
