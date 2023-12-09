package RushRoulette.controller.menu;

import RushRoulette.Application;
import RushRoulette.Model.Menu.Instructions;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.States.MenuState;
import RushRoulette.controller.Controller;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;
import RushRoulette.gui.GUI;

import java.io.IOException;
import java.util.Objects;

public class InstructionsController extends Controller<Instructions> {
    public InstructionsController(Instructions instructions){
        super(instructions);

    }
    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (Objects.requireNonNull(action) == GUI.ACTION.SELECT) {
            MusicPlayer.getInstance().start(Sounds.SELECT);
            application.setState(new MenuState(new Menu()));
        }
    }
}