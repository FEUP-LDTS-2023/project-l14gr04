package RushRoulette.controller.game;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Elements.Enemy;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.States.MenuState;
import RushRoulette.gui.GUI;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PlayerController playerController;
    private final EnemyController enemyController;

    public ArenaController(Arena arena) {
        super(arena);

        this.playerController = new PlayerController(arena);
        this.enemyController = new EnemyController(arena);
    }

    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if ((action == GUI.ACTION.QUIT) || getModel().getPlayer().getDead() == 1) {
            application.setState(new MenuState(new Menu()));
        } else {
            playerController.step(application, action, time);
            enemyController.step(application, action, time);
        }
    }
}
