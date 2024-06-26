package Projeto;

import Projeto.Model.Menu.Menu;
import Projeto.States.MenuState;
import Projeto.States.State;
import Projeto.controller.Music.MusicPlayer;
import Projeto.controller.Music.Sounds;
import Projeto.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private final LanternaGUI gui;
    private State state;

    public Application() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(40, 20);
        MusicPlayer.getInstance().start(Sounds.MENU_SOUNDTRACK);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Application().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 100;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}