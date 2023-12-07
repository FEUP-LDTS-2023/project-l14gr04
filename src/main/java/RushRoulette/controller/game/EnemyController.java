package RushRoulette.controller.game;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Elements.Enemy;
import RushRoulette.Model.Position;
import RushRoulette.gui.GUI;

import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovement;

    public EnemyController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Enemy enemy : getModel().getEnemies())
                moveEnemy(enemy, enemy.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }
    }

    private void moveEnemy(Enemy enemy, Position position) {
        if (getModel().isEmpty(position)) {
            enemy.setPosition(position);
            if (getModel().getPlayer().getPosition().equals(position))
                getModel().getPlayer().isDead();
        }
    }
}
