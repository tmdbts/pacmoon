package org.academiadecodigo.tailormoons.pctest;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.pctest.gameelements.*;
import org.academiadecodigo.tailormoons.pctest.gameelements.pointables.*;

public class Grid {

    private int col = 16;
    private int row = 16;
    private GameElement[][] arena = new GameElement[col][row];
    private static final int PADDING = 10;
    private static final int CELL_SIZE = 50;

    public Grid() {

        init();
        initialDrawing();
    }

    private void init() {

        Picture background = new Picture(PADDING, PADDING, "assets/Starrysky.jpg");
        background.draw();

        Rectangle data = new Rectangle(PADDING, PADDING * 2 + row * CELL_SIZE, CELL_SIZE * col, 100);
        data.setColor(Color.BLACK);
        data.fill();

        //create outer walls
        for (int i = 0; i < col; i++) {
            arena[0][i] = new StaticElement(StaticElementType.WALL, 0, i);
            arena[row - 1][i] = new StaticElement(StaticElementType.WALL, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            arena[i][0] = new StaticElement(StaticElementType.WALL, i, 0);
            arena[i][col - 1] = new StaticElement(StaticElementType.WALL, i, col - 1);
        }

        //create inner walls
        for (int i = 2; i < 7; i++) {
            arena[2][i] = new StaticElement(StaticElementType.WALL, 2, i);
        }
        for (int i = 8; i < 14; i++) {
            arena[2][i] = new StaticElement(StaticElementType.WALL, 2, i);
        }
        for (int i = 3; i < 6; i++) {
            arena[i][13] = new StaticElement(StaticElementType.WALL, i, 13);
        }
        for (int i = 6; i < 9; i++) {
            arena[13][i] = new StaticElement(StaticElementType.WALL, 13, i);
        }
        for (int i = 10; i < 14; i++) {
            arena[13][i] = new StaticElement(StaticElementType.WALL, 13, i);
        }
        for (int i = 2; i < 5; i++) {
            arena[12][i] = new StaticElement(StaticElementType.WALL, 12, i);
        }
        for (int i = 2; i < 4; i++) {
            arena[11][i] = new StaticElement(StaticElementType.WALL, 11, i);
        }
        for (int i = 6; i < 11; i++) {
            arena[11][i] = new StaticElement(StaticElementType.WALL, 11, i);
        }
        for (int i = 10; i < 13; i++) {
            arena[8][i] = new StaticElement(StaticElementType.WALL, 8, i);
        }
        for (int i = 10; i < 13; i++) {
            arena[9][i] = new StaticElement(StaticElementType.WALL, 9, i);
        }
        for (int i = 4; i < 6; i++) {
            for (int j = 10; j < 12; j++) {
                arena[i][j] = new StaticElement(StaticElementType.WALL, i, j);
            }
        }
        for (int i = 6; i < 9; i++) {
            arena[i][3] = new StaticElement(StaticElementType.WALL, i, 3);
        }
        arena[7][2] = new StaticElement(StaticElementType.WALL, 7, 2);

        //create walls around ghost house
        for (int i = 5; i < 7; i++) {
            arena[i][5] = new StaticElement(StaticElementType.WALL, i, 5);
        }
        for (int i = 8; i < 10; i++) {
            arena[i][5] = new StaticElement(StaticElementType.WALL, i, 5);
        }
        for (int i = 5; i < 10; i++) {
            arena[i][8] = new StaticElement(StaticElementType.WALL, i, 8);
        }
        for (int i = 6; i < 8; i++) {
            arena[5][i] = new StaticElement(StaticElementType.WALL, 5, i);
        }
        for (int i = 6; i < 8; i++) {
            arena[9][i] = new StaticElement(StaticElementType.WALL, 9, i);
        }

        //create ghost house gate
        arena[7][5] = new StaticElement(StaticElementType.GHOST_HOUSE_GATE, 7, 5);

        //create ghost house
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 8; j++) {
                arena[i][j] = new StaticElement(StaticElementType.GHOST_HOUSE, i, j);
            }
        }

