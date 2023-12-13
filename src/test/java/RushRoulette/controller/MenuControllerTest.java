package RushRoulette.controller;

import RushRoulette.Application;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.controller.menu.MenuController;
import RushRoulette.gui.GUI;
import RushRoulette.gui.LanternaGUI;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MenuControllerTest {
    Menu menu;
    MenuController menuController;
    KeyStroke keyStroke;
    LanternaGUI lanternaGUI;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        menuController =new MenuController(menu);
        keyStroke = mock(KeyStroke.class);
        lanternaGUI = mock(LanternaGUI.class);
    }
    @Test
    public void PreviousEntry() throws IOException, URISyntaxException, FontFormatException {

        Mockito.when(lanternaGUI.getNextAction()).thenReturn(GUI.ACTION.UP);
        menuController.step(new Application(),lanternaGUI.getNextAction(),0);
        verify(menu, times(1)).previousEntry();
    }
    @Test
    public void NextEntry() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(lanternaGUI.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        menuController.step(new Application(), lanternaGUI.getNextAction(), 0);
        verify(menu, times(1)).nextEntry();
    }
    @Test
    public void PlaySelect() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(lanternaGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        menuController.step(new Application(),lanternaGUI.getNextAction(),0);
        verify(menu, times(1)).playSelected();
    }
    @Test
    public void InstructionsSelect() throws IOException, URISyntaxException, FontFormatException {
        Application app = new Application();
        Mockito.when(lanternaGUI.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        menuController.step(app,lanternaGUI.getNextAction(),1);
        Mockito.when(lanternaGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        menuController.step(app,lanternaGUI.getNextAction(),2);
        verify(menu, times(1)).playSelected();
    }
    @Test
    public void PlayExitSelect() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(lanternaGUI.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        menuController.step(new Application(),lanternaGUI.getNextAction(),1);
        Mockito.when(lanternaGUI.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        menuController.step(new Application(),lanternaGUI.getNextAction(),2);
        Mockito.when(lanternaGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        menuController.step(new Application(),lanternaGUI.getNextAction(),3);
        verify(menu, times(1)).exitSelected();
    }

}

