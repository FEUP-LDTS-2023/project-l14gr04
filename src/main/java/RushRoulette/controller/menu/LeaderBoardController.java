package RushRoulette.controller.menu;

import RushRoulette.Application;
import RushRoulette.Model.Menu.LeaderBoard;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.States.MenuState;
import RushRoulette.controller.Controller;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;
import RushRoulette.gui.GUI;

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