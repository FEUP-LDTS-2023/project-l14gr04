package RushRoulette;

import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Arena.ArenaBuilder;
import RushRoulette.Model.Game.Arena.LoaderArenaBuilder;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.States.GameState;
import RushRoulette.States.MenuState;
import RushRoulette.States.State;
import RushRoulette.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Application {
    private final LanternaGUI gui;
    private State state;

    public Application() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(40, 20);
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