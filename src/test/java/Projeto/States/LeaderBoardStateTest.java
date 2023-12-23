package Projeto.States;

import Projeto.Model.Menu.LeaderBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LeaderBoardStateTest {

        @Test
        public void testConstructor() {
            LeaderBoard leaderBoardModel = new LeaderBoard();
            LeaderBoardState leaderBoardState = new LeaderBoardState(leaderBoardModel);

            assertEquals(leaderBoardModel, leaderBoardState.getModel());
            assertNotNull(leaderBoardState.getViewer());
            assertNotNull(leaderBoardState.getController());
        }

}
