package Projeto.States;

import Projeto.Model.Menu.Menu;
import Projeto.Viewer.Menu.MenuViewer;
import Projeto.Viewer.Viewer;
import Projeto.controller.Controller;
import Projeto.controller.menu.MenuController;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    public Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    public Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
