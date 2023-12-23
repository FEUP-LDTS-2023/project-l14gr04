package Projeto.States;

import Projeto.Model.PopUpScreens.Victory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VictoryStateTest {
    @Test
    public void testConstructor() {
        Victory victoryModel = new Victory(100);
        VictoryState victoryState = new VictoryState(victoryModel);

        assertEquals(victoryModel, victoryState.getModel());
        assertNotNull(victoryState.getViewer());
        assertNotNull(victoryState.getController());
    }
}
