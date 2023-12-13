package RushRoulette.Model.Menu;

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
        // You can add more specific checks based on your expectations
    }

    @Test
    public void testReadLeaderBoardFile() {
        LeaderBoard leaderBoard = new LeaderBoard();
        // Assuming the LeaderBoard.txt file contains certain entries
        // You can check if the entries read match your expectations
        assertNotNull(leaderBoard.getEntries());
        assertTrue(leaderBoard.getEntries().size() > 0);
    }
}
