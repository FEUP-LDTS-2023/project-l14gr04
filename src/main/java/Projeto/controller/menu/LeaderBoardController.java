package Projeto.controller.menu;

import Projeto.Application;
import Projeto.Model.Menu.LeaderBoard;
import Projeto.Model.Menu.Menu;
import Projeto.States.MenuState;
import Projeto.controller.Controller;
import Projeto.controller.Music.MusicPlayer;
import Projeto.controller.Music.Sounds;
import Projeto.gui.GUI;

import java.io.IOException;
import java.util.Objects;

public class LeaderBoardController extends Controller<LeaderBoard> {
    public LeaderBoardController(LeaderBoard leaderBoard){
        super(leaderBoard);
    }
    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (Objects.requireNonNull(action) == GUI.ACTION.SELECT) {
            MusicPlayer.getInstance().start(Sounds.SELECT);
            application.setState(new MenuState(new Menu()));
        }
    }
}