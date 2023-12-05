package Model;

import Model.Arena.Arena;
import Model.Elements.Coin;
import Model.Elements.Enemy;
import Model.Elements.Player;
import Model.Elements.PowerUp;
import Viewer.GameViewer;
import gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.text.Position;
import java.io.IOException;
import java.util.Arrays;

public class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setEnemy(Arrays.asList(new Enemy(4, 5), new Enemy(5, 6)));
        arena.setPlayer(new Player(5, 8));
        arena.setCoin(new Coin(3,3));
        arena.setPowerUp(new PowerUp(4,6));
    }

    @Test
    void drawPlayer() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));
    }

    @Test
    void drawEnemy() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(5, 6));
        Mockito.verify(gui, Mockito.times(2)).drawEnemy(Mockito.any(Position.class));
    }

    @Test

    void drawCoin() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(3,3));
        Mockito.verify(gui, Mockito.times(1)).drawCoin(Mockito.any(Position.class));
    }

    @Test

    void drawPowerUp() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPowerUp(new Position(4,6));
        Mockito.verify(gui, Mockito.times(1)).drawPowerUp(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

}
