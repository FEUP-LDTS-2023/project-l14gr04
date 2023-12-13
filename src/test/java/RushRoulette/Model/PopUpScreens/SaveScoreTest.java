package RushRoulette.Model.PopUpScreens;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SaveScoreTest {
    @Test
    public void testConstructor() {
        SaveScore saveScore = new SaveScore(100); // Assuming a score of 100
        assertNotNull(saveScore);
        assertEquals(28, saveScore.getNumberEntries()); // Assuming 28 entries
        assertEquals(100, saveScore.getScore());
    }

    @Test
    public void testAddKey() {
        SaveScore saveScore = new SaveScore(100);
        saveScore.addKey("Q");
        assertEquals("Q", saveScore.getNickname());
    }

    @Test
    public void testNextAndPreviousEntry() {
        SaveScore saveScore = new SaveScore(100);

        assertTrue(saveScore.menuSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.nextSelected());

        saveScore.previousEntry();
        assertTrue(saveScore.menuSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.nextSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.qSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.wSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.eSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.rSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.tSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.ySelected());

        saveScore.nextEntry();
        assertTrue(saveScore.uSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.iSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.oSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.pSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.aSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.sSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.dSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.fSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.gSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.hSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.jSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.kSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.lSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.zSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.xSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.cSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.vSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.bSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.nSelected());

        saveScore.nextEntry();
        assertTrue(saveScore.mSelected());


    }

    @Test
    public void testJumpCharDistance() {
        SaveScore saveScore = new SaveScore(100);

        assertTrue(saveScore.menuSelected());

        saveScore.jumpCharDistance(5);
        assertTrue(saveScore.rSelected());

        saveScore.jumpCharDistance(-3);
        assertTrue(saveScore.qSelected());
    }

    @Test
    public void testResetNickname() {
        SaveScore saveScore = new SaveScore(100);
        saveScore.addKey("Q");
        saveScore.resetNickName();
        assertEquals("", saveScore.getNickname());
    }

    @Test
    public void testGetNickNameKeyList() {
        SaveScore saveScore = new SaveScore(100); // Assuming a score of 100
        saveScore.addKey("W");
        saveScore.addKey("E");

        List<String> expectedList = List.of( "Q","W", "E");
        List<String> actualList = saveScore.getNickNameKeyList();

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testGetEntry() {
        SaveScore saveScore = new SaveScore(100); // Assuming a score of 100

        String expectedEntry = "W";
        String actualEntry = saveScore.getEntry(3); // Assuming "W" is at index 3

        assertEquals(expectedEntry, actualEntry);
    }
}
