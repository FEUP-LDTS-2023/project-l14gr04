package RushRoulette.Model.Game.Arena;

import RushRoulette.Model.Game.Elements.*;
import RushRoulette.Model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ArenaBuilder {
    public Arena createArena(){
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setWalls(createWalls());
        arena.setPlayer(createPlayer());
        arena.setEnemies(createEnemies());
        arena.setCoins(createCoins());
        arena.setPowerUps(createPowerUps());
        return arena;
    }

    protected  int getWidth(){
        return this.getWidth();
    }
    protected  int getHeight(){
        return this.getHeight();
    }
    protected  List<Coin> createCoins(){
        List<Coin> coins = new ArrayList<Coin>();
        Random random = new Random();
        for(int i =0; i<2;i++){
            boolean sucess= false;
            int randomX=0;
            int randomY=0;
            while (!sucess){
                randomX= random.nextInt(getWidth()-2)+1;
                randomY= random.nextInt(getHeight()-2)+1;
                if(createArena().isEmpty(new Position(randomX,randomY))
                        && createArena().isCoinFree(new Position(randomX,randomY))
                        && createArena().isPowerUpFree(new Position(randomX,randomY))){ sucess= true;}
            }
            coins.add(new Coin(randomX,randomY));
        }
        return coins;
    }

    protected  List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < getWidth(); x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, getHeight() - 1));
        }

        for (int y = 1; y < getHeight() - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(getWidth() - 1, y));
        }

        return walls;
    }
    protected  Player createPlayer(){ return new Player(getWidth()/2,getHeight()/2);}
    protected  List<Enemy> createEnemies(){
        List<Enemy> enemies= new ArrayList<Enemy>();
        enemies.add(new Enemy(1,1));
        return enemies;
    }
    protected  List<PowerUp> createPowerUps(){
        List<PowerUp> powerUps= new ArrayList<PowerUp>();
        powerUps.add(new PowerUp(getWidth()-4,getHeight()-4));
        return powerUps;
    }

}
