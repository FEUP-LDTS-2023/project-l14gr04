package RushRoulette.controller.PopUpScreens;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.LoaderArenaBuilder;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.States.GameState;
import RushRoulette.States.MenuState;
import RushRoulette.controller.Controller;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;
import RushRoulette.gui.GUI;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOverScreen){
        super(gameOverScreen);

    }
    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

        switch(action){
            case RIGHT:
                getModel().previousEntry();
                MusicPlayer.getInstance().start(Sounds.SELECT);
                break;
            case LEFT:
                getModel().nextEntry();
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


        }
    }
}
