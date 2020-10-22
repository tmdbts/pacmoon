package org.academiadecodigo.tailormoons.pctest.gamecontrol;

import org.academiadecodigo.tailormoons.pctest.gameelements.GameElement;

public class Position {

    private int col;
    private int row;

    public Position(int col, int row){
        this.col = col;
        this.row = row;
    }

    public void setPosition(int col, int row){
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow(){
        return row;
    }

    public boolean equals(Position position){
        return (this.getCol() == position.getCol() && this.getRow() == position.getRow());
    }

}

