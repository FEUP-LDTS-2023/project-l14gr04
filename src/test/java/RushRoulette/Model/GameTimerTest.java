package RushRoulette.Model;

import RushRoulette.Model.Game.GameTimer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTimerTest {

        @Test
        public void testInitialTime() {
            GameTimer gameTimer = new GameTimer();
            assertEquals(10, gameTimer.getCurrentTime());
        }

        @Test
        public void testUpdateTimer() throws InterruptedException {
            GameTimer gameTimer = new GameTimer();
            // Wait for a little over 10 seconds to ensure timer updates
            Thread.sleep(11000);
            assertTrue(gameTimer.getCurrentTime() < 10 && gameTimer.getCurrentTime() >= 0);
        }

        @Test
        public void testResetTimer() throws InterruptedException {
            GameTimer gameTimer = new GameTimer();
            // Wait for a little over 10 seconds to ensure timer updates
            Thread.sleep(11000);
            assertTrue(gameTimer.getCurrentTime() < 10 && gameTimer.getCurrentTime() >= 0);

            // Reset the timer
            int initialTime = gameTimer.getCurrentTime();
            gameTimer.resetTimer();
            assertEquals(initialTime, gameTimer.getCurrentTime());
        }
    }

