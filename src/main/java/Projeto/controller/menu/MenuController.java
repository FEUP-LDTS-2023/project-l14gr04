package Projeto.controller.menu;


import Projeto.Application;
import Projeto.Model.Game.Arena.LoaderArenaBuilder;
import Projeto.Model.Menu.Instructions;
import Projeto.Model.Menu.LeaderBoard;
import Projeto.Model.Menu.Menu;
import Projeto.States.GameState;
import Projeto.States.InstructionsState;
import Projeto.States.LeaderBoardState;
import Projeto.controller.Controller;
import Projeto.controller.Music.MusicPlayer;
import Projeto.controller.Music.Sounds;
import Projeto.gui.GUI;

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
