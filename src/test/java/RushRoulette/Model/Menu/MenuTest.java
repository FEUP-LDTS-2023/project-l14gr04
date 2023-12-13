package RushRoulette.Model.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test
    public void testConstructor() {
        Menu menu = new Menu();
        assertNotNull(menu);
        assertEquals(4, menu.getEntries().size()); // Assuming 4 default entries
        assertTrue(menu.playSelected()); // By default, the first entry (Play) should be selected
    }

    @Test
    public void testNextEntry() {
        Menu menu = new Menu();

        assertTrue(menu.playSelected());

        menu.nextEntry();
        assertTrue(menu.leaderBoardSelected());

        menu.nextEntry();
        assertTrue(menu.instructionsSelected());

        menu.nextEntry();
        assertTrue(menu.exitSelected());

        menu.nextEntry();
        assertTrue(menu.playSelected()); // Cycling back to the first entry
    }

    @Test
    public void testPreviousEntry() {
        Menu menu = new Menu();

        assertTrue(menu.playSelected());

        menu.previousEntry();
        assertTrue(menu.exitSelected());

        menu.previousEntry();
        assertTrue(menu.instructionsSelected());

        menu.previousEntry();
        assertTrue(menu.leaderBoardSelected());

        menu.previousEntry();
        assertTrue(menu.playSelected()); // Cycling back to the last entry
    }

    @Test
    public void testGetEntry() {
        Menu menu = new Menu();

        assertEquals("Play", menu.getEntry(0));
        assertEquals("Leaderboard", menu.getEntry(1));
        assertEquals("Instructions", menu.getEntry(2));
        assertEquals("Exit", menu.getEntry(3));


    }
}
