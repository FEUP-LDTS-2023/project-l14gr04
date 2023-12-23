
package Projeto.viewer;

import Projeto.Model.Menu.Menu;
import Projeto.Model.Position;
import Projeto.Viewer.Menu.MenuViewer;
import Projeto.gui.LanternaGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {
    MenuViewer menuViewer;
    Menu menu;
    LanternaGUI gui;

    @BeforeEach
    void setup(){
        menu= Mockito.mock(Menu.class);
        gui=Mockito.mock(LanternaGUI.class);
        menuViewer = new MenuViewer(menu);
    }
    @Test
    void testViewMenu() throws IOException {
        menuViewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawText(new Position(0,0), "==============  M E N U  ===============","#8B0000" );
    }

}
