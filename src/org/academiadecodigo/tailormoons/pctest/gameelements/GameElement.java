package org.academiadecodigo.tailormoons.pctest.gameelements;

import org.academiadecodigo.tailormoons.pctest.gamecontrol.Position;

public class GameElement {

    protected Position position;
    protected boolean eaten;
    protected int gridPadding = 10;
    protected int gridCellSize = 50;
    
    public Position getPosition() {
        return position;
    }

    public void makeEaten() {
        eaten = true;
    }

    public boolean isEaten() {
        return eaten;
    }



}
