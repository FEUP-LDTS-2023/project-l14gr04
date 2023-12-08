package RushRoulette.controller.game;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Arena.LoaderArenaBuilder;
import RushRoulette.Model.Game.Elements.Enemy;
import RushRoulette.Model.Game.GameTimer;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.States.GameOverState;
import RushRoulette.States.GameState;
import RushRoulette.States.MenuState;
import RushRoulette.controller.Music.Music;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;
import RushRoulette.gui.GUI;

import java.io.IOException;
import java.util.Random;

public class ArenaController extends GameController {
    private final PlayerController playerController;
    private final EnemyController enemyController;

    private static int level=1;

    Random type=new Random();


    public ArenaController(Arena arena) {
        super(arena);

        this.playerController = new PlayerController(arena);
        this.enemyController = new EnemyController(arena);
    }

    public static int getLevel() {
        return level;
    }

    public void step(Application application, GUI.ACTION action, long time) throws IOException {

        if ((action == GUI.ACTION.QUIT)) {
            level=1;
            getModel().getPlayer().resetScore();
            getModel().getPlayer().resetLives();
            application.setState(new MenuState(new Menu()));
        }
        else if (getModel().getPlayer().getDead() == 1) {
            level=1;
            getModel().getPlayer().resetLives();
            MusicPlayer.getInstance().start(Sounds.GAMEOVER);
            application.setState(new GameOverState(new GameOver(getModel().getPlayer().getScore())));
            getModel().getPlayer().resetScore();

        }
       else if(getModel().getGameTimer().getCurrentTime()==0){

            if(level == 30 && getModel().getGameTimer().getCurrentTime() == 0){
                level=1;
                getModel().getPlayer().resetScore();
                getModel().getPlayer().resetLives();
                MusicPlayer.getInstance().stop(Sounds.GAME_SOUNDTRACK);
                application.setState(new MenuState(new Menu()));
            }
            else{
                level+=1;
                getModel().getPlayer().levelPoints();

                if(level == 15){
                    MusicPlayer.getInstance().stop(Sounds.GAME_SOUNDTRACK);
                    MusicPlayer.getInstance().start(Sounds.GAME_SOUNDTRACK2);
                }


                application.setState(new GameState(new LoaderArenaBuilder(level).createArena()));

            }

        }
        else {
            playerController.step(application, action, time);
            enemyController.step(application, action, time);
        }
    }
    public void handlePlayerPowerUpCollision(){
        int nextType= type.nextInt(2);
        switch (nextType){
            case 0:
                getModel().getPlayer().isHit();
                break;
                //remove uma vida ao player
            case 1:
                getModel().getPlayer().addLife();
                break;
                //adiciona uma vida ao player
        }
    }

}
