package RushRoulette.viewer;

import RushRoulette.Model.Menu.LeaderBoard;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Menu.LeaderBoardViewer;
import RushRoulette.gui.GUI;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LeaderBoardViewerTest {
    @Test
    public void testDrawElements() {
        GUI gui = mock(GUI.class);

        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.getEntries().add("Player 1 - 100");
        leaderBoard.getEntries().add("Player 2 - 90");

        LeaderBoardViewer leaderBoardViewer = new LeaderBoardViewer(leaderBoard);

        leaderBoardViewer.drawElements(gui);

        verify(gui, times(24)).drawText(any(Position.class), anyString(), anyString());

        verify(gui, times(1)).drawText(new Position(3, 19), "Menu", "#FFD700");
    }
}
