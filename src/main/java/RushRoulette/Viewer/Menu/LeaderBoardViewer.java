package RushRoulette.Viewer.Menu;

import RushRoulette.Model.Menu.LeaderBoard;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

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
