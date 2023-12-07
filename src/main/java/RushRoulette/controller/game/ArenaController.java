package RushRoulette.controller.game;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Arena.LoaderArenaBuilder;
import RushRoulette.Model.Game.Elements.Enemy;
import RushRoulette.Model.Game.GameTimer;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.States.GameState;
import RushRoulette.States.MenuState;
import RushRoulette.gui.GUI;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PlayerController playerController;
    private final EnemyController enemyController;

    private static int level=1;

    public ArenaController(Arena arena) {
        super(arena);

        this.playerController = new PlayerController(arena);
        this.enemyController = new EnemyController(arena);
    }

    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if ((action == GUI.ACTION.QUIT) || getModel().getPlayer().getDead() == 1) {
            application.setState(new MenuState(new Menu()));
        }
        else if(getModel().getGameTimer().getCurrentTime()==0){
            level+=1;
            getModel().getPlayer().levelPoints();
            //System.out.println(level);
            application.setState(new GameState(new LoaderArenaBuilder(level).createArena()));
            /*LoaderArenaBuilder newArenaBuilder = new LoaderArenaBuilder(level);
            Arena newArena=newArenaBuilder.createArena();
            setModel(newArena);
            newArena.getGameTimer().getCurrentTime();*/

        }
        else {
            playerController.step(application, action, time);
            enemyController.step(application, action, time);
        }
    }
}
