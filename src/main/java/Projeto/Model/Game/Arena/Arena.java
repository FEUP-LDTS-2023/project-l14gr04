package Projeto.Model.Game.Arena;
import Projeto.Model.Game.*;
import Projeto.Model.Game.Elements.*;
import Projeto.Model.Position;
import Projeto.controller.game.ArenaController;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Player player;
    private List<Enemy> enemies;
    private List<PowerUp> powerUps;

    private List<Coin> coins;
    private List<Wall> walls;

    private GameTimer gameTimer;

    private ArenaController arenaController;



    public Arena(int width, int height) {
        this.arenaController=new ArenaController(this);
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
        public boolean isEnemy(Position position) {
            for (Enemy enemy : enemies) {
                if (enemy.getPosition().equals(position)) {
                    return true;
                }
            }
            return false;
        }

    public boolean isCoin(Position position) {
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                return true;
            }
        }
        return false;
    }

    public boolean isPowerUp(Position position) {
        for (PowerUp powerUp : powerUps) {
            if (powerUp.getPosition().equals(position)) {
                powerUps.remove(powerUp);
                return true;
            }
        }
        return false;
    }

    public GameTimer getGameTimer(){
        return this.gameTimer;
    }

    public void setGameTimer(GameTimer gameTimer) {
        this.gameTimer = gameTimer;
    }

    public boolean isEnemyFree(Position position){
        for(Enemy e:enemies){
            if(e.getPosition().equals(position)) return false;
        }
        return true;
    }

    public ArenaController getArenaController() {
        return arenaController;
    }
}
