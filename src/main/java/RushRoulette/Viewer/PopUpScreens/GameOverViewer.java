package RushRoulette.Viewer.PopUpScreens;

import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

public class GameOverViewer extends Viewer<GameOver> {

    public GameOverViewer(GameOver gameOverScreen){
        super(gameOverScreen);
    }
    @Override
    protected void drawElements(GUI gui) {

        gui.drawText(new Position(0, 0), "========================================", "#202121");
        gui.drawText(new Position(0, 1), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 2), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 3), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 4), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 5), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 6), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 7), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 8), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 9), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 10), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 11), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 12), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 13), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 14), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 15), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 16), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 17), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 18), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 19), "||                                    ||", "#202121");
        gui.drawText(new Position(0, 20), "=========================================", "#202121");


        gui.drawText(new Position(11,7), "GAME OVER", "#8B0000" );

        for(int i=0; i<getModel().getNumberEntries();i++){
            gui.drawText(
                    new Position(7 + 10*i, 11),">" +
                    getModel().getEntry(i),
                    getModel().isSelected(i)? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position(5,19),"Your score:" + getModel().getScore()   ,"#FFFFFF");
    }
}
