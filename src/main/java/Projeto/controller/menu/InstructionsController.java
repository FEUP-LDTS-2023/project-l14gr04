package Projeto.controller.menu;

import Projeto.Application;
import Projeto.Model.Menu.Instructions;
import Projeto.Model.Menu.Menu;
import Projeto.States.MenuState;
import Projeto.controller.Controller;
import Projeto.controller.Music.MusicPlayer;
import Projeto.controller.Music.Sounds;
import Projeto.gui.GUI;

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