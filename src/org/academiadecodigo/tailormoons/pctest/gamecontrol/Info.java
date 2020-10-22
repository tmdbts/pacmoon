package org.academiadecodigo.tailormoons.pctest.gamecontrol;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Info {
    private static Picture picture1 = new Picture(30, 825, "assets/tailormoon.png");
    private static Picture picture2 = new Picture(80, 825, "assets/tailormoon.png");
    private static Picture picture3 = new Picture(130, 825, "assets/tailormoon.png");

    public void drawLives() {
        picture1.draw();
        picture2.draw();
        picture3.draw();
        Text lives = new Text(100, 885, "lives");
        lives.setColor(Color.WHITE);
        lives.grow(20, 10);
        lives.draw();
        Text score = new Text(700, 885, "SCORE");
        score.setColor(Color.WHITE);
        score.grow(20, 10);
        score.draw();
    }

    public void remove(int number) {
        System.out.println("I'm here");
        if (number == 2) {
            picture3.delete();
            Text text = new Text(335, 835, "In the name of the Moon, I'll punish you!");
            text.setColor(Color.WHITE);
            text.grow(50, 15);
            text.draw();
            return;
        } else if (number == 1) {
            picture2.delete();
            Text text = new Text(360, 865, "In the name of Mars, I will chastise you!");
            text.setColor(Color.YELLOW);
            text.grow(50, 15);
            text.draw();
            return;
        }
        picture1.delete();
        Text text = new Text(369, 895, "Douse yourself in water and repent!");
        text.setColor(Color.MAGENTA);
        text.grow(50, 15);
        text.draw();
    }

    public void gameOver() {
        Picture gameOver = new Picture(10, 10, "assets/bgcopy.png");
        gameOver.draw();
        Picture gameOverMessage = new Picture(250,250, "assets/gameoverpac.png");
        gameOverMessage.draw();
    }

    public void champ(){
        Picture gameOver = new Picture(10, 10, "assets/bgcopy.png");
        gameOver.draw();    Picture win = new Picture(10,10, "assets/win.png");
        win.draw();}
}