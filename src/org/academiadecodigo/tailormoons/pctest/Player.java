package org.academiadecodigo.tailormoons.pctest;

public class Player {

    private int points;
    private int extraPoints;

    public void addPoints(int points) {

        this.points += points;
        System.out.println(this.points);
    }

    public void addExtraPoints(int points) {
        this.extraPoints += points;
    }

    public int getPoints() {
        return points;
    }
}
