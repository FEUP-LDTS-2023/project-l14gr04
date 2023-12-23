package Projeto.States;

import Projeto.Model.Menu.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MenuStateTest {

        @Test
        public void testConstructor() {
            Menu menuModel = new Menu();
            MenuState menuState = new MenuState(menuModel);

            assertEquals(menuModel, menuState.getModel());
            assertNotNull(menuState.getViewer());
            assertNotNull(menuState.getController());
        }
    }

