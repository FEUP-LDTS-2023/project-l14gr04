package RushRoulette.States;

import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.States.GameOverState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameOverStateTest {
    @Test
    public void testConstructor2() {
        GameOver gameOverModel = new GameOver(100);
        GameOverState gameOverState = new GameOverState(gameOverModel);

        assertEquals(gameOverModel, gameOverState.getModel());
        assertNotNull(gameOverState.getViewer());
        assertNotNull(gameOverState.getController());
    }

}
