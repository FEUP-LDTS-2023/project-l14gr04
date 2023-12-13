package RushRoulette.Model.PopUpScreens;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VictoryTest {
    @Test
    public void testNextEntry() {
        Victory victory = new Victory(100); // Assuming a score of 100

        // Initial entry is 0
        assertEquals(0, victory.Entry);

        // Test nextEntry
        victory.nextEntry();
        assertEquals(1, victory.Entry);

        // Test nextEntry beyond the last entry
        victory.nextEntry();
        assertEquals(2, victory.Entry);

        victory.nextEntry();
        assertEquals(0, victory.Entry);
    }

    @Test
    public void testPreviousEntry() {
        Victory victory = new Victory(100); // Assuming a score of 100

        // Initial entry is 0
        assertEquals(0, victory.Entry);

        // Test previousEntry
        victory.previousEntry();
        assertEquals(2, victory.Entry);

        // Test previousEntry beyond the first entry
        victory.previousEntry();
        assertEquals(1, victory.Entry);
    }

    @Test
    public void testGetEntry() {
        Victory victory = new Victory(100); // Assuming a score of 100

        // Test getEntry for the first entry
        assertEquals("Retry", victory.getEntry(0));

        // Test getEntry for a middle entry
        assertEquals("Save", victory.getEntry(1));

        // Test getEntry for the last entry
        assertEquals("Menu", victory.getEntry(2));
    }

    @Test
    public void testIsSelected() {
        Victory victory = new Victory(100); // Assuming a score of 100

        // Initial entry is 0
        assertTrue(victory.isSelected(0));
        assertFalse(victory.isSelected(1));
        assertFalse(victory.isSelected(2));

        // Change entry to 1
        victory.nextEntry();
        assertFalse(victory.isSelected(0));
        assertTrue(victory.isSelected(1));
        assertFalse(victory.isSelected(2));
    }

    @Test
    public void testTryAgainSelected() {
        Victory victory = new Victory(100); // Assuming a score of 100

        // Initial entry is 0
        assertTrue(victory.tryAgainSelected());

        // Change entry to 1
        victory.nextEntry();
        assertFalse(victory.tryAgainSelected());
    }

    @Test
    public void testSaveSelected() {
        Victory victory = new Victory(100); // Assuming a score of 100

        // Initial entry is 0
        assertFalse(victory.saveSelected());

        // Change entry to 1
        victory.nextEntry();
        assertTrue(victory.saveSelected());
    }

    @Test
    public void testMenuSelected() {
        Victory victory = new Victory(100); // Assuming a score of 100

        // Initial entry is 0
        assertFalse(victory.menuSelected());

        // Change entry to 2
        victory.nextEntry();
        victory.nextEntry();
        assertTrue(victory.menuSelected());
    }

    @Test
    public void testGetNumberEntries() {
        Victory victory = new Victory(100); // Assuming a score of 100

        // Assuming there are 3 entries
        assertEquals(3, victory.getNumberEntries());
    }

    @Test
    public void testGetScore() {
        Victory victory = new Victory(150); // Assuming a score of 150

        assertEquals(150, victory.getScore());
    }
}

