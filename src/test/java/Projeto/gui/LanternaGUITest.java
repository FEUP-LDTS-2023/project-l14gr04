
package Projeto.gui;


import Projeto.Model.Position;
import Projeto.gui.LanternaGUI;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp(){
        screen= mock(Screen.class);
        tg= mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawPlayer(){
        gui.drawPlayer(new Position(1,1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(118, 235, 104));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "+");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void drawCoin(){
        gui.drawCoin(new Position(1,1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(242, 167, 5));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "$");
    }
    @Test
    void drawPowerUp(){
        gui.drawPowerUp(new Position(1,1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(64, 245, 206));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, ".");
    }


    @Test
    void drawEnemy(){
        gui.drawEnemy(new Position(1,1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(245, 62, 45));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, ",");
    }

    @Test
    void drawWall(){
        gui.drawWall(new Position(1,1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(120, 116, 115));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "#");
    }

    @Test
    void closeScreen() throws IOException {
        // Mock the Screen class
        Screen screenMock = mock(Screen.class);

        // Create a LanternaGUI instance
        LanternaGUI lanternaGUI = new LanternaGUI(screenMock);

        // Call the close method
        lanternaGUI.close();

        // Verify that the close method is called on the mocked screen
        Mockito.verify(screenMock, Mockito.times(1)).close();
    }

    @Test
    void refreshScreen() throws IOException {
        // Mock the Screen class
        Screen screenMock = mock(Screen.class);

        // Create a LanternaGUI instance
        LanternaGUI lanternaGUI = new LanternaGUI(screenMock);

        // Call the refresh method
        lanternaGUI.refresh();

        // Verify that the refresh method is called on the mocked screen
        Mockito.verify(screenMock, Mockito.times(1)).refresh();
    }

    @Test
    void clearScreen() {
        // Mock the Screen class
        Screen screenMock = Mockito.mock(Screen.class);

        // Create a LanternaGUI instance
        LanternaGUI lanternaGUI = new LanternaGUI(screenMock);

        // Call the clear method
        lanternaGUI.clear();

        // Verify that the clear method is called on the mocked screen
        Mockito.verify(screenMock, Mockito.times(1)).clear();
    }

    @Test
    void getNextActionArrowUp() throws IOException {
        testKeyTypeAction(KeyType.ArrowUp, GUI.ACTION.UP);
    }

    @Test
    void getNextActionArrowDown() throws IOException {
        testKeyTypeAction(KeyType.ArrowDown, GUI.ACTION.DOWN);
    }

    @Test
    void getNextActionArrowLeft() throws IOException {
        testKeyTypeAction(KeyType.ArrowLeft, GUI.ACTION.LEFT);
    }

    @Test
    void getNextActionArrowRight() throws IOException {
        testKeyTypeAction(KeyType.ArrowRight, GUI.ACTION.RIGHT);
    }

    @Test
    void getNextActionEnter() throws IOException {
        testKeyTypeAction(KeyType.Enter, GUI.ACTION.SELECT);
    }

    @Test
    void getNextActionEOF() throws IOException {
        testKeyTypeAction(KeyType.EOF, GUI.ACTION.QUIT);
    }

    @Test
    void getNextActionCharacterQ() throws IOException {
        testCharacterAction('q', GUI.ACTION.QUIT);
    }

    private void testKeyTypeAction(KeyType keyType, GUI.ACTION expectedAction) throws IOException {
        // Mock the Screen class
        Screen screenMock = Mockito.mock(Screen.class);

        // Mock the KeyStroke class
        KeyStroke keyStrokeMock = Mockito.mock(KeyStroke.class);

        // Mocking the behavior of pollInput() to return a KeyStroke
        Mockito.when(screenMock.pollInput()).thenReturn(keyStrokeMock);

        // Mocking KeyStroke methods for the expected behavior
        Mockito.when(keyStrokeMock.getKeyType()).thenReturn(keyType);

        // Create a LanternaGUI instance
        LanternaGUI lanternaGUI = new LanternaGUI(screenMock);

        // Call the getNextAction method
        GUI.ACTION action = lanternaGUI.getNextAction();

        // Verify that the expected KeyType triggered the correct action
        assertEquals(expectedAction, action, "Expected action did not match for KeyType: " + keyType);
    }

    private void testCharacterAction(char character, GUI.ACTION expectedAction) throws IOException {
        // Mock the Screen class
        Screen screenMock = Mockito.mock(Screen.class);

        // Mock the KeyStroke class
        KeyStroke keyStrokeMock = Mockito.mock(KeyStroke.class);

        // Mocking the behavior of pollInput() to return a KeyStroke
        Mockito.when(screenMock.pollInput()).thenReturn(keyStrokeMock);

        // Mocking KeyStroke methods for the expected behavior
        Mockito.when(keyStrokeMock.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStrokeMock.getCharacter()).thenReturn(character);

        // Create a LanternaGUI instance
        LanternaGUI lanternaGUI = new LanternaGUI(screenMock);

        // Call the getNextAction method
        GUI.ACTION action = lanternaGUI.getNextAction();

        // Verify that the expected character triggered the correct action
        assertEquals(expectedAction, action, "Expected action did not match for Character: " + character);
    }
}

