package gui;

import javax.swing.text.Position;
import java.io.IOException;

    public interface GUI {
        ACTION getNextAction() throws IOException;

        void drawPlayer(Position position);

        void drawWall(Position position);

        void drawEnemy(Position position);

        void drawText(Position position, String text, String color);

        void drawCoin(Position position);
        void drawPowerUp(Position position);
        void clear();

        void refresh() throws IOException;

        void close() throws IOException;



        enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
    }