        //create SpecialDots
        arena[1][1] = new SpecialDot(1, 1);
        ((SpecialDot) arena[1][1]).drawShape();
        arena[1][14] = new SpecialDot(1, 14);
        ((SpecialDot) arena[1][14]).drawShape();
        arena[14][1] = new SpecialDot(14, 1);
        ((SpecialDot) arena[14][1]).drawShape();
        arena[14][14] = new SpecialDot(14, 14);
        ((SpecialDot) arena[14][14]).drawShape();

        //create Dots
        for (int i = 2; i < 14; i++) {
            arena[1][i] = new Dot(1, i);
            ((Dot) arena[1][i]).drawShape();
        }
        for (int i = 2; i < 14; i++) {
            arena[i][1] = new Dot(i, 1);
            ((Dot) arena[i][1]).drawShape();
        }
        for (int i = 2; i < 14; i++) {
            arena[14][i] = new Dot(14, i);
            ((Dot) arena[14][i]).drawShape();
        }
        for (int i = 2; i < 14; i++) {
            arena[i][14] = new Dot(i, 14);
            ((Dot) arena[i][14]).drawShape();
        }
        for (int i = 2; i < 13; i++) {
            arena[3][i] = new Dot(3, i);
            ((Dot) arena[3][i]).drawShape();
        }
        for (int i = 2; i < 10; i++) {
            arena[4][i] = new Dot(4, i);
            ((Dot) arena[4][i]).drawShape();
        }
        for (int i = 4; i < 8; i++) {
            arena[i][12] = new Dot(i, 12);
            ((Dot) arena[i][12]).drawShape();
        }
        for (int i = 2; i < 5; i++) {
            arena[5][i] = new Dot(5, i);
            ((Dot) arena[5][i]).drawShape();
        }
        for (int i = 5; i < 7; i++) {
            arena[i][9] = new Dot(i, 9);
            ((Dot) arena[i][9]).drawShape();
        }
        for (int i = 8; i < 10; i++) {
            arena[i][9] = new Dot(i, 9);
            ((Dot) arena[i][9]).drawShape();
        }
        for (int i = 6; i < 10; i++) {
            arena[i][13] = new Dot(i, 13);
            ((Dot) arena[i][13]).drawShape();
        }
        for (int i = 2; i < 14; i++) {
            arena[10][i] = new Dot(10, i);
            ((Dot) arena[10][i]).drawShape();
        }
        for (int i = 2; i < 6; i++) {
            arena[13][i] = new Dot(13, i);
            ((Dot) arena[13][i]).drawShape();
        }
        for (int i = 5; i < 14; i++) {
            arena[12][i] = new Dot(12, i);
            ((Dot) arena[12][i]).drawShape();
        }
        for (int i = 4; i < 6; i++) {
            arena[11][i] = new Dot(11, i);
            ((Dot) arena[11][i]).drawShape();
        }
        for (int i = 11; i < 14; i++) {
            arena[11][i] = new Dot(11, i);
            ((Dot) arena[11][i]).drawShape();
        }
        for (int i = 6; i < 9; i++) {
            arena[i][4] = new Dot(i, 4);
            ((Dot) arena[i][4]).drawShape();
        }
        for (int i = 2; i < 5; i++) {
            arena[9][i] = new Dot(9, i);
            ((Dot) arena[9][i]).drawShape();
        }
        for (int i = 6; i < 8; i++) {
            for (int j = 10; j < 12; j++) {
                arena[i][j] = new Dot(i, j);
                ((Dot) arena[i][j]).drawShape();
            }
        }
        arena[6][2] = new Dot(6, 2);
        ((Dot) arena[6][2]).drawShape();
        arena[8][2] = new Dot(8, 2);
        ((Dot) arena[8][2]).drawShape();
        arena[2][7] = new Dot(2, 7);
        ((Dot) arena[2][7]).drawShape();
        arena[13][9] = new Dot(13, 9);
        ((Dot) arena[13][9]).drawShape();

