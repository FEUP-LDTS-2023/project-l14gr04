package RushRoulette.viewer;

import RushRoulette.Model.Menu.Instructions;
import RushRoulette.Model.PopUpScreens.Victory;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Menu.InstructionsViewer;
import RushRoulette.Viewer.PopUpScreens.VictoryViewer;
import RushRoulette.gui.LanternaGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class InstructionsViewerTest {
    InstructionsViewer viewer;
    Instructions instructions;
    LanternaGUI gui;
    @BeforeEach
    void setUp(){
        instructions= Mockito.mock(Instructions.class);
        gui=Mockito.mock(LanternaGUI.class);
        viewer=new InstructionsViewer(instructions);
    }
    @Test
    void testViewGameOver() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawText(new Position(0,0), "======= I N S T R U C T I O N S ========","#0022CC" );
    }
}
