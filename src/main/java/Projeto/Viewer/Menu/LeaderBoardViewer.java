package Projeto.Viewer.Menu;

import Projeto.Model.Menu.LeaderBoard;
import Projeto.Model.Position;
import Projeto.Viewer.Viewer;
import Projeto.gui.GUI;

public class LeaderBoardViewer extends Viewer<LeaderBoard> {

    public LeaderBoardViewer(LeaderBoard LeaderBoardScreen) {
        super(LeaderBoardScreen);

    }

    @Override
    public void drawElements(GUI gui) {

        //draw from text file
        int lineNumber = 0;
        for( String line : getModel().getEntries()){

            gui.drawText(new Position(0,lineNumber), line, "#6700ff");
            lineNumber += 1;
        }

        gui.drawText(new Position(3,19),getModel().getMenuOption(), "#FFD700");

    }


}
