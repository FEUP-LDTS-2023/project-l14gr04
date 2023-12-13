package RushRoulette.Model.PopUpScreens;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverTest {
    @Test
    public void testConstructor1() {
        int initialScore = 100;
        GameOver gameOver = new GameOver(initialScore);

        assertEquals(initialScore, gameOver.getScore());
        assertEquals(3, gameOver.getNumberEntries());
        assertTrue(gameOver.tryAgainSelected());
    }


    @Test
    public void testNextEntry() {
        GameOver gameOver = new GameOver(100);

        assertTrue(gameOver.tryAgainSelected());

        gameOver.nextEntry();
        assertTrue(gameOver.saveSelected());

        gameOver.nextEntry();
        assertTrue(gameOver.menuSelected());
    }


    @Test
    public void testPreviousEntry() {
        GameOver gameOver = new GameOver(100);

        assertTrue(gameOver.tryAgainSelected());

        gameOver.previousEntry();
        assertTrue(gameOver.menuSelected());

        gameOver.previousEntry();
        assertTrue(gameOver.saveSelected());
    }

    @Test
    public void testGetEntry() {
        GameOver gameOver = new GameOver(50); // Assuming a score of 50

        // Assuming the entries list contains "Retry", "Save", "Quit"
        String expectedFirstEntry = "Retry";
        String actualFirstEntry = gameOver.getEntry(0);

        assertEquals(expectedFirstEntry, actualFirstEntry);

        // Assuming the entries list contains "Retry", "Save", "Quit"
        String expectedSecondEntry = "Save";
        String actualSecondEntry = gameOver.getEntry(1);

        assertEquals(expectedSecondEntry, actualSecondEntry);
    }

}

