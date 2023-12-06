package RushRoulette.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import RushRoulette.Model.Position;

import java.io.IOException;

public class LanternaGUI implements GUI{
    private Screen screen;
    public LanternaGUI(Screen screen){
        this.screen = screen;
    }

    public LanternaGUI(int width,  int height) throws IOException{
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();

        return terminal;
    }

    private void drawCharacter(int x, int y, char c, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y, "" + c);
    }

    @Override
    public ACTION getNextAction() throws IOException {
        return null;
    }

    @Override
    public void drawPlayer(Position position) {
        drawCharacter(position.getX(),position.getY(),'P',"#FFD700");
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(),position.getY(),'#',"#3333FF");

    }

    @Override
    public void drawEnemy(Position position) {
        drawCharacter(position.getX(),position.getY(),'E',"#CC0000E");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawCoin(Position position) {
        drawCharacter(position.getX(),position.getY(),'C',"#CC0000E");

    }

    @Override
    public void drawPowerUp(Position position) {
        drawCharacter(position.getX(),position.getY(),'P',"#CC0000E");
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
