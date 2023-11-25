package Menu;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuChoiceTest {
    @Test
    public void choiceString (){

        String play = MenuItem.Play.toString();
        String exit = MenuItem.Exit.toString();

        assertEquals(play, "Play");
        assertEquals(exit, "Exit");
    }
}
