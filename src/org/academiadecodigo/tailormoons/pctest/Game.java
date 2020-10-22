package org.academiadecodigo.tailormoons.pctest;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.Info;
import org.academiadecodigo.tailormoons.pctest.gamecontrol.PositionManager;
import org.academiadecodigo.tailormoons.pctest.gameelements.*;
import org.academiadecodigo.tailormoons.pctest.gameelements.pointables.Ghost;

public class Game {
    private Player player;
    Grid grid = new Grid();
    private PacMan pacman = new PacMan();
    PositionManager positionManager = new PositionManager();
    private Ghost francisco = new Ghost("assets/francisco21.png", "assets/franciscoFragile.png");
    private Ghost sid = new Ghost("assets/sid.png", "assets/SidFragile.png");
    private Ghost vando = new Ghost("assets/vando.png", "assets/vandoFragile.png");
    private Info info = new Info();
    Text showPoints;

    public Game(Player player) {
        this.player = player;
    }

    public void setup() {

        positionManager.setGrid(grid);
        positionManager.setPacman(pacman);
        pacman.setPositionManager(positionManager);
        positionManager.setPlayer(player);
        positionManager.setGhost(francisco, sid, vando);
        francisco.setPositionManager(positionManager);
        sid.setPositionManager(positionManager);
        vando.setPositionManager(positionManager);
        info.drawLives();

        showPoints = new Text(700, 845, player.getPoints() + "");
        showPoints.setColor(Color.WHITE);
        showPoints.grow(15, 20);
        showPoints.draw();

    }

    public void start() {

        while ((!pacman.isDead()) && (!endGame())) {
            try {
                showPoints();
                pacman.move();
                francisco.move();
                sid.move();
                vando.move();
                positionManager.updateGameElements();
                Thread.sleep(200);
            } catch (Exception ex) {

            }
        }
        if (player.getPoints() < 134) {
            info.gameOver();
            return;
        }
        info.champ();
    }

    private boolean endGame() {
        return player.getPoints() >= 134;
    }

    private void showPoints() {
        showPoints.setText(player.getPoints() + "");
    }


}
