package RushRoulette.Viewer.PopUpScreens;

import RushRoulette.Model.Game.Arena.Arena;
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
        gui.drawText(new Position(12,7), "GAME OVER!!", "#FFFFFF" );

        gui.drawText(new Position(10,9), "----------------", "#FFFFFF" );

        for(int i=0; i<getModel().getNumberEntries();i++){
            gui.drawText(
                    new Position(11 + 10*i, 11),
                    getModel().getEntry(i),
                    getModel().isSelected(i)? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position(5,19),"Your score:" + getModel().getScore()   ,"#FFFFFF");
    }
}
