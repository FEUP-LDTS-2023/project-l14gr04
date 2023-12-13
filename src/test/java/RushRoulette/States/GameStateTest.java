package RushRoulette.States;

import RushRoulette.Model.Game.Arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class GameStateTest {
    private GameState gameState;

    @BeforeEach
    public void setUp() {
        // Mock the Arena object for testing
        Arena mockArena = mock(Arena.class);
        gameState = new GameState(mockArena);
    }

    @Test
    public void testGetModel() {
        // Ensure that the getModel method returns the correct Arena object
        Arena model = gameState.getModel();
        assertEquals(model, gameState.getModel());
    }

    @Test
    public void testGetViewer() {
        // Ensure that the getViewer method returns a non-null ArenaViewer object
        assertNotNull(gameState.getViewer());
    }

    @Test
    public void testGetController() {
        // Ensure that the getController method returns a non-null ArenaController object
        assertNotNull(gameState.getController());
    }
}
