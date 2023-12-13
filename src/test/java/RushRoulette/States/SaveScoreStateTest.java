package RushRoulette.States;

import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.Model.PopUpScreens.SaveScore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SaveScoreStateTest {

        @Test
        public void testConstructor() {
            SaveScore saveScoreModel = new SaveScore(100);
            SaveScoreState saveScoreState = new SaveScoreState(saveScoreModel);

            assertEquals(saveScoreModel, saveScoreState.getModel());
            assertNotNull(saveScoreState.getViewer());
            assertNotNull(saveScoreState.getController());
        }


}
