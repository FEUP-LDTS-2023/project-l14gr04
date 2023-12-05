package Model.Menu;

import Model.Menu.MenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuChoiceTest extends Assertions {
    @Test
    public void choiceString (){

        String play = MenuItem.Play.toString();
        String exit = MenuItem.Exit.toString();

        assertEquals(play, "Play");
        assertEquals(exit, "Exit");
    }
}