        Thread timer = new Thread(() -> {

            try {
                Thread.sleep(15000);
                ((Dot) arena[1][5]).hideShape();
                GameElement temp = arena[1][5];
                arena[1][5] = new PowerUp(PowerUpType.HTML, 1, 5);
                ((PowerUp) arena[1][5]).drawShape();
                Thread.sleep(10000);
                ((PowerUp) arena[1][5]).hideShape();
                arena[1][5] = temp;

                if (!arena[1][5].isEaten()) {
                    ((Dot) temp).drawShape();
                }

                Thread.sleep(5000);
                ((Dot) arena[4][4]).hideShape();
                temp = arena[4][4];
                arena[4][4] = new PowerUp(PowerUpType.JAVA, 4, 4);
                ((PowerUp) arena[4][4]).drawShape();
                Thread.sleep(10000);

                ((PowerUp) arena[4][4]).hideShape();
                arena[4][4] = temp;
                if (!arena[4][4].isEaten()) {
                    ((Dot) temp).drawShape();
                }

                Thread.sleep(5000);
                ((Dot) arena[12][7]).hideShape();
                arena[12][7] = new PowerUp(PowerUpType.JS, 12, 7);
                ((PowerUp) arena[12][7]).drawShape();
                Thread.sleep(10000);

                ((PowerUp) arena[12][7]).hideShape();
                arena[12][7] = temp;
                if (!arena[12][7].isEaten()) {
                    ((Dot) temp).drawShape();
                }

                Thread.sleep(5000);
                ((Dot) arena[10][13]).hideShape();
                arena[10][13] = new PowerUp(PowerUpType.SQL, 10, 13);
                ((PowerUp) arena[10][13]).drawShape();
                Thread.sleep(10000);

                ((PowerUp) arena[10][13]).hideShape();
                arena[10][13] = temp;
                if (!arena[10][13].isEaten()) {
                    ((Dot) temp).drawShape();
                }

            } catch (Exception e) {
            }
        });
        timer.start();
    }


    public void draw(GameElement element) {

        if (element instanceof Ghost) {
            Rectangle ghost1Symbol = new Rectangle(PADDING + element.getPosition().getCol() * CELL_SIZE, PADDING + element.getPosition().getRow() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            ghost1Symbol.setColor(Color.RED);
            if (!element.isEaten()) {
                ghost1Symbol.fill();
            } else {
                ghost1Symbol.draw();
            }
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            ghost1Symbol.delete();
        }
    }


    private void initialDrawing() {
        //drawing the cells
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                Rectangle cell = new Rectangle(PADDING + i * CELL_SIZE, PADDING + j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                Ellipse specialDot = new Ellipse(PADDING + i * CELL_SIZE + CELL_SIZE / 4, PADDING + j * CELL_SIZE + CELL_SIZE / 4, CELL_SIZE / 2, CELL_SIZE / 2);
                Ellipse dot = new Ellipse(PADDING + i * CELL_SIZE + CELL_SIZE / 3, PADDING + j * CELL_SIZE + CELL_SIZE / 3, CELL_SIZE / 3, CELL_SIZE / 3);
                if (arena[i][j] instanceof StaticElement) {

                    StaticElement temp = (StaticElement) arena[i][j];

                    switch (temp.getStaticElementType()) {
                        case WALL:
                            cell.setColor(Color.DARK_GRAY);
                            cell.fill();
                            break;
                        case GHOST_HOUSE:
                            cell.setColor(Color.GRAY);
                            cell.fill();
                            break;
                        case GHOST_HOUSE_GATE:
                            cell.setColor(Color.BLACK);
                            cell.draw();
                            break;
                    }
                }
            }
        }
    }

    public GameElement[][] getArena() {
        return arena;
    }

    public int getCols() {
        return col;
    }

    public int getRows() {
        return row;
    }

}
