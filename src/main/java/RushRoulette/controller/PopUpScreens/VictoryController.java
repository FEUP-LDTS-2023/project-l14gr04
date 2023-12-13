package RushRoulette.controller.PopUpScreens;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.LoaderArenaBuilder;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.Model.PopUpScreens.SaveScore;
import RushRoulette.Model.PopUpScreens.Victory;
import RushRoulette.States.GameState;
import RushRoulette.States.MenuState;
import RushRoulette.States.SaveScoreState;
import RushRoulette.controller.Controller;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;
import RushRoulette.gui.GUI;

import java.io.IOException;

public class VictoryController extends Controller<Victory> {
    public VictoryController(Victory victoryScreen){
        super(victoryScreen);

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
                    application.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                    MusicPlayer.getInstance().stopAll();
                    MusicPlayer.getInstance().start(Sounds.GAME_SOUNDTRACK);
                }

                if(getModel().saveSelected()){
                    application.setState((new SaveScoreState(new SaveScore(getModel().getScore()))));
                }

        }
    }
}