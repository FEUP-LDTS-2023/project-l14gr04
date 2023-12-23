package Projeto.States;


import Projeto.Model.PopUpScreens.GameOver;
import Projeto.Viewer.PopUpScreens.GameOverViewer;
import Projeto.Viewer.Viewer;
import Projeto.controller.Controller;
import Projeto.controller.PopUpScreens.GameOverController;


public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    public Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    public Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }

}
