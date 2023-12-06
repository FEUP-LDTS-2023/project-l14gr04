package RushRoulette.Model.Game.Arena;


import RushRoulette.Model.Game.Elements.*;
import RushRoulette.Model.Position;


import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Player player;
    private List<Enemy> enemies;
    private List<PowerUp> powerUps;

    private List<Coin> coins;
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
    public boolean isCoinFree(Position position){
        for(Coin c:coins){
            if(c.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }
    public boolean isPowerUpFree(Position position){
        for(PowerUp p:powerUps){
            if(p.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public boolean isEnemy(Position position){
        for(Enemy enemy:enemies){
            if(enemy.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
}
