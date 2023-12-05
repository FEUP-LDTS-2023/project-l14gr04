package Model.Menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest extends Assertions {
     Menu menu;

    @BeforeEach
    void newMenu(){menu = new Menu();}

    @Test
    void choice(){
        boolean choice1 = menu.inChoice();
        menu.choose();
        boolean choice2 = menu.inChoice();

        assertFalse(choice1);
        assertTrue(choice2);
    }

}
