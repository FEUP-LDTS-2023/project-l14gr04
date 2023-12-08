package RushRoulette.controller.game;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Elements.Enemy;
import RushRoulette.Model.Position;
import RushRoulette.gui.GUI;

import java.io.IOException;
import java.util.Random;

public class EnemyController extends GameController {
    private long lastMovement;

    Random option =new Random();

    private int enemySpeed;

    public EnemyController(Arena arena) {
        super(arena);
        this.enemySpeed=500;
        this.lastMovement = 0;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > enemySpeed) {
            Position playerPosition = getModel().getPlayer().getPosition();
            for (Enemy enemy : getModel().getEnemies()){
                Position enemyPosition = enemy.getPosition();
                Position newPosition=chasePlayer(enemyPosition,playerPosition);
                if(getModel().isEnemyFree(newPosition)){
                moveEnemy(enemy,newPosition );
                }
                else {moveEnemy(enemy,enemyPosition.getRandomNeighbour());}
            }
            this.lastMovement = time;
        }
    }
private Position chasePlayer(Position enemyPosition, Position playerPosition){
    int deltaX = Integer.compare(playerPosition.getX(), enemyPosition.getX());
    int deltaY = Integer.compare(playerPosition.getY(), enemyPosition.getY());

    int newX = enemyPosition.getX() + deltaX;
    int newY = enemyPosition.getY() + deltaY;

    return new Position(newX, newY);
}
    private void moveEnemy(Enemy enemy, Position position) {
        if (getModel().isEmpty(position) && getModel().isEnemyFree(position)) {
            enemy.setPosition(position);
            if (getModel().getPlayer().getPosition().equals(position))
                getModel().getPlayer().isDead();
        }
    }

    public void adjustEnemySpeed(){
        int next = option.nextInt(2);
        switch (next){
            case 0:
                enemySpeed-=500;
            case 1:
                enemySpeed+=500;
        }
    }
}
