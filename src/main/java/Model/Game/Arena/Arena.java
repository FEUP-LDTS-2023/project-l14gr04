package Model.Game.Arena;

import Model.Game.Elements.Wall;
import Model.Position;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    /*private Player player;
    private List<Enemy> enemies;
    private List<PowerUp> powerUps;
     */
    private List<Wall> walls;


    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public boolean isEmpty(Position position){
        for(Wall w:walls){
            if(w.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }
    /*
    adicionar gets e sets para player, enemies e powerups
     */



}
