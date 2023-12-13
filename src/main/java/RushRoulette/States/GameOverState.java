package RushRoulette.States;


import RushRoulette.Model.PopUpScreens.GameOver;
import RushRoulette.Viewer.PopUpScreens.GameOverViewer;
import RushRoulette.Viewer.Viewer;
import RushRoulette.controller.Controller;
import RushRoulette.controller.PopUpScreens.GameOverController;


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
