package RushRoulette.Model.PopUpScreens;


import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.States.GameOverState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverTest {
    @Test
    public void testConstructor1() {
        int initialScore = 100;
        GameOver gameOver = new GameOver(initialScore);

        assertEquals(initialScore, gameOver.getScore());
        assertEquals(2, gameOver.getNumberEntries()); // Assuming there are two default entries: Retry and Menu
        assertTrue(gameOver.tryAgainSelected()); // By default, the first entry (Retry) should be selected
    }

    // Test case for checking if the nextEntry method updates the selected entry correctly
    @Test
    public void testNextEntry() {
        GameOver gameOver = new GameOver(100);

        assertTrue(gameOver.tryAgainSelected());

        gameOver.nextEntry();
        assertTrue(gameOver.menuSelected());

        gameOver.nextEntry();
        assertTrue(gameOver.tryAgainSelected());
    }

    // Test case for checking if the previousEntry method updates the selected entry correctly
    @Test
    public void testPreviousEntry() {
        GameOver gameOver = new GameOver(100);

        assertTrue(gameOver.tryAgainSelected());

        gameOver.previousEntry();
        assertTrue(gameOver.menuSelected());

        gameOver.previousEntry();
        assertTrue(gameOver.tryAgainSelected());
    }

}

