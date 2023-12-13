package RushRoulette.Viewer.PopUpScreens;

import RushRoulette.Model.PopUpScreens.SaveScore;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

public class SaveScoreViewer extends Viewer<SaveScore> {

    public SaveScoreViewer(SaveScore saveScoreScreen) {
        super(saveScoreScreen);
    }

    protected void drawElements(GUI gui) {
        gui.drawText(new Position(0, 0), "========================================", "#f500ff");
        gui.drawText(new Position(0, 1), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 2), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 3), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 4), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 5), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 6), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 7), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 8), "||                                    ||", "#f500ff");
        gui.drawText(new Position(2, 8), "             ________               ", "#40F5CE");
        gui.drawText(new Position(0, 9), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 10), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 11), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 12), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 13), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 14), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 15), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 16), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 17), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 18), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 19), "||                                    ||", "#f500ff");
        gui.drawText(new Position(0, 20), "=========================================", "#f500ff");


        gui.drawText(new Position(12,5), "WRITE YOUR NAME!", "#f500ff" );


        int lineSpaceCounter = 0;
        int lineSpaceCounter2 = 0;
        int lineSpaceCounter3 = 0;

        for(int i=0; i<getModel().getNumberEntries();i++){

            if(i<=1){
                gui.drawText(
                        new Position(12 + 11*i, 10), getModel().getEntry(i),
                        getModel().isSelected(i)? "#FFD700" : "#FFFFFF");

            }
            else if(i <= 11){
                gui.drawText(
                    new Position(10 + lineSpaceCounter, 12), getModel().getEntry(i),
                    getModel().isSelected(i)? "#FFD700" : "#FFFFFF");
                    lineSpaceCounter +=2;

            }
            else if(i <= 20){
                gui.drawText(
                        new Position(11 + lineSpaceCounter2, 13), getModel().getEntry(i),
                        getModel().isSelected(i)? "#FFD700" : "#FFFFFF");
                lineSpaceCounter2 +=2;
            }
            else if(i <= 27){
                gui.drawText(
                        new Position(12 + lineSpaceCounter3, 14), getModel().getEntry(i),
                        getModel().isSelected(i)? "#FFD700" : "#FFFFFF");
                lineSpaceCounter3 +=2;
            }
        }

        gui.drawText(new Position(5,19),"Your score:" + getModel().getScore()   ,"#FFFFFF");

        //name draw with restrictions of ::::: 8 spaces::::
        if(!getModel().getNickNameKeyList().isEmpty()){
            if(getModel().getNickNameKeyList().size() <= 8) {
                for (int i = 0; i < getModel().getNickNameKeyList().size(); i++) {
                    gui.drawText(new Position(15 + i, 8), getModel().getNickNameKeyList().get(i), "#40F5CE");

                }
            }
            else{ for (int i = 0; i < 8; i++) {
                gui.drawText(new Position(15 + i, 8), getModel().getNickNameKeyList().get(i), "#40F5CE");

            }


            }
        }


    }

}
