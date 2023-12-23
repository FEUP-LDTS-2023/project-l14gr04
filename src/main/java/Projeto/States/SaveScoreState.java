package Projeto.States;

import Projeto.Model.PopUpScreens.SaveScore;
import Projeto.Viewer.PopUpScreens.SaveScoreViewer;
import Projeto.Viewer.Viewer;
import Projeto.controller.Controller;
import Projeto.controller.PopUpScreens.SaveScoreController;


public class SaveScoreState extends State<SaveScore> {
    public SaveScoreState(SaveScore model) {
        super(model);
    }

    @Override
    public Viewer<SaveScore> getViewer() {
        return new SaveScoreViewer(getModel());
    }

    @Override
    public Controller<SaveScore> getController() {
        return new SaveScoreController(getModel());
    }
}