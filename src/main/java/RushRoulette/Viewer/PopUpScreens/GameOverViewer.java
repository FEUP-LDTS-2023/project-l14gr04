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

        gui.drawText(new Position(0,0), "========================================","#8B0000" );
        gui.drawText(new Position(0,1), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,2), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,3), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,4), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,5), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,6), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,7), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,8), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,9), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,10), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,11), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,12), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,13), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,14), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,15), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,16), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,17), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,18), "||                                    ||","#8B0000");
        gui.drawText(new Position(0,19), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,20), "=========================================","#8B0000");

        gui.drawText(new Position(11,7), "GAME OVER", "#8B0000" );

        for(int i=0; i<getModel().getNumberEntries();i++){
            gui.drawText(
                    new Position(11 + 10*i, 11),">" +
                    getModel().getEntry(i),
                    getModel().isSelected(i)? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position(5,19),"Your score:" + getModel().getScore()   ,"#FFFFFF");
    }
}
