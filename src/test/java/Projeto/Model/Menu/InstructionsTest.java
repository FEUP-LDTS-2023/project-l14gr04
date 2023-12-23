package Projeto.Model.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsTest {
    @Test
    public void testConstructorAndGetter() {
        Instructions instructions = new Instructions();
        assertEquals("Back", instructions.getEntry());
    }

}
