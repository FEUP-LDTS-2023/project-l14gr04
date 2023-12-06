package RushRoulette.controller.menu;



import RushRoulette.Application;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.controller.Controller;
import RushRoulette.gui.GUI;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu){super(menu);}
    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException{
        switch(action){
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            /*case SELECT:
                if(getModel().exitSelected()) game.setState(null);
                if(getModel().playSelected()) game.setState*/


        }
    }
}
