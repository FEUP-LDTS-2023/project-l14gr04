package RushRoulette.States;

import RushRoulette.Model.Menu.Instructions;
import RushRoulette.Model.PopUpScreens.GameOver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InstructionsStateTest {
    @Test
    public void testConstructor2() {
        Instructions instructionsModel = new Instructions();
        InstructionsState instructionsState = new InstructionsState(instructionsModel);

        assertEquals(instructionsModel, instructionsState.getModel());
        assertNotNull(instructionsState.getViewer());
        assertNotNull(instructionsState.getController());
    }
}
