package Projeto.controller.game;

import Projeto.Application;
import Projeto.Model.Game.Arena.Arena;
import Projeto.Model.Game.Arena.LoaderArenaBuilder;
import Projeto.Model.Menu.Menu;
import Projeto.Model.PopUpScreens.GameOver;
import Projeto.Model.PopUpScreens.Victory;
import Projeto.States.GameOverState;
import Projeto.States.GameState;
import Projeto.States.MenuState;
import Projeto.States.VictoryState;
import Projeto.controller.Music.MusicPlayer;
import Projeto.controller.Music.Sounds;
import Projeto.gui.GUI;

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
            getModel().getPlayer().resetPowerUps();
            application.setState(new MenuState(new Menu()));
        }
        else if (getModel().getPlayer().getDead() == 1) {
            level=1;
            getModel().getPlayer().resetLives();
            getModel().getPlayer().resetPowerUps();
            MusicPlayer.getInstance().stopAll();
            MusicPlayer.getInstance().start(Sounds.GAMEOVER);
            application.setState(new GameOverState(new GameOver(getModel().getPlayer().getScore())));
            getModel().getPlayer().resetScore();

        }

        else if(level == 30 && getModel().getGameTimer().getCurrentTime() == 0){
            level=1;
            getModel().getPlayer().resetLives();
            getModel().getPlayer().resetPowerUps();
            MusicPlayer.getInstance().stop(Sounds.GAME_SOUNDTRACK3);
            MusicPlayer.getInstance().start(Sounds.VICTORY);
            application.setState(new VictoryState(new Victory(getModel().getPlayer().getScore())));
            getModel().getPlayer().resetScore();
        }

        else if(getModel().getGameTimer().getCurrentTime()==0){


                level+=1;
                getModel().getPlayer().levelPoints();

                if(level == 10){
                    MusicPlayer.getInstance().stop(Sounds.GAME_SOUNDTRACK);
                    MusicPlayer.getInstance().start(Sounds.GAME_SOUNDTRACK2);
                }
                else if (level == 20) {
                    MusicPlayer.getInstance().stop(Sounds.GAME_SOUNDTRACK2);
                    MusicPlayer.getInstance().start(Sounds.GAME_SOUNDTRACK3);
                }

                application.setState(new GameState(new LoaderArenaBuilder(level).createArena()));
                MusicPlayer.getInstance().start(Sounds.NEW_LVL);

        }
        else {
            playerController.step(application, action, time);
            enemyController.step(application, action, time);
        }
    }
    public void handlePlayerPowerUpCollision(){
        int nextType= type.nextInt(5);
        switch (nextType){
            case 0:
                getModel().getPlayer().removeLife();//remove uma vida ao player
                break;
            case 1:
                getModel().getPlayer().addLife();//adiciona uma vida ao player
                break;
            case 2:
                getModel().getPlayer().half();
                break;
            case 3:
                getModel().getPlayer().dup();
                break;
            case 4:
                getModel().getPlayer().invulnerable();
                break;
        }
    }

}
