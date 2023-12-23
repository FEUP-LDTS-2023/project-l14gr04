package Projeto.Viewer.PopUpScreens;

import Projeto.Model.PopUpScreens.Victory;
import Projeto.Model.Position;
import Projeto.Viewer.Viewer;
import Projeto.gui.GUI;

public class VictoryViewer extends Viewer<Victory> {

    public VictoryViewer(Victory victoryScreen){
        super(victoryScreen);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(0, 0), "========================================", "#004600");
        gui.drawText(new Position(0, 1), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 2), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 3), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 4), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 5), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 6), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 7), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 8), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 9), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 10), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 11), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 12), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 13), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 14), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 15), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 16), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 17), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 18), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 19), "||                                    ||", "#004600");
        gui.drawText(new Position(0, 20), "=========================================", "#004600");


        gui.drawText(new Position(7,7), "Flawless victory!", "#004600" );


        for(int i=0; i<getModel().getNumberEntries();i++){
            gui.drawText(
                    new Position( 7 + 10*i, 11), ">" +
                    getModel().getEntry(i),
                    getModel().isSelected(i)? "#FFD700" : "#004600");
        }

        gui.drawText(new Position(5,19),"Your score:" + getModel().getScore()   ,"#FFFFFF");
    }
}
