package org.academiadecodigo.tailormoons.pctest.gamecontrol;

import org.academiadecodigo.tailormoons.pctest.Game;
import org.academiadecodigo.tailormoons.pctest.Grid;
import org.academiadecodigo.tailormoons.pctest.Player;
import org.academiadecodigo.tailormoons.pctest.gameelements.*;
import org.academiadecodigo.tailormoons.pctest.gameelements.pointables.Dot;
import org.academiadecodigo.tailormoons.pctest.gameelements.pointables.Ghost;
import org.academiadecodigo.tailormoons.pctest.gameelements.pointables.PowerUp;
import org.academiadecodigo.tailormoons.pctest.gameelements.pointables.PowerUp;
import org.academiadecodigo.tailormoons.pctest.gameelements.pointables.SpecialDot;

public class PositionManager {

    private Grid grid;
    private PacMan pacman;
    private Player player;

    private Ghost francisco;
    private Ghost sid;
    private Ghost vando;
    private Info info = new Info();


    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setPacman(PacMan pacman) {
        this.pacman = pacman;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGhost(Ghost francisco, Ghost sid, Ghost vando) {
        this.francisco = francisco;
        this.sid = sid;
        this.vando = vando;
    }

    public boolean isMovePossible(Position position, Direction direction, GameElement element) {
        Position wantedPosition = new Position(0, 0);


        switch (direction) {
            case UP:
                wantedPosition.setPosition(position.getCol(), position.getRow() - 1);
                break;
            case DOWN:
                wantedPosition.setPosition(position.getCol(), position.getRow() + 1);
                break;
            case RIGHT:
                wantedPosition.setPosition(position.getCol() + 1, position.getRow());
                break;
            case LEFT:
                wantedPosition.setPosition(position.getCol() - 1, position.getRow());
                break;
        }
        if (element instanceof PacMan) {
            return (!(grid.getArena()[wantedPosition.getCol()][wantedPosition.getRow()] instanceof StaticElement));
        }

        GameElement temp = grid.getArena()[wantedPosition.getCol()][wantedPosition.getRow()];
        if (temp instanceof StaticElement) {
            return (((StaticElement) temp).getStaticElementType() != StaticElementType.WALL);
        }
        return true;
    }

    public void updateGameElements() {
        //grid.draw(pacman);
        //grid.draw(ghost);
        GameElement temp = grid.getArena()[pacman.getPosition().getCol()][pacman.getPosition().getRow()];

        if (temp instanceof SpecialDot) {
            if (!temp.isEaten()) {
                ((SpecialDot) temp).addPoints(player);
                temp.makeEaten();
                ((SpecialDot) temp).makeFragile();
                ((SpecialDot) temp).hideShape();
            }
        } else if (temp instanceof Dot) {
            if (!temp.isEaten()) {
                temp.makeEaten();
                ((Dot) temp).addPoints(player);
                ((Dot) temp).hideShape();
            }
        } else if (temp instanceof PowerUp) {
            if (!temp.isEaten()) {
                temp.makeEaten();
                ((PowerUp) temp).addExtraPoints(player);
                ((PowerUp) temp).hideShape();
            }
        }

        if (pacman.getPosition().equals(francisco.getPosition()) || pacman.getPosition().equals(sid.getPosition()) || pacman.getPosition().equals(vando.getPosition())) { //added
            if (!Ghost.isFragile()) {
                pacman.takeLife();
                info.remove(pacman.getLivesLeft());
            } else {
                francisco.makeEaten();
                sid.makeEaten();
                vando.makeEaten();
                francisco.addExtraPoints(player); //added
                sid.addExtraPoints(player); //added
                vando.addExtraPoints(player); //added


            }
        }
    }

    public PacMan getPacman() {
        return pacman;
    }

    public Grid getGrid() {
        return grid;
    }
}
