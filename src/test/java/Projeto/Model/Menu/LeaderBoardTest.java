package Projeto.Model.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderBoardTest {
    @Test
    public void testGetMenuOption() {
        LeaderBoard leaderBoard = new LeaderBoard();
        assertEquals("Menu", leaderBoard.getMenuOption());
    }

    @Test
    public void testGetEntries() {
        LeaderBoard leaderBoard = new LeaderBoard();
        assertFalse(leaderBoard.getEntries().isEmpty());
    }

    @Test
    public void testReadLeaderBoardFile() {
        LeaderBoard leaderBoard = new LeaderBoard();
        assertNotNull(leaderBoard.getEntries());
        assertTrue(leaderBoard.getEntries().size() > 0);
    }
}
