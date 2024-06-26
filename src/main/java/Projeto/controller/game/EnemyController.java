package Projeto.controller.game;

import Projeto.Application;
import Projeto.Model.Game.Arena.Arena;
import Projeto.Model.Game.Elements.Enemy;
import Projeto.Model.Position;
import Projeto.gui.GUI;

import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovement;
    private int enemySpeed;

    public EnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
        this.enemySpeed=500;
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

            if (getModel().getPlayer().getPosition().equals(position)) {
                if (getModel().getPlayer().getInvulnerability() == 0) {
                    getModel().getPlayer().isHit();
                    if (getModel().getPlayer().getLives() == 0) getModel().getPlayer().isDead();
                }
            }
        }
    }

}
