package RushRoulette.States;

import RushRoulette.Model.Menu.Menu;
import RushRoulette.Viewer.Menu.MenuViewer;
import RushRoulette.Viewer.Viewer;
import RushRoulette.controller.Controller;
import RushRoulette.controller.menu.MenuController;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
