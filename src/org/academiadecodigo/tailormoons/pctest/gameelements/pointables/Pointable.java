package org.academiadecodigo.tailormoons.pctest.gameelements.pointables;

import org.academiadecodigo.tailormoons.pctest.Player;
import org.academiadecodigo.tailormoons.pctest.gameelements.GameElement;

public abstract class Pointable extends GameElement {

    protected int points;
    protected  int extraPoints;


    public abstract void drawShape();

    public abstract void hideShape();


    public void addPoints(Player player){
        player.addPoints(points);
    }

    public void addExtraPoints(Player player){
        player.addExtraPoints(points);
    }


}
