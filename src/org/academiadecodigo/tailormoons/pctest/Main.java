package org.academiadecodigo.tailormoons.pctest;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        Game game = new Game(player);
        game.setup();
        game.start();
    }
}
