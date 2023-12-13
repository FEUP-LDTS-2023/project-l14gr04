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

}

