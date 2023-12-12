package RushRoulette.controller.menu;


import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.LoaderArenaBuilder;
import RushRoulette.Model.Menu.Instructions;
import RushRoulette.Model.Menu.LeaderBoard;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.States.GameState;
import RushRoulette.States.InstructionsState;
import RushRoulette.States.LeaderBoardState;
import RushRoulette.controller.Controller;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;
import RushRoulette.gui.GUI;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu){
        super(menu);
    }
    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException{

        switch(action){
            case UP:
                getModel().previousEntry();
                MusicPlayer.getInstance().start(Sounds.SELECT);
                break;
            case DOWN:
                getModel().nextEntry();
                MusicPlayer.getInstance().start(Sounds.SELECT);
                break;
            case SELECT:
                if(getModel().exitSelected()) {
                    MusicPlayer.getInstance().stopAll();
                    application.setState(null);
                }
                if(getModel().playSelected()) {
                    application.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                    MusicPlayer.getInstance().stopAll();
                    MusicPlayer.getInstance().start(Sounds.GAME_SOUNDTRACK);
                }

                if(getModel().instructionsSelected()){
                    application.setState(new InstructionsState(new Instructions()));
                }

                if(getModel().leaderBoardSelected()){
                    application.setState(new LeaderBoardState(new LeaderBoard()));
                }


        }
    }
}
