package RushRoulette.viewer;

import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Elements.*;
import RushRoulette.Model.Game.GameTimer;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Game.ArenaViewer;
import RushRoulette.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.io.IOException;
import java.util.Arrays;

public class ArenaViewerTest {
    private GUI gui;
    private ArenaViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new ArenaViewer(arena);

        arena.setGameTimer(new GameTimer());
        arena.setEnemies(Arrays.asList(new Enemy(4, 5), new Enemy(5, 6)));
        arena.setPlayer(new Player(5, 8));
        arena.setCoins(Arrays.asList(new Coin(3,3)));
        arena.setPowerUps(Arrays.asList(new PowerUp(4,6)));
        arena.setWalls(Arrays.asList(new Wall(1,1),new Wall(2,3)));
    }

    @Test
    void drawPlayer() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(5,8));
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
