package Projeto.viewer;

import Projeto.Model.Menu.Instructions;
import Projeto.Model.Position;
import Projeto.Viewer.Menu.InstructionsViewer;
import Projeto.gui.LanternaGUI;
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
