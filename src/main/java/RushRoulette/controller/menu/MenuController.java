package RushRoulette.controller.menu;



import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Arena.ArenaBuilder;
import RushRoulette.Model.Game.Arena.LoaderArenaBuilder;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.States.GameState;
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
            case SELECT:
                if(getModel().exitSelected()) application.setState(null);
                if(getModel().playSelected()) application.setState(new GameState(new LoaderArenaBuilder(1).createArena()));


        }
    }
}
