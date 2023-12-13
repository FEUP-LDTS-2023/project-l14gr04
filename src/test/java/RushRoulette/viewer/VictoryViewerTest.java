package RushRoulette.viewer;

import RushRoulette.Model.PopUpScreens.Victory;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.PopUpScreens.VictoryViewer;
import RushRoulette.gui.LanternaGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class VictoryViewerTest {
    VictoryViewer viewer;
    Victory victory;
    LanternaGUI gui;
    @BeforeEach
    void setUp(){
        victory= Mockito.mock(Victory.class);
        gui=Mockito.mock(LanternaGUI.class);
        viewer=new VictoryViewer(victory);
    }
    @Test
    void testViewGameOver() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawText(new Position(0, 0), "========================================", "#004600");
    }
}
