package RushRoulette.Viewer.PopUpScreens;

import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.Model.PopUpScreens.Victory;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

public class VictoryViewer extends Viewer<Victory> {

    public VictoryViewer(Victory victoryScreen){
        super(victoryScreen);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(12,7), "YOU WON!!", "#FFFFFF" );

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
