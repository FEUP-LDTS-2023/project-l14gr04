package Projeto.controller.PopUpScreens;

import Projeto.Application;
import Projeto.Model.Game.Arena.LoaderArenaBuilder;
import Projeto.Model.Menu.Menu;
import Projeto.Model.PopUpScreens.GameOver;
import Projeto.Model.PopUpScreens.SaveScore;
import Projeto.States.GameState;
import Projeto.States.MenuState;
import Projeto.States.SaveScoreState;
import Projeto.controller.Controller;
import Projeto.controller.Music.MusicPlayer;
import Projeto.controller.Music.Sounds;
import Projeto.gui.GUI;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOverScreen){
        super(gameOverScreen);

    }
    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

        switch(action){
            case RIGHT:
                getModel().nextEntry();
                MusicPlayer.getInstance().start(Sounds.SELECT);
                break;
            case LEFT:
                getModel().previousEntry();
                MusicPlayer.getInstance().start(Sounds.SELECT);
                break;
            case SELECT:
                if(getModel().menuSelected()) {
                    MusicPlayer.getInstance().stopAll();
                    MusicPlayer.getInstance().start(Sounds.MENU_SOUNDTRACK);
                    application.setState(new MenuState(new Menu()));
                }
                if(getModel().tryAgainSelected()) {
                    MusicPlayer.getInstance().stopAll();
                    MusicPlayer.getInstance().start(Sounds.GAME_SOUNDTRACK);
                    application.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                }

                if(getModel().saveSelected()) {
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));
                }
        }
    }
}
