package RushRoulette.States;

import RushRoulette.Model.PopUpScreens.SaveScore;
import RushRoulette.Viewer.PopUpScreens.SaveScoreViewer;
import RushRoulette.Viewer.Viewer;
import RushRoulette.controller.Controller;
import RushRoulette.controller.PopUpScreens.SaveScoreController;


public class SaveScoreState extends State<SaveScore> {
    public SaveScoreState(SaveScore model) {
        super(model);
    }

    @Override
    protected Viewer<SaveScore> getViewer() {
        return new SaveScoreViewer(getModel());
    }

    @Override
    protected Controller<SaveScore> getController() {
        return new SaveScoreController(getModel());
    }
}