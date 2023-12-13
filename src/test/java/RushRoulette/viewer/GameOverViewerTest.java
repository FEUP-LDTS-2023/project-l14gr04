package RushRoulette.viewer;

import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.PopUpScreens.GameOverViewer;
import RushRoulette.gui.LanternaGUI;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverViewerTest {
    GameOverViewer viewer;

    GameOver gameOver;
    LanternaGUI gui;
    @BeforeEach
    void setUP(){
        gameOver=Mockito.mock(GameOver.class);
        gui=Mockito.mock(LanternaGUI.class);
        viewer= new GameOverViewer(gameOver);

    }


    @Test
    void testViewGameOver() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawText(new Position(0, 0), "========================================", "#202121");
    }
}
